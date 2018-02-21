import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class UncheckedException {

	public static void main(String[] args) {
		List integers = Arrays.asList(1, 2, 3, 4, 0, 5, 6, 7, 8);
		integers.forEach(System.out::println);
		System.out.println("----------------------------");

		integers.forEach(lambdaExceptionCatchWrapper(i -> System.out.println(100/i)));
	}

	private static Consumer<Integer> lambdaExceptionCatchWrapper(Consumer<Integer> consumer){
		return i -> {
			try{
				consumer.accept(i);
			}catch(ArithmeticException ae){
				System.out.println("Arithmatic Exception "+ ae.getMessage());
			}
		};
	}
}
