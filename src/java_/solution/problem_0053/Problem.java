package java_.solution.problem_0053;

public class Problem {

	public static int solve() {

		int amount = 0;
		int[][] pascal = new int[101][];

		for (int i = 1; i < 101; i++) {
			pascal[i] = new int[(i / 2) + 1];

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
