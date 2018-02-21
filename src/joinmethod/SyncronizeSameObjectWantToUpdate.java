package joinmethod;

import java.util.concurrent.atomic.AtomicInteger;

public class SyncronizeSameObjectWantToUpdate {

	public static void main(String[] args) throws InterruptedException {
		Counter4 c1 = new Counter4();
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c1);

		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

		System.out.println(c1.getCounter());
	}

}

class Counter4 implements Runnable {
	private Object lock = new Object();
	private AtomicInteger counter = new AtomicInteger(0);


	@Override
	public void run() {
		for (int i = 0; i < 20000; i++) {
			synchronized (counter) {
				counter.incrementAndGet();
						
			}		
		}
	}

	public int getCounter() {
		return counter.intValue();
	}
}
