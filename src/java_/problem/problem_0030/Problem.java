package java_.problem.problem_0030;

public class Problem {

	public static final String DESCRIPTION = "Surprisingly there are only three numbers that can be written as the sum of fourth POWERs of their digits:\r\n\r\n"
			+ "\t\t  1634 = 1^4 + 6^4 + 3^4 + 4^4\r\n" + "\t\t  8208 = 8^4 + 2^4 + 0^4 + 8^4\r\n"
			+ "\t\t  9474 = 9^4 + 4^4 + 7^4 + 4^4\r\n\r\n" + "\t As 1 = 1^4 is not a sum it is not included.\r\n"
			+ "\t The sum of these numbers is 1634 + 8208 + 9474 = 19316.\r\n"
			+ "\t Find the sum of all the numbers that can be written as the sum of fifth POWERs of their digits.";

	private static final int[] POWER = { 0, 1, 32, 243, 1024, 3125, 7776, 16807, 32768, 59049 };

	public static int solve() {

		int sum = 0;

		for (int i = 10; i < 354294; i++) {
			String s = "" + i;

			int number = 0;
			for (int j = 0; j < s.length(); j++)
				number += POWER[Integer.valueOf("" + s.charAt(j))];

			if (number == i)
				sum += number;

		}
		return sum;
	}

}
