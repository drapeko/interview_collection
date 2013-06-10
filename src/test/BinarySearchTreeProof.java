package test;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeProof {

	private static class Node {
		Integer value;
		List<Node> children = new ArrayList<Node>();
		
		public Node(Integer value, Node...children) {
			this.value = value;
			for (Node node : children) {
				this.children.add(node);
			}
		}
	}
	
	public static Boolean isBinarySearchTree(Node node) {
		if (node == null) {
			return true;
		}
		
		if (node.children.size() > 2) {
			return false;
		}
		
		Node left = node.children.size() > 1 ? node.children.get(0) : null;
		Node right = node.children.size() > 2 ? node.children.get(1) : null;
		
		if (left != null && left.value > node.value) {
			return false;
		}
		if (right != null && right.value < node.value) {
			return false;
		}
		return isBinarySearchTree(left) && isBinarySearchTree(right);		
	}
	
	
	public static void main(String [] args) {
		Node four = new Node(4);
		Node seven = new Node(7);
		Node six = new Node(6, four, seven);
		Node one = new Node(1);
		Node three = new Node(3, one, six);

		Node thirteen = new Node(13);
		Node fourteen = new Node(14, thirteen);
		Node ten = new Node(10, fourteen);

		Node eight = new Node(8, three, ten);

		System.out.println(isBinarySearchTree(eight));
	}
}
