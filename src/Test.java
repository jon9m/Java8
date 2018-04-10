import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Test {

	public static void main(String[] args) {
		try {
			int a = 10;
			int x = a / 0;
		}catch(Exception e) {
			System.out.println("a");
		}finally {
			System.out.println("f");
		}
	}

	
}
