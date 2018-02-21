package volatile_keyword;

public class VolatileInMulticore {

//	public static volatile boolean running = false;
	public static boolean running = false;

	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {
			public void run() {
				while (!running) {
					//System.out.println("Not running");
				}
				System.out.println("Started running..........");

				while (running) {
					//System.out.println("Running");
				}
				System.out.println("Stopped running..........");
			}
		}).start();
		
		Thread.sleep(1000);
		System.out.println("Starting in main");
		running = true;
		
		Thread.sleep(1000);
		System.out.println("Stopped in main");
		running = false;
	}
}
