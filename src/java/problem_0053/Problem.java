package java.problem_0053;

public class Problem {

	public static final String DESCRIPTION = "There are exactly ten ways of selecting three from five, 12345:\r\n"
			+ "\t  123, 124, 125, 134, 135, 145, 234, 235, 245, and 345\r\n" + "\r\n"
			+ "\t  In combinatorics, we use the notation, 5C3=10.\r\n"
			+ "\t  In general, nCr=n!r!(n−r)!, where r≤n, n!=n×(n−1)×...×3×2×1, and 0!=1.\r\n"
			+ "\t  It is not until n=23, that a value exceeds one-million: 23C10=1144066.\r\n"
			+ "\t  How many, not necessarily distinct, values of nCr for 1≤n≤100, are greater than one-million?";

	public static int solve() {

		int amount = 0;
		int[][] pascal = new int[101][];

		for (int i = 1; i < 101; i++) {
			pascal[i] = new int[(int) (i / 2) + 1];

			pascal[i][0] = 1;

			for (int j = (int) (i / 2d - 0.1d); j > 0; j--) {
				pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];

				if (pascal[i][j] > 1000000) {
					amount += 2;
					pascal[i][j] = 1000000;
				}
			}
			if (i % 2 == 0) {
				pascal[i][i / 2] = 2 * pascal[i - 1][i / 2 - 1];
				if (pascal[i][i / 2] > 1000000) {
					amount++;
					pascal[i][i / 2] = 1000000;
				}
			}
		}

		return amount;
	}

}
