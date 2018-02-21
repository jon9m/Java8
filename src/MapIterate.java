import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class MapIterate {

	public static void main(String[] args) {
		Map<Integer, Employee> map = new HashMap<Integer, Employee>();
		map.put(111, new Employee("S", "s", "1"));
		map.put(222, new Employee("J", "j", "2"));
		map.put(333, new Employee("P", "p", "3"));

		Set<Entry<Integer, Employee>> items = map.entrySet();
		for (Entry<Integer, Employee> item : items) {
			System.out.println(item.getKey());
			System.out.println(item.getValue());
		}
		System.out.println("-------------------------------");
		Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			System.out.println(map.get(key));
		}
		System.out.println("-------------------------------");

		map.forEach(new BiConsumer<Integer, Employee>() {
			@Override
			public void accept(Integer t, Employee u) {
				System.out.println(t);
				System.out.println(u);
			}
		});
		System.out.println("-------------------------------");
		map.forEach((k, v)-> System.out.println(k + ":" + v));
	}

}
