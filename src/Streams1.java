import java.util.Arrays;
import java.util.stream.Stream;

public class Streams1 {

	public static void main(String[] args) {
		String arr[] = { "AA", "BB", "CC" };
		Stream<String> stream =  Arrays.stream(arr);
		stream.forEach(System.out::println);
		
		Stream stream2 = Stream.of("AA", "BB", "CC");
		stream2.forEach(System.out::println);
	}

}
