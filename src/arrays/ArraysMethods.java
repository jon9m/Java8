package arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import joinmethod.SyncronizeSameObjectWantToUpdate;

public class ArraysMethods {

	public static void main(String[] args) {

		Integer[] intArr = { 23, 12, 34, 22, 45, 16, 34, 65, 43 };

		List<Integer> list = Arrays.asList(intArr);

		// for(int i: intArr) {
		// System.out.println(i);
		// }
		// list.forEach(System.out::println);

//		Arrays.sort(intArr);

		list = Arrays.asList(intArr);

		// for(int i: intArr) {
		// System.out.println(i);
		// }
		// list.forEach(System.out::println);

		Stream<Integer> stream = Arrays.stream(intArr);

		stream.forEach(System.out::println);
	}

}
