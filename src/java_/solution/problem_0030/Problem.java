package java_.solution.problem_0030;

public class Problem {

	private static final int[] POWER = { 0, 1, 32, 243, 1024, 3125, 7776, 16807, 32768, 59049 };

	public static int solve() {

		int sum = 0;

		for (int i = 10; i < 354294; i++) {
			String s = "" + i;

			int number = 0;
			for (int j = 0; j < s.length(); j++)
				number += POWER[Integer.parseInt("" + s.charAt(j))];

			if (number == i)
				sum += number;

		}
		return sum;
	}

}
