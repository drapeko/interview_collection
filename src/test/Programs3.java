package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Programs3 {

	public static class Node {
		Node next = null;
		Integer val = null;
		public Node(Integer val, Node next) {
			this.val = val;
			this.next = next;
		}
	}

	public static class TreeNode {
		TreeNode left = null;
		TreeNode right = null;
		Integer val = null;
		public TreeNode(Integer val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public static Node middleOfTheList(Node first) {
		Node curr = first;
		Node nextNext = first.next.next;
		do {
			curr = curr.next;
			nextNext = nextNext.next;
			if (nextNext == null) {
				break;
			}
			nextNext = nextNext.next;
		} while (nextNext != null);
		return curr;
	}
	
	public static Boolean twoBinaryTreesAreEqual(TreeNode node1, TreeNode node2) {

		if ((node1 != null && node2 == null) || (node2 != null && node1 == null)) {
			return false;
		} else if (node1 == null && node2 == null) {
			return true; 
		} else if (!node1.val.equals(node2.val)) {
			return false;
		}
		
		twoBinaryTreesAreEqual(node1.left, node2.left);
		twoBinaryTreesAreEqual(node1.right, node2.right);
		Map<Integer, Integer> x = new HashMap<Integer, Integer>();
		
		return true;
	}
	
	// POWER SET!
	public static Set<Set<Integer>> powerSet(Set<Integer> set) {
		List<Integer> list = new ArrayList<Integer>(set);
		
		Set<Set<Integer>> powerset = new HashSet<Set<Integer>>();
		
		long size = 2 << set.size();
		for (long i = 0; i < size; i++) {
			Set<Integer> elm = new HashSet<Integer>();
			for (int j = 0; j < set.size(); j++) {
				if ((i >> j) % 2 == 1) {
					elm.add(list.get(j));
				}
			}
			powerset.add(elm);
		}
		
		return powerset;
	}
	
	// IS BINARY PALNDROME!
	public static boolean isBinaryPalindrome(int x) {
		for (int i = 0; i < 16; i++){
			//System.out.print(" " + (x >> i) % 2);
			if ((x >> i) % 2 != (x >> 31-i) % 2) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String [] args) throws IOException {
		//Node node = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, null))))));
		//System.out.println(middleOfTheList(node).val);
		/*
		Set<Set<Integer>> powerset = powerSet(new HashSet<Integer>(Arrays.asList(1, 2, 3)));
		
		for (Set<Integer> set: powerset) {
			System.out.print("[");
			for (Integer val : set) {
				System.out.print(" " + val);
			}
			System.out.println(" ]");
		}*/
		
		/*
		BufferedReader in = new BufferedReader(new FileReader("/Users/romandrapeko/Documents/workspace/GoogleInterview/resources/1"));
		String s;
		int sum = 0;
		while((s = in.readLine()) != null) {
			sum += Integer.parseInt(s);
		}
		System.out.println(sum);
		*/
		
		System.out.println(10239 * 205 >> 11);
	}
}
