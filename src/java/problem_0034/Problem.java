package java.problem_0034;

public class Problem {

	public static final String DESCRIPTION = "145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.\r\n"
			+ "\t  Find the sum of all numbers which are equal to the sum of the factorial of their digits.\r\n"
			+ "\t  Note: as 1! = 1 and 2! = 2 are not sums they are not included.\r\n";

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
			sum += FACULTY[Integer.valueOf("" + s.charAt(i))];
			if (sum > pNumber)
				return false;
		}

		return sum == pNumber;
	}
}