package p00;

public class Problem_0040 {

	private static final int[] DIGITS = { 10, 100, 1000, 10000, 100000, 1000000 };

	public static int solve() {

		int solution = 1;
		int digit = 0;
		int step = 1;
		int n = 0;

		while (digit < 1000000) {

			int help = (int) Math.pow(10, step - 1);

			for (int i = help; i < help * 10; i++) {
				if (digit + step >= DIGITS[n]) {
					solution *= Integer.parseInt("" + ("" + i).charAt(DIGITS[n] - digit - 1));
					n++;
				}
				digit += step;
				if (n == 6)
					break;
			}

			step++;
		}

		return solution;
	}

}
