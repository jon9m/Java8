package volatile_keyword;

public class VolatileInMulticore2 {

	// public static volatile boolean running = false;
	public volatile int a = 0;
	
	//ints are 4 bytes long. CPU doesnt access cache byte by byte but one cache line at a time
	//volatile make CPU reads main memory and CPU access by one thread at a time blocks other threads from updating it
	//cache line in this cpu is 64 bytes long and a and b variables fits in to the same cache line
	//so each core has to wait other core to release the lock
	//Dummy variabels prevent a and b reside in the same cache line
	public volatile long p = 0;
	public volatile long q = 0;
	public volatile long r = 0;
	public volatile long s = 0;
	public volatile long t = 0;
	public volatile long u = 0;
	public volatile long v = 0;
	
	public volatile int b = 0;

	private static long lastA = 0;
	private static long lastB = 0;

	public static void main(String[] args) throws InterruptedException {
		
		final VolatileInMulticore2 instance = new VolatileInMulticore2();
		
		new Thread(new Runnable() {
			public void run() {
				lastA = System.nanoTime();
				while (true) {
					instance.a++;
					if (instance.a % 100000000 == 0) {
						System.out.println("A " + (System.nanoTime() - lastA) / 1000000 + " ms");
						lastA = System.nanoTime();
						instance.a = 0;
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				lastB = System.nanoTime();
				while (true) {
					instance.b++;
					if (instance.b % 100000000 == 0) {
						System.out.println("B " + (System.nanoTime() - lastB) / 1000000 + " ms");
						lastB = System.nanoTime();
						instance.b = 0;
					}
				}
			}
		}).start();
	}
}
