package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EnhancedForLoopComparison {

	public static void main(String[] args) {

//		List<Integer> myList = new ArrayList<Integer>();
		List<Integer> myList = new LinkedList<Integer>();
		for (int i = 0; i < 100000; i++) {
			myList.add(i);
		}
		// ------------------------------------------------

		long advanced_timeElapsed, iterating_timeElapsed, simple_timeElapsed;
		long first = System.nanoTime();

		for (Integer i : myList) {
			Integer b = i;
		}
		long end = System.nanoTime();
		advanced_timeElapsed = end - first;
		System.out.format("Time for Advanced for loop:\t\t%10d", advanced_timeElapsed);
		first = System.nanoTime();
		Iterator<Integer> it = myList.iterator();
		while (it.hasNext()) {
			Integer b = it.next();
		}
		end = System.nanoTime();
		iterating_timeElapsed = end - first;
		System.out.format("\nTime for Iterating Loop:\t\t%10d", iterating_timeElapsed);
		first = System.nanoTime();
		int counter = 0;
		int size = myList.size();
		while (counter < size) {
			myList.get(counter);
//			Integer b = myList.get(counter);
			counter++;
		}
		end = System.nanoTime();
		simple_timeElapsed = end - first;
		System.out.format("\nTime for Simple Loop:\t\t\t%10d", simple_timeElapsed);

	}

}
