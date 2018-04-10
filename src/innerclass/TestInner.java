package innerclass;

public class TestInner {

	public static void main(String[] args) {
		new TestInner().display();
	}

	public void display() {

		int finalData = 2000;  //Final by default

		class InnerClass {
			private int innerData = 1000;

			private void invoke() {
				System.out.println("Inner data " + innerData);
				System.out.println("Final data " + finalData);  //Final because of this line
			}
		}

		new InnerClass().invoke();
	}

}
