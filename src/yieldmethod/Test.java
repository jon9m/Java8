package yieldmethod;

public class Test {

	public static void main(String[] args) {
		MyThread mt1 = new MyThread();

		Thread t1 = new Thread(mt1, "T1");
		Thread t2 = new Thread(mt1, "T2");

		t1.start();
		t2.start();
	}
}

class MyThread implements Runnable {
	@Override
	public void run() {
		for (int j = 1; j <= 10; j++) {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + "\t" + "i = " + j);
			if ("T1".equals(threadName)) {
				Thread.yield(); //process given to T2 not guaranteed 
			}
		}
	}
}