
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelAdder {

	public static int NUM_COUNT = 10000;

	public Integer parallelSum()

	{

		long t1 = System.nanoTime();

		ExecutorService executor = Executors.newFixedThreadPool(10);

		List<Future<Integer>> list = new ArrayList<Future<Integer>>();

		int count = 1;

		int prev = 0;

		for (int i = 0; i < NUM_COUNT; i++)

		{

			if (count % 2 == 0)// grouping

			{

//				System.out.println("Prev :" + prev + " current: " + i);

				Future<Integer> future = executor.submit(new CallableAdder(prev, i));

				list.add(future);

				count = 1;

				continue;

			}

			prev = i;

			count++;

		}

		int totsum = 0;

		for (Future<Integer> fut : list)

		{

			try {

				totsum = totsum + fut.get();

			} catch (InterruptedException e) {

				e.printStackTrace();

				// TODO Auto-generated catch block

				e.printStackTrace();

			} catch (ExecutionException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}

		System.out.println("Total Sum is " + totsum);

		long t2 = System.nanoTime();
		
		System.out.println("parallel t1 : "  + t1 + " - t2 : "  + t2);
		
		
		long diff = (t2 - t1);

		System.out.println("*Time taken by parallelSum " + diff);

		return totsum;

	}

	public int sequentialSum()

	{

		long t3 = System.nanoTime();

		Integer totsum = 0;

		for (int i = 0; i < NUM_COUNT; i++)

		{

			totsum = totsum + i;

		}

		long t4 = System.nanoTime();

		System.out.println("sequentialSum Total Sum is " + totsum);
		System.out.println("Seq t1 : "  + t3 + " - t2 : "  + t4);

		long diff = (t4 - t3);
		System.out.println("*Time taken by sequentialSum " + diff);

		return totsum;

	}

	public static void main(String[] args) {

		ParallelAdder adder = new ParallelAdder();

		long startTime1 = System.nanoTime();
		int pSum = adder.parallelSum();
		long endTime1 = System.nanoTime();

		long startTime2 = System.nanoTime();
		int sSum = adder.sequentialSum();
		long endTime2 = System.nanoTime();

		System.out.println("**** Time of seqential sum = " + (endTime2 - startTime2));
		System.out.println("**** Time of  parallel sum = " + (endTime1 - startTime1));

		System.out.println("parallel Sum equals to Sequential Sum ? ");
		System.out.println("Answer is :: " + (pSum == sSum));

	}

}

class CallableAdder implements Callable<Integer> {

	Integer operand1;

	Integer operand2;

	CallableAdder(Integer operand1, Integer operand2)

	{

		this.operand1 = operand1;

		this.operand2 = operand2;

	}

	public Integer call() throws Exception {
//		System.out.println(Thread.currentThread().getName() + " says : partial Sum for " + operand1 + " and " + operand2
//				+ " is " + (operand1 + operand2));

		return operand1 + operand2;

	}

}