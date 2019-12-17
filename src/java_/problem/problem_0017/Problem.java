package java_.problem.problem_0017;

public class Problem {

	public static final String DESCRIPTION = "If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.\r\n"
			+ "\t  If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used? \r\n"
			+ "\r\n"
			+ "\t  NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of \"and\" when writing out numbers is in compliance with British usage.";

	private static final int[] BASIC = { 0, 3, 3, 5, 4, 4, 3, 5, 5, 4 }; // 1 - 9
	private static final int[] SPECIAL = { 3, 6, 6, 8, 8, 7, 7, 9, 8, 8 }; // 10 - 19
	private static final int[] TENS = { 0, 0, 6, 6, 5, 5, 5, 7, 6, 6 }; // 0 - 90 (10)

	public static int solve() {

		int solution = 0;

		for (int i = 0; i < 100; i++) {
			String s = "" + i;

			if (s.length() == 1) {
				solution += BASIC[Integer.valueOf(s)];
				continue;
			}

			if (("" + s.charAt(s.length() - 2)).equals("1")) {
				solution += SPECIAL[Integer.valueOf("" + s.charAt(s.length() - 1))];
				continue;
			}

			solution += BASIC[Integer.valueOf("" + s.charAt(s.length() - 1))];
			solution += TENS[Integer.valueOf("" + s.charAt(s.length() - 2))];

		}

		solution *= 10;

		for (int i = 0; i < 10; i++)
			solution += BASIC[i] * 100; // "one-", "two-", "three-"

		solution += 900 * 7; // "-hundred"
		solution += 891 * 3; // "and"
		solution += 11; // "one thousand"

		return solution;
	}

}
