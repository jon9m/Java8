import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ListConsumer {

	public static void main(String[] args) {
		List<String> a = new ArrayList<String>();
		a.add("aaa");
		a.add("bbb");
		a.add("ccc");
		a.add("ddd");

//		a.forEach(new MyConsumer());
//		a.forEach((x)-> {System.out.println(x);});
//		a.forEach(System.out::println);
		
		/*Enhanced for loop*/
		for(String x:a){
			System.out.println(x);
		}
	}
}

class MyConsumer<String> implements Consumer<String> {
	@Override
	public void accept(String t) {
		System.out.println(t);
	}
}
