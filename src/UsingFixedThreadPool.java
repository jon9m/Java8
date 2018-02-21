import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingFixedThreadPool {

	static List done = new ArrayList();
	
	private static final class CountTask implements Runnable {
		int id;
		
		public CountTask(int id) {
			this.id = id;
		}
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				System.out.println(done.toString() + " Count task "+ this.id +" count " + (i + 1));
				if(i == 0){
					done.add(id);
				}
			}
			
		}
	}

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(9);
		
		es.execute(new CountTask(1));
		es.execute(new CountTask(2));
		es.execute(new CountTask(3));
		es.execute(new CountTask(4));
		es.execute(new CountTask(5));
		es.execute(new CountTask(6));
		es.execute(new CountTask(7));
		es.execute(new CountTask(8));
		es.execute(new CountTask(9));
		
		es.shutdown();
	}
}
