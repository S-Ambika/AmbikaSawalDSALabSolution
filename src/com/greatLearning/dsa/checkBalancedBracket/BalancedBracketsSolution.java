package com.greatLearning.dsa.checkBalancedBracket;

import java.util.Stack;

public class BalancedBracketsSolution {

	private Stack<Character> stack = new Stack<Character>();
	private boolean checkExp;

	private boolean isExpressionBalanced(String exp) {
		/*
		 * if expression is empty or length is odd then it is certainly unbalanced one
		 */
		if (exp.length() == 0 || exp.length() % 2 != 0) {
			checkExp = false;
			return checkExp;
		} else {
			for (int i = 0; i < exp.length(); i++) {

				char ele = exp.charAt(i);
				/*
				 * if there is opening braces then push to stack
				 */

				if (ele == '[' || ele == '{' || ele == '(') {

					stack.push(ele);
				}

				/*
				 * it means element is closing braces certainly unbalanced
				 */
				if (stack.isEmpty()) {
					checkExp = false;
					return checkExp;
				} else {

					checkExp = checkRemaningExpression(ele);

					return checkExp;

				}

			}

		}
		return checkExp;

	}

	private boolean checkRemaningExpression(char ele) {

		switch (ele) {
		case ')':
			ele = stack.pop();
			if (ele == '{' || ele == '[') // there is no opening ( bracket in TOS
				return false;
			break;

		case '}':
			ele = stack.pop();
			if (ele == '(' || ele == '[') // there is no opening { bracket in TOS
				return false;
			break;

		case ']':
			ele = stack.pop();
			if (ele == '(' || ele == '{') // there is no opening [ bracket in TOS
				return false;
			break;
		}
		return true;

	}

	public static void main(String[] args) {

		String expToBeChecked = "([[{}]]))"; // expression to be checked
		BalancedBracketsSolution balancedBracketsSolution = new BalancedBracketsSolution();

		if (balancedBracketsSolution.isExpressionBalanced(expToBeChecked)) {
			System.out
					.println("For Expression : " + expToBeChecked + "\n" + "The entered String has Balanced Brackets");

		} else {
			System.out.println("For Expression : " + expToBeChecked + "\n"
					+ "The entered Strings do not contain Balanced Brackets");

		}

	}
}