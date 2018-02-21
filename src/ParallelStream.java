import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStream {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10000; i++) {
			list.add("Num " + i);
		}

//		 list.stream().forEach(a -> doProcess(a));
//		list.parallelStream().forEach((a) -> doProcess(a));
		
		List<String> resultList = list.parallelStream().map(a -> a.toUpperCase()).collect(Collectors.toList());
		System.out.println(resultList);

		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);

	}

	private static void doProcess(String a) {
		System.out.println(a.toUpperCase());
	}
}
