package com.demo.DemoProject;

public class DebuggingDemo {

	public static void main(String args[]) {

		int x = 10;
		int y = 20;

		int a = add(x, y);
		int b = multiply(x, y);

		System.out.println("Addition is :" + a + " Multiplication is :" + b);
	}

	private static int multiply(int x, int y) {
		return x * y;

	}

	private static int add(int x, int y) {
		return x + y;

	}

}
