package test;

import java.util.ArrayList;
import java.util.List;

public class Sorting {
	public static Boolean binary(Integer [] arr, Integer low, Integer high, Integer target) {
		if (high-low < 0) {
			return false;
		} else if (high - low == 0) {
			return arr[high] == target;
		}
		
		int medium = (low + high) / 2;
		if (arr[medium] == target) {
			return true;
		} else if (arr[medium] < target) {
			return binary(arr, medium+1, high, target);
		} else {
			return binary(arr, low, medium-1, target);
		}
	}
	
	public static Boolean binarySearchLoop(Integer [] arr, Integer target) {
		int low = 0; 
		int high = arr.length-1;
		while (low != high) {
			int mid = (low + high) / 2;
			if (arr[mid] == target) {
				return true;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return false;
	}
	
	public static void quick(Integer [] arr, Integer low, Integer high) {
		int pivot = arr[(low + high) / 2];
		int i = low;
		int j = high;
		do {
			while(arr[i] < pivot) i++;
			while(arr[j] > pivot) j--;
			if (i <= j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		} while (i < j);
		if (low < j) quick(arr, low, j);
		if (i < high) quick(arr, i, high);
	}
	
	public static List<List<Integer>> getRadixList() {
		List<List<Integer>> helper = new ArrayList<List<Integer>>(10);
		for (int i = 0; i < 10; i++) {
			helper.add(new ArrayList<Integer>());
		}
		return helper;
	}
	
	public static int [] radixSort(int [] arr) {
		int [] res = new int[arr.length];
		int max = 1;
		
		List<List<Integer>> list = getRadixList();
		for (int i = 0; i < arr.length; i++) {
			int last = arr[i] % 10;
			list.get(last).add(arr[i]);
			int digits = Integer.toString(arr[i]).length();
			if (max < digits) {
				max = digits;
			}
		}
		
		for (int radix = 1; radix < max; radix++) {
			List<List<Integer>> nextList = getRadixList();
			for (int i = 0; i < 10; i++) {
				for (Integer val : list.get(i)) {
					int last = (val / (int)Math.pow(10, radix)) % 10;
					System.out.println(radix + " " + val + " " + last);
					nextList.get(last).add(val);
				}
			}
			list = nextList;
		}
		
		int k = 0;
		for (int i = 0; i < 10; i++) {
			for (Integer val : list.get(i)) {
				res[k] = val;
				k++;
			}
		}		
		return res;
	}
	
	public static Boolean binaryWord(String [] array, Integer low, Integer high, String word) {

		if (high - low < 0) {
			return false;
		} else if (high - low == 0) {
			return array[high].equals(word);
		}
		
		int medium = (high + low) / 2;
		
		int cmp = array[medium].compareTo(word);
		if (cmp == 0) {
			return true;
		} else if (cmp > 0) {
			return binaryWord(array, low, medium-1, word);
		} else {
			return binaryWord(array, medium+1, high, word);
		}
	}
}
