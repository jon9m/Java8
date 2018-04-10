import java.util.ArrayList;
import java.util.List;

public class LambdaTest_Type_Inference {

	public static void main(String[] args) {
		List<Employee> alist = new ArrayList<Employee>();
		alist.add(new Employee("E", "e", "5"));
		alist.add(new Employee("D", "d", "4"));
		alist.add(new Employee("C", "c", "1"));
		alist.add(new Employee("A", "a", "2"));
		alist.add(new Employee("B", "b", "3"));
		
		
		MyComprator comprator = (a,b)->{System.out.println(a + " : " + b); return a>b;};

		System.out.println(comprator.compare(30, 20));
		
	}
}

interface MyComprator {
	boolean compare(int a, int b);
}
