package java.problem_0020;

import java.util.ArrayList;

public class Problem {

	public static final String DESCRIPTION = "n! means n × (n − 1) × ... × 3 × 2 × 1\r\n"
			+ "\t  For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,\r\n"
			+ "\t  and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.\r\n"
			+ "\t  Find the sum of the digits in the number 100!";

	public static int solve() {

		ArrayList<Integer> number = new ArrayList<Integer>();
		number.add(1);

		for (int i = 1; i < 101; i++) {

			int help = 0;

			for (int h = 0; h < number.size(); h++) {

				int product = number.get(h) * i + help;
				help = product / 10;

				number.set(h, product - help * 10);

			}

			String string = String.valueOf(help);
			for (int h = string.length() - 1; h >= 0; h--)
				number.add(Integer.valueOf("" + string.charAt(h)));

		}

		int solution = 0;

		for (int i = 0; i < number.size(); i++)
			solution += number.get(i);

		return solution;
	}

}
