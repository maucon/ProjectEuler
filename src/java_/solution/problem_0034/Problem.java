package java_.solution.problem_0034;

public class Problem {

	private static final int[] FACULTY = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

	public static int solve() {
		int sum = 0;

		for (int i = 10; i < 2540160; i++) {
			if (isCurious(i))
				sum += i;
		}

		return sum;
	}

	private static boolean isCurious(int pNumber) {
		String s = "" + pNumber;
		int sum = 0;

		for (int i = 0; i < s.length(); i++) {
			sum += FACULTY[Integer.parseInt("" + s.charAt(i))];
			if (sum > pNumber)
				return false;
		}

		return sum == pNumber;
	}
}