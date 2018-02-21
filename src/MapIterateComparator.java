import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MapIterateComparator {

	public static void main(String[] args) {
		List<Employee> alist = new ArrayList<Employee>();
		alist.add(new Employee("E", "e", "5"));
		alist.add(new Employee("D", "d", "4"));
		alist.add(new Employee("C", "c", "1"));
		alist.add(new Employee("A", "a", "2"));
		alist.add(new Employee("B", "b", "3"));

		/*Collections.sort(alist, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		});*/
		
//		Collections.sort(alist, (e1, e2)->e1.getName().compareTo(e2.getName()));
		Collections.sort(alist, (e1, e2)->{return e1.getName().compareTo(e2.getName());});

		alist.forEach((v) -> System.out.println(v));
	}

}
