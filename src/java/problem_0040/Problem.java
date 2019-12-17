package java.problem_0040;

public class Problem {

	public static final String DESCRIPTION = "An irrational decimal fraction is created by concatenating the positive integers:\r\n"
			+ "\t  0.123456789101112131415161718192021...\r\n"
			+ "\t  It can be seen that the 12th digit of the fractional part is 1.\r\n"
			+ "\t  If dn represents the nth digit of the fractional part, find the value of the following expression.\r\n"
			+ "\t  d1 � d10 � d100 � d1000 � d10000 � d100000 � d1000000";

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
					solution *= Integer.valueOf("" + ("" + i).charAt(DIGITS[n] - digit - 1));
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
