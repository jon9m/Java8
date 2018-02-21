package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<String> task = new Callable<String>() {

			@Override
			public String call() throws Exception {		
				Thread.sleep(3000);
				return "Callable tast completed...!";
			}
		};
		
		ExecutorService ex = Executors.newSingleThreadExecutor();
		Future<String> future = ex.submit(task);
		
		
		
		//if(future.isDone()){
			System.out.println(future.get());
		//}
		
		System.out.println("Shutting down...");
		ex.shutdown();
	}
}