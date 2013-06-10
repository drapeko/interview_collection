package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programs2 {
	
	public static String [] ic(String [] arr, Integer distinct) {
		String [] result = new String [arr.length];
		
		int perGroup = arr.length / distinct;
		for (int i = 0; i < arr.length; i++) {
			int group = i / perGroup;
			int newIdx = distinct * i - group * (arr.length-1);
			result[newIdx] = arr[i];
		}
		
		return result;
	}
	
	public static Integer maxGlobalIncreaseDecreaseSeq(List<Integer> list) {
		int min = list.get(0);
		int max = list.get(0);
		
		for (Integer val : list) {
			if (val > max) {
				max = val;
			} else if (val < min) {
				min = val;
			}
		}
		
		return Math.abs(max - min);
	}
	
	public static Integer maxLocalIncreaseDecreaseSeq(List<Integer> list) {
		Integer res = null;
		Integer prevVal = null;
		for (Integer val : list) {
			if (prevVal != null) {
				int diff = Math.abs(val - prevVal);
				if (res == null || res < diff) {
					res = diff;
				}
			}
			prevVal = val;
		}
		return res;
	}
	
	
	// Substring naive algorithm
	public static int substrStupid(String s, String match) {

		int matched = 0;
		for (int m = 0; m < s.length(); m++) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(m+i) == match.charAt(i)) {
					matched++;
				} else {
					matched = 0;
					break;
				}
				if (matched == match.length()) {
					return m;
				}
			}
		}

		return -1;
	}
	
	public static int conitinousIncreasingSeq(List<Integer> array) {
		int superMax = 0;
		int max = 1;
		
		int prev = array.get(0);
		for (int i = 1; i < array.size(); i++) {
			if (prev < array.get(i)) {
				max++;
			} else {
				max = 1;
				if (max > superMax) {
					superMax = max;
				}
			}
			prev = array.get(i);
		}
		
		if (max > superMax) {
			superMax = max;
		}
		
		return superMax;
	}
	

	public static Integer getBinaryIdx(List <Integer> arr, Integer target) {
		Boolean found = false;
		int low = 0;
		int high = arr.size() - 1;
		
		while (low != high) {
			int mid = low + (high - low) / 2;
			if (arr.get(mid) >= target) {
				found = true;
				high = mid;
			} else {
				low = mid+1;
			}
			System.out.println(" " + low + " " + high);
		}
		
		if (found) {
			return low;
		}
		return null;
	}
	
	// Increasing subsequence in array
	public static void increasingSeubseq(Integer [] arr) {
		List<Integer> subsequence = new ArrayList<Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				subsequence.add(arr[i]);
			} else {
				Integer foundIdx = getBinaryIdx(subsequence, arr[i]);
				/*Integer foundIdx = null;
				for (int j = 0; j < subsequence.size(); j++) {
					if (arr[i] <= subsequence.get(j)) {
						foundIdx = j;
						break;
					}
				}*/
				if (foundIdx != null) {
					subsequence.set(foundIdx, arr[i]);
				} else {
					subsequence.add(arr[i]);
				}
			}
		}
		
		for (int j = 0; j < subsequence.size(); j++) {
			System.out.print(subsequence.get(j)+ " ");
		}
		
	}
	
	// MAX SUBSEQUENCE
	public static Integer maxSubsequenceBigON(List<Integer> arr) {
		Integer sum = 0;
		Integer maxSum = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (sum < 0) {
				sum = arr.get(i);
			} else {
				sum += arr.get(i);
			}
			
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}
	

	
	public static void main(String [] args) {
		//String [] arr = {"i1", "i2", "i3", "i4", "i5", "c1", "c2", "c3", "c4", "c5"};
		//ic(arr, 2);
		//System.out.println(maxLocalIncreaseDecreaseSeq(Arrays.asList(-10, 3, 5, 100, 2, 4, -10)));;
	
		//System.out.println(substrStupid("eefxeefxzfxzfsdf", "eefxz"));
		//System.out.println(conitinousIncreasingSeq(Arrays.asList(1, 2, 3, 2,4, 5, 6, 7, 8)));
		
		Integer [] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};

		increasingSeubseq(arr);
	}
}
