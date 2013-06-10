package test;
import java.util.ArrayList;
import java.util.List;



public class Sorting2 {

	public static void bubble(int [] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			boolean swap = false;
			for (int j = 0; j < arr.length-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					swap = true;
				}
			}
			if (!swap) {
				break;
			}
		}
	}
	
	public static void selection(int [] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min_i = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[min_i]) {
					min_i = j;
				}
			}
			if (i != min_i) {
				int tmp = arr[i];
				arr[i] = arr[min_i];
				arr[min_i] = tmp;
			}
		}
	}
	
	public static void insertion(int [] arr) {
		for (int i = 1; i < arr.length; i++) {
			int curr = i;
			for (int j = i-1; j >= 0; j--) {
				if (arr[curr] < arr[j]) {
					int tmp = arr[curr];
					arr[curr] = arr[j];
					arr[j] = tmp;
					curr = j;
				} else {
					break;
				}
			}
		}
	}
	
	public static void quick(int [] arr) {
		_quick(arr, 0, arr.length-1);
	}
	
	public static void _quick(int [] arr, int low, int high) {
		int pivot = arr[high - (high - low) / 2];
		int i = low;
		int j = high;
		while (i <= j) {
			while(arr[i] < pivot) i++;
			while(arr[j] > pivot) j--;
			if (i <= j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		if (low < j) _quick(arr, low, j);
		if (i < high) _quick(arr, i, high);
 	}
	
	public static int [] mergesort(int [] arr) {
		if (arr.length <= 1) {
			return arr;
		}
		
		
		int center = arr.length / 2;
		int [] left = new int[center];
		int [] right = new int[arr.length - center];
		
		for (int i = 0; i < center; i++) {
			left[i] = arr[i];
		}
		
		for (int i = center; i < arr.length; i++) {
			right[i-center] = arr[i];
		}
		
		left = mergesort(left);
		right = mergesort(right);
		
		return merge(left, right);
	}
	
	public static int [] merge(int [] arr1, int [] arr2) {

		int [] res = new int[arr1.length + arr2.length];
		int i = 0, j = 0, curr = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] <= arr2[j]) {
				res[curr++] = arr1[i++];
			} else {
				res[curr++] = arr2[j++];
			}
		}
		
		if (i < arr1.length) {
			while(i < arr1.length) {
				res[curr++] = arr1[i++];
			}
		}
		
		if (j < arr2.length) {
			while(j < arr2.length) {
				res[curr++] = arr2[j++];
			}
		}
		
		return res;
	}
	
	public static int [] radix(int [] arr) {
		int maxRadix = 0;
		int [] res = new int[arr.length];
		int curr = 0;

		List<Integer> notReady = new ArrayList<Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			Integer x = arr[i];
			notReady.add(x);
			maxRadix = Math.max(maxRadix, x.toString().length());
		}
		
		for (int radix = 1; radix <= maxRadix; radix++) {
			List<List<Integer>> map = new ArrayList<List<Integer>>();
			for (int j = 0; j <= 9; j++) {
				map.add(new ArrayList<Integer>());
			}
			
			int pow = (int) Math.pow(10, radix-1);
			for (Integer x : notReady) {
				map.get((x / pow) % 10).add(x);
			}
			
			notReady = new ArrayList<Integer>();
			for (List<Integer> list : map) {
				for (Integer x : list) {
					if (x.toString().length() <= radix) {
						res[curr++] = x;
					} else {
						notReady.add(x);
					}
				}
			}
		}
		
		return res;
	}
	
	public static void main(String [] args) {
		int [] arr = {100, 9, 8, 1, 2, 123111, 12, 333, 5, 1221, 22342};
		arr = radix(arr);
		for (int x : arr) {
			System.out.print(x+" ");
		}
	}
}
