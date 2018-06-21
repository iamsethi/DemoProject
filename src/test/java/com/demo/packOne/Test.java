package com.demo.packOne;

public class Test {

	public static void main(String args[]) {

		int multiply = multiplyTwoNumber(10, 20);
		int sum = addTwoNumber(10, 20);
		System.out.println(multiply + "" + sum);

	}

	private static int multiplyTwoNumber(int a, int b) {
		return a * b;

	}

	private static int addTwoNumber(int x, int y) {
		return x * y;

	}

}
