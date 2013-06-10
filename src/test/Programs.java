package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Programs {

	// Zadacha kotoruju oni v video sprashivali pro slovar'
	public static String words(String sentence, Set<String> dictionary) {
		String newSentence = "";
		String word = "";
		for (int i = 0; i < sentence.length(); i++) {
			word += sentence.charAt(i);
			if (dictionary.contains(word)) {
				newSentence += word + " ";
				word = "";
			}
		}
		return newSentence.substring(0, newSentence.length() - 1);
	}
	
	// drugoje reshenije
	public static String words2(String sentence, Set<String> dictionary) {
		String newSentence = sentence;
		for(String w : dictionary) {
			newSentence = newSentence.replaceAll(w, w + " ");
		}
		return newSentence;
	}
	
	// Zamenit' vse jachejki excel na ih cifry
	public static Integer excel(String name) {
		String upper = name.toUpperCase();
		Integer col = 0;
		Integer unit = 0;
		for (int i = upper.length() - 1; i >= 0; i--) {
			col = col + ((upper.charAt(i) - 64) * (int)Math.pow(26, unit));
			unit++;
		}
		return col;
	}
	
	// Random K List
	public static Integer[] randomK(List<Integer> randomList, Integer N) {
		Integer [] random = new Integer[N];
		
		Integer k = 0;
		for (Integer val : randomList) {
			if (k < N) {
				random[k] = val;
			} else {
				Integer idx = ((int)(Math.random() * 1000000) % (k+1));
				if (idx < N) {
					random[idx] = val;
				}
			}
			k++;
		}
		
		return random;
	}
	
	// min in circular list
	public static Integer circularList(List<Integer> list) {
		Integer min = null;
		for (Integer a : list) {
			if (min == null) {
				min = a;
			} else {
				if (a < min) {
					return a;
				}
			}
		}
		return min;
	}
	
	public static Integer min(Integer val1, Integer val2) {
		if (val1 > val2) {
			return val2;
		}
		return val1;
	}
	
	// circular array otbrasyvaem otsortirovannuju chast'
	public static Integer circularArray(Integer [] array, Integer min, Integer max) {
		Integer minVal = array[min];
		
		if (max <= min) {
			return minVal;
		} else {
			Integer middle = (min + max) / 2;
			
			if (array[min] > array[middle]) {
				return min(minVal, circularArray(array, min, middle));
			} else {
				return min(minVal, circularArray(array, middle+1, max));
			}
		}
	}
	
	
	// reverse string
	public static String reverseString(String s) {
		StringBuilder b = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			b.append(s.charAt(s.length()-i-1));
		}
		return b.toString();
	}
	
	// division
	public static Integer division(Integer x, Integer y) {
		Integer count = -1;
		Integer sum = 0;
		while(sum < x) {
			count++;
			sum += y;
		}
		return count;
	}
	
	// permutations in string
	public static void permutations(String beginning, String end) {
		if (end.length() <= 1) {
			System.out.println(beginning + end);
		} else {
			for (int i = 0; i < end.length(); i++) {
				String newString = end.substring(0, i) + end.substring(i + 1);
				permutations(beginning + end.charAt(i), newString);
			}			
		}
	}
	
	private static int nvl(Integer [] array, Integer idx, Integer def) {
		if (idx < 0) {
			return def;
		} else if (idx >= array.length) {
			return def;
		}
		if (array[idx] == null) {
			return def;
		}
		return array[idx];
	}
	
	public static Integer [] multiplyArray(Integer [] array) {
		Integer [] result = new Integer [array.length];
		Integer [] before = new Integer [array.length];
		Integer [] after = new Integer [array.length];
		
		before[0] = 1;
		for (int i = 1; i < array.length; i++) {
			before[i] = nvl(before, i-1, 1) * array[i-1]; 
		}
		
		after[array.length-1] = 1;
		for (int i = array.length-2; i >= 0; i--){
			after[i] = nvl(after, i+1, 1) * after[i+1];
		}
		
		for (int i = 0; i < array.length; i++) {
			result[i] = before[i] * after[i];
		}
		
		return result;
	}
	
	public static Integer [] selectIntegers(List<Integer> list, Integer N) {
		Integer [] result = new Integer [N];
		int k = 0;
		for (Integer val : list) {
			if (k < N) {
				result[k] = val;
			} else {
				int c = ((int)(Math.random() * 100000)) % (k+1);
				if (c < N) {
					result[c] = val;
				}
			}
			k++;
		}
		
		return result;
	}
	
	public static List<Integer> mergeSort(List<Integer> asc, List<Integer> desc) {
		List<Integer> result = new ArrayList<Integer>();

		int i = 0;
		int j = desc.size() - 1;

		while (i < asc.size() && j >= 0) {
			if (asc.get(i) < desc.get(j)) {
				result.add(asc.get(i));
				i++;
			} else {
				result.add(desc.get(j));
				j--;
			}
		}

		while (i < asc.size()) {
			result.add(asc.get(i));
			i++;
		}

		while (j >= 0) {
			result.add(desc.get(j));
			j--;
		}

		return result;
	}
	
	public static void main(String [] args) {
		//System.out.println(circularList(Arrays.asList(7,8,19,1,2,4,5)));
		//System.out.println(circularList(Arrays.asList(1, 2, 3, 4, 5)));
		/*
		Integer [] arr = {9, 10, 11, 12, 13, 111, 2, 3, 4, 5};
		System.out.println(circularArray(arr, 0, 8));
		
		Integer [] arr2 = {89, 22, 23, 44, 11, 1, 2, 3, 4, 5, 6, 112, 33};
		quick(arr2, 0, arr2.length-1);
		System.out.println(arr2);
		for (Integer i : arr2) {
			System.out.print(i + " ");
		}
		System.out.println("\n\n");
		System.out.println(binary(arr2, 0, arr2.length-1, 44));
		*/
		//Integer [] arr2 = {89, 22, 23, 44, 11, 1, 2, 3, 4, 5, 6, 112, 33};
		//quick(arr2, 0, arr2.length-1);

		//System.out.println(binarySearchLoop(arr2, 1));
		
		//System.out.println(reverseString("abcdefg"));
		//String [] arr = {"ananas", "arbuz", "axk", "axx", "azbuka"};
		//System.out.println(binaryWord(arr, 0, 4, "axx2"));
		/*
		Integer [] arr = {2, 3, 5, 4, 1};
		Integer [] result = multiplyArray(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.println(" i=" + i + " arr="+arr[i] + " result=" + result[i]);
		}*/
		/*
		Integer [] selected = selectIntegers(Arrays.asList(1, 2, 23, 22, 34, 44, 55, 1, 22 ,444), 3);
		for (Integer i : selected) {
			System.out.print(" " + i);
		}*/
		
		/*int [] arrIn = {8393, 22, 33, 1, 990, 8, 23, 45, 823, 22, 3467, 11};
		int [] arr = radixSort(arrIn);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}*/
		
		List<Integer> result = mergeSort(Arrays.asList(1, 5, 8, 9, 15, 20), Arrays.asList(100, 20, 5, 3, 2));
		for (Integer val : result) {
			System.out.println(val);
		}
	}
	
}
