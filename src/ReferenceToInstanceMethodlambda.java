import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ReferenceToInstanceMethodlambda {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("emp1", "emp1@cmp.com", "100"));
		empList.add(new Employee("emp3", "emp3@cmp.com", "300"));
		empList.add(new Employee("emp5", "emp5@cmp.com", "500"));
		empList.add(new Employee("emp2", "emp2@cmp.com", "200"));
		empList.add(new Employee("emp4", "emp4@cmp.com", "400"));

		List<String> namesList = ReferenceToInstanceMethodlambda.getEmployeeNames(empList, Employee::getName);
		namesList.forEach(System.out::println);
	}

	public static List<String> getEmployeeNames(List<Employee> emplist, Function<Employee, String> f) {
		List<String> nameslist = new ArrayList<String>();
		emplist.forEach((p) -> nameslist.add(f.apply(p)));
		return nameslist;
	}
}
