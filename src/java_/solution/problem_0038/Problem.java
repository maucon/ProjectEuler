package java_.solution.problem_0038;

public class Problem {

	public static int solve() {

		for (int i = 9876; i >= 9123; i--) {
			String number = "" + i + i * 2;
			if (isPandigital(number))
				return Integer.parseInt(number);
		}

		return 0;
	}

	private static boolean isPandigital(String pNumber) {

		if (pNumber.length() != 9 || pNumber.contains("" + 0))
			return false;

		for (int i = 1; i < 10; i++)
			if (!pNumber.contains("" + i))
				return false;

		return true;
	}

}
