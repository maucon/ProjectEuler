package java.problem_0032;

import java.util.ArrayList;

public class Problem {

	public static final String DESCRIPTION = "We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.\r\n"
			+ "\t  The product 7254 is unusual, as the identity, 39 � 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.\r\n"
			+ "\t  Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.\r\n"
			+ "\t  HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.";

	public static int solve() {

		int sum = 0;
		ArrayList<Integer> products = new ArrayList<Integer>();

		for (int a = 2; a < 100; a++) {
			for (int b = a + 1; b < 10000; b++) {
				int product = a * b;

				if (("" + product).length() > 10 - ("" + a).length() - ("" + b).length())
					break;

				if (pandigital(a, b, product) && !products.contains(product)) {
					products.add(product);
					sum += product;
				}
			}
		}

		return sum;
	}

	private static boolean pandigital(int pA, int pB, int pC) {
		String s = "" + pA + pB + pC;

		if (s.length() != 9 || s.contains("" + 0))
			return false;

		for (int i = 1; i < 10; i++)
			if (!s.contains("" + i))
				return false;

		return true;
	}

}
