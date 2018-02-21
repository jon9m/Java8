package joinmethod;

public class StaticCounter {

	public static void main(String[] args) throws InterruptedException {
		Counter2 c1 = new Counter2();
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c1);
		Thread t3 = new Thread(c1);

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();

		System.out.println(c1.getCounter());
	}

}

class Counter2 implements Runnable {
	
	private static int counter; //Static shared variable

	@Override
	public void run() {
		for (int i = 0; i < 20000; i++) {

			increment(); // This is three step process, load current value,
			// increment and store the new value. can be interrupted inbetween

		}
	}

	public int getCounter() {
		return counter;
	}

	private static synchronized int increment() {  //lock the class
		System.out.println("counter " + counter);
		return counter++;
	}
}
