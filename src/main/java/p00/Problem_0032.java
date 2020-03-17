package p00;

import java.util.ArrayList;

public class Problem_0032 {

	public static int solve() {

		int sum = 0;
		ArrayList<Integer> products = new ArrayList<>();

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
