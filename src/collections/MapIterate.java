package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;

public class MapIterate {

	public static void main(String[] args) {
		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("1", "1");
		myMap.put("2", "10");
		myMap.put("3", "100");
		myMap.put("4", "1000");
		myMap.put("5", "10000");
		myMap.put("6", "100000");

		System.out.println("--------------Entry set-------------------");
		Set<Entry<String, String>> entrySet = myMap.entrySet();
		for (Map.Entry<String, String> entry : entrySet) {			//Entry set
			System.out.print("Key " + entry.getKey());
			System.out.println("\tValue " + entry.getValue());
		}
		System.out.println("--------------Key set-------------------");
		for (String key : myMap.keySet()) {							//Key set
			System.out.print("Kye " + key);
			System.out.println("\tValue " + myMap.get(key));
		}
		System.out.println("---------------Values ------------------");
		for (String value : myMap.values()) {						//Values
			System.out.println("Value " + value);
		}
		
		System.out.println("--------------ForEach BiConsumer-------------------");
		myMap.forEach(new BiConsumer<String, String>() {
			@Override
			public void accept(String key, String value) {
				System.out.print("Key " + key);
				System.out.println("\tValue " + value);
			}
		});
		
		System.out.println("--------------ForEach BiConsumer Lambda-------------------");
		myMap.forEach((k, v) -> {
			System.out.print("Key " + k);
			System.out.println("\tValue " + v);
		});

	}

}
