package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class CacheLRU<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 1L;
	
	
	Integer capacity;
	
	public CacheLRU(Integer capacity) {
		super(capacity+1, 1.f, true);
		this.capacity = capacity;
	}
	
	@Override
	public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return this.size() > capacity;
	}
	
	
}
