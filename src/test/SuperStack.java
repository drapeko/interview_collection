package test;

import java.util.ArrayList;
import java.util.List;

public class SuperStack {

	List<Integer> storage = new ArrayList<Integer>();
	Integer minValue = null;
	
	public Integer pop() {
		Integer last = storage.remove((storage.size()-1));
		if (last == minValue) {
			Integer tmp = null;
			for (Integer x : storage) {
				if (tmp == null || tmp > x) {
					tmp = x;
				}
			}
			minValue = tmp;
		}
		
		return last;
	}
	
	public void push(Integer val) {
		storage.add(val);
		if (minValue == null || minValue > val) {
			minValue = val;
		}
	}
	
	public Integer getMinValue() {
		return minValue;
	}
	
	public static void main(String [] args) {
		SuperStack stack = new SuperStack();
		
		stack.push(100);
		stack.push(133);
		stack.push(10);
		stack.push(15);
		
		System.out.println(stack.getMinValue());
		stack.pop();
		stack.pop();
		System.out.println(stack.getMinValue());
	}
}
