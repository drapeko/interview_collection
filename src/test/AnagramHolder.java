package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;


public class AnagramHolder {
	static class ComparatorReverse implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			return -1 * arg0.compareTo(arg1);
		}
		
	}
	
	Map<String, SortedSet<String>> map = new HashMap<String, SortedSet<String>>();

	public void add(String word) {
		char [] chars = word.toCharArray();
		Arrays.sort(chars);
		String key = new String(chars);
		if (!map.containsKey(key)) {
			SortedSet<String> set = new TreeSet<String>(new ComparatorReverse());
			set.add(word);
			map.put(key, set);
		} else {
			map.get(key).add(word);
		}
	}
	
	public static void main(String [] args) {
		AnagramHolder holder = new AnagramHolder();
		holder.add("abcde");
		holder.add("abc");
		holder.add("bcdea");
		
		for (Entry<String, SortedSet<String>> x : holder.map.entrySet()) {
			System.out.println();
			for (String s : x.getValue()) {
				System.out.print(" " + s);
			}
		}
	}
}