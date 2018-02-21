import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool {

	static List done = new ArrayList();
	
	private static final class CountTask implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				System.out.println(done.toString() + " Count task "+ Thread.currentThread().getId() +" count " + (i + 1));
				if(i == 0){
					done.add(Thread.currentThread().getId());
				}
			}			
		}
	}

	public static void main(String[] args) {
		ExecutorService es = Executors.newSingleThreadExecutor();
		
		es.execute(new CountTask());
		es.execute(new CountTask());
		es.execute(new CountTask());
		es.execute(new CountTask());
		es.execute(new CountTask());
		es.execute(new CountTask());
		es.execute(new CountTask());
		es.execute(new CountTask());
		es.execute(new CountTask());
		
		es.shutdown();
	}
}
