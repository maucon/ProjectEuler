package java_.solution.problem_0015;

import java.math.BigInteger;

public class Problem {

	public static final String DESCRIPTION = "Starting in the top left corner of a 2�2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.\r\n"
			+ "\t  How many such routes are there through a 20�20 grid?";

	public static BigInteger solve() {
		return Faculty(40).divide(Faculty(20).pow(2));
	}

	private static BigInteger Faculty(int n) {
		BigInteger result = BigInteger.ONE;

		for (int i = 2; i <= n; i++)
			result = result.multiply(BigInteger.valueOf(i));

		return result;
	}

}
