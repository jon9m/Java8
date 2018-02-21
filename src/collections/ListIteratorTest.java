package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("ab");
		list.add("abc");
		list.add("abcd");
		list.add("abcde");
		list.add("abcdef");

		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			String val = (String) itr.next();
			if(val.equals("abcdef")) {
//				itr.remove();
//				list.remove("abcdef");
			}
		}
		
		ListIterator itr2 = list.listIterator();
		while (itr2.hasNext()) {			
			String val = (String) itr2.next();
//			if(val.equals("abcdef")) {
				itr2.add("abcdefg");
//				list.remove("abcdef");
//			}
		}
		
		System.out.println(list);
	}

}
