package java.problem_0052;

import java.util.Arrays;

public class Problem {

	public static final String DESCRIPTION = "It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.\r\n"
			+ "\t  Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.";

	public static int solve() {

		for (int i = 10; true; i++) {

			String s = "" + i;
			if (Integer.valueOf(s.substring(0, 2)) > 16)
				i = (int) Math.pow(10, s.length());

			char[] x1 = s.toCharArray();
			Arrays.sort(x1);

			boolean valid = true;
			for (int j = 2; j <= 6; j++) {
				char[] xJ = ("" + (i * j)).toCharArray();
				Arrays.sort(xJ);

				if (!Arrays.equals(x1, xJ)) {
					valid = false;
					break;
				}
			}

			if (valid)
				return i;
		}
	}

}