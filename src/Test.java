import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Test {

	public static void main(String[] args) {
		List a = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
		

		
		a.add(10);
	
		a = Test.squire(a, Integer::new);
		
		a.forEach(System.out::println);
	}

	public static List<Integer> squire(List<Integer> list, Function<Integer, Integer> f) {
		List<Integer> squirelist = new ArrayList();
		list.forEach((x) -> squirelist.add(f.apply(x) * f.apply(x)));

		return squirelist;
	}
}
