
public class LambdaTest {

	public static void main(String[] args) {
		// Runnable r = () -> {
		// System.out.println("Ran...");
		// };
		
		Thread t = new Thread(() -> { System.out.println("Ran...1"); });
//		Thread t2 = new Thread(System.out::println);
		Thread t2 = new Thread(LambdaTest::printMessage);
//		Thread t2 = new Thread(()->System.out.println());
		t.start();
		t2.start();

	}
	
	public static void printMessage() {
		System.out.println("Ran...2");

		Interface1 interface1 = (String name) -> {
			System.out.println(name);
		};
		interface1.method1("aaaaa");

		Runnable interface2 = () -> {
			System.out.println("interface 2");
		};
		new Thread(interface2).start();
	}
}
