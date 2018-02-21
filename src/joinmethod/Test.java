package joinmethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		Counter c1 = new Counter();
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c1);

		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

		System.out.println(c1.getCounter());
	}

}

class Counter implements Runnable {
	private Object lock = new Object();
	private int counter = 0;

	@Override
	public void run() {
		for (int i = 0; i < 20000; i++) {
			synchronized (lock) {
				counter++; 	// This is three step process, load current value,
							// increment and store the new value. can be interrupted inbetween 
			}		
		}
	}

	public int getCounter() {
		return counter;
	}
}
