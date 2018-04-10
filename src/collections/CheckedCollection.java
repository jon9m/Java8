package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CheckedCollection {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("a");
		list.add("c");
		list.add("b");
		list.add(2);
		list.add(3);

		Collection checkedCollection = Collections.checkedCollection(list, String.class);
		
		checkedCollection.add(1);

		for (Object s : checkedCollection) {
			System.out.println(s);
		}
	}
}
