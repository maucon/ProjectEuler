package java_.solution.problem_0052;

import java.util.Arrays;

public class Problem {

	public static int solve() {

		for (int i = 10; true; i++) {

			String s = "" + i;
			if (Integer.parseInt(s.substring(0, 2)) > 16)
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