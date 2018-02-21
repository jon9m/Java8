import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Streams2_map {
	public static void main(String[] args) {
		
		int[] numbers = { 2, 6, 3, 7, 8, 9, 12 };

		List<Integer> numList = new ArrayList<Integer>();
		numList.add(new Integer(2));
		numList.add(new Integer(5));
		numList.add(new Integer(3));
		
//		Function<Integer, Integer> squire = x -> x * x;
		
		numList.stream().map(x -> squire(x)).forEach(System.out::println);
		
		
		// List<String> alpha = Arrays.asList("a", "b", "c", "d");
		// List<String> squires = alpha.stream().map(x ->
		// x.toUpperCase()).collect(Collectors.toList());
		// System.out.println(Arrays.toString(squires.toArray()));
		
	}

	private static Integer squire(Integer a) {
		return a * a;
	}
}