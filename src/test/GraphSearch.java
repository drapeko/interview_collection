package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class GraphSearch {

	private static class Node {
		private List<Node> children = new ArrayList<Node>();
		private Node previous = null;
		private String name;
		
		public Node(String name, Node...nodes) {
			this.name = name;
			for (Node node : nodes) {
				children.add(node);
			}
		}
		
		@Override
		public String toString() {
			return name;
		}

	}
	
	public static Boolean depthFirstPreOrderGoalSearch(Node parent, Node goal) {
		if (parent.equals(goal)) {
			return true;
		}
		for (Node child : parent.children) {
			child.previous = parent;
			Boolean found = depthFirstPreOrderGoalSearch(child, goal);
			if (found) {
				return true;
			}
		}
		return false;
	}
	
	public static void depthFirstPreOrder(Node parent) {
		System.out.print(" " + parent.name);
		for (Node child : parent.children) {
			depthFirstPreOrder(child);
		}
	}
	
	public static void depthFirstPostOrder(Node parent) {
		for (Node child : parent.children) {
			depthFirstPostOrder(child);
		}
		System.out.print(" " + parent.name);
	}
	
	public static void depthFirstInOrder(Node parent) {
		if (parent.children.size() > 0) {
			depthFirstInOrder(parent.children.get(0));
		}
		System.out.print(" " + parent.name);
		if (parent.children.size() > 1) {
			depthFirstInOrder(parent.children.get(1));
		}
	}
	
	public static void depthFirstIterative(Node parent) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(parent);
		
		while(stack.size() > 0) {
			Node curr = stack.pop();
			for (int i = curr.children.size()-1; i >= 0 ; i--) {
				stack.push(curr.children.get(i));
			}
			System.out.println(curr.name);
		}

	}
	
	public static void breadthFirst(Node parent) {
		List<Node> children = new ArrayList<Node>();
		children.add(parent);
		
		while(children.size() > 0) {
			List<Node> nextChildren = new ArrayList<Node>();
			for(Node child : children) {
				System.out.print(" " + child.name);
				nextChildren.addAll(child.children);
			}
			children = nextChildren;
		}
	}
	
	public static void main(String [] args) {
		
		Node A = new Node("A");
		Node C = new Node("C");
		Node E = new Node("E");
		Node H = new Node("H");
		Node D = new Node("D", C, E);
		Node B = new Node("B", A, D);
		Node I = new Node("I", H);
		Node G = new Node("G", I);
		Node F = new Node("F", B, G);
		
		//depthFirstPreOrderGoalSearch(F, E);
		depthFirstIterative(F);
	}
}
