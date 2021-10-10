package com.greatLearning.dsa.findLongestPath;

import java.util.ArrayList;

public class FindLongestPathSolution {

	static class Node {
		Node left;
		Node right;
		int data;
	};

	// Binary node
	static Node newNode(int data) {
		Node temp = new Node();

		temp.data = data;
		temp.left = null;
		temp.right = null;

		return temp;
	}

	private static ArrayList<Integer> findlongestPath(Node root) {
		if (root == null) { // no binary tree
			ArrayList<Integer> longestPathList = new ArrayList<>();
			return longestPathList;
		}

		ArrayList<Integer> rightPathList = findlongestPath(root.right); // Recursive call on root.right
		ArrayList<Integer> leftPathList = findlongestPath(root.left); // Recursive call on root.left
		if (rightPathList.size() < leftPathList.size()) // Compare the size of the two ArrayList

			leftPathList.add(root.data);
		else
			rightPathList.add(root.data);

		/*
		 * returning whichever list has more size or more elements
		 */
		if (leftPathList.size() > rightPathList.size())

			return leftPathList;

		else
			return rightPathList;
	}

	public static void main(String[] args) {
		/*
		 * Creating binary tree
		 */
		Node root = newNode(100);
		root.left = newNode(20);
		root.right = newNode(130);
		root.left.left = newNode(10);
		root.left.right = newNode(50);
		root.right.left = newNode(110);
		root.right.right = newNode(140);
		root.left.left.left = newNode(5);

		ArrayList<Integer> longestPathList = findlongestPath(root);
		System.out.println("Longest Path from Root to Leaf node : ");
		System.out.print(longestPathList.get(longestPathList.size() - 1)); // for root node
		for (int i = longestPathList.size() - 2; i >= 0; i--) {
			System.out.print(" -> " + longestPathList.get(i)); // from root to leaf node having longest path
		}
	}
}