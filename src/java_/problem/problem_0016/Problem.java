package java_.problem.problem_0016;

import java.util.ArrayList;

public class Problem {

	public static final String DESCRIPTION = "2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.\r\n"
			+ "\t  What is the sum of the digits of the number 2^1000?";

	public static int solve() {

		ArrayList<Integer> number = new ArrayList<Integer>();
		number.add(1);

		for (int i = 0; i < 40; i++) {

			int help = 0;

			for (int h = 0; h < number.size(); h++) {

				int product = number.get(h) * 33554432 + help;
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
