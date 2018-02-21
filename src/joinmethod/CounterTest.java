package joinmethod;

public class CounterTest {

	public static void main(String[] args) throws InterruptedException {
		Counter1 c1 = new Counter1();
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

class Counter1 implements Runnable {

	private Integer counter = new Integer(0);
	private Integer counter2 = new Integer(0);

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

	private int increment() { // lock the class
		synchronized (counter2) {
			return counter++;
		}
	}
}
