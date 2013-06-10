package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSum {

	public static Integer maxSubsequence(List<Integer> arr) {
		int maxSum = arr.get(0);
		int maxStart = 0;
		int maxEnd = 0;
		int sum;
		for (int i = 0; i < arr.size(); i++) {
			sum = 0;
			for (int j = i; j < arr.size(); j++) {
				sum += arr.get(j);
				
				if (sum > maxSum) {
					maxStart = i;
					maxEnd = j;
					maxSum = sum;
				}
			}

		}
		return maxSum;
	}
	
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
	
	public static Integer [] getEmptySequence(int N) {
		Integer [] sequence = new Integer [N];
		for (int z = 0; z < sequence.length; z++) {
			sequence[z] = 0;
		}
		return sequence;
	}
	
	public static Integer sumMatrix(Integer [] [] matrix) {
		Integer iSave = 0;
		Integer jSave = 0;
		Integer sum = matrix[0][0];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix.length; j++) {
				Integer [] sequence = getEmptySequence(matrix.length);

				for (int k = i; k <= j; k++) {
					for (int l = 0; l < matrix.length; l++) {
						sequence[l] += matrix[k][l];
					}
				}

				int tempSum = maxSubsequenceBigON(Arrays.asList(sequence));
				if (tempSum > sum) {
					iSave = i;
					jSave = j;
					sum = tempSum;
				}

			}

		}
		System.out.println(iSave + ": " + jSave);
		return sum;
	}
	
	public static void main(String [] args) {
		//System.out.println(maxSubsequence(Arrays.asList(-2, 11, -4, 13, -5, -2)));
		//System.out.println(maxSubsequenceBigON(Arrays.asList(-2, 11, -4, 13, -5, -2)));

		Integer [] [] matrix = {
			{-19, -22, -13, -4}, 
			{-7, -8, 11, -24}, 
			{2,  3,   5, 9}, 
			{-19, -22, 5, 10}
		};
		
		System.out.println(sumMatrix(matrix));
	}
	
}
