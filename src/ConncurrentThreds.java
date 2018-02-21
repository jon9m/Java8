public class ConncurrentThreds {
	static int[] array = { 0 };

	public static void main(String[] args) throws InterruptedException {

		ConncurrentThreds conncurrentThreds = new ConncurrentThreds();

		Thread a = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100000; i++) {
					conncurrentThreds.increase();
				}
			}
		});

		Thread b = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100000; i++) {
					conncurrentThreds.decrease();
				}
			}
		});

		a.start();
		b.start();

		a.join();
		b.join();

		System.out.println(array[0]);
	}

	public synchronized void increase() {
		//synchronized (array) {
			array[0]++;
		//}
	}

	public synchronized void decrease() {
		//synchronized (array) {
			array[0]--;
		//}
	}

}
