package java_.problem.problem_0021;

public class Problem {

	public static final String DESCRIPTION = "Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).\r\n"
			+ "\t  If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.\r\n"
			+ "\t  For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.\r\n"
			+ "\t  Evaluate the sum of all the amicable numbers under 10000.";

	private static int[] SAVE = new int[10001];

	public static int solve() {

		int sum = 0;

		for (int i = 2; i < 10000; i++) {

			if (SAVE[i] == 0)
				SAVE[i] = sumOfDivisors(i);

			if (SAVE[i] < 10001) {
				if (SAVE[SAVE[i]] == 0)
					SAVE[SAVE[i]] = sumOfDivisors(SAVE[i]);

				if (i == SAVE[SAVE[i]] && i != SAVE[i])
					sum += i;

			} else if (i == sumOfDivisors(SAVE[i]) && i != SAVE[i])
				sum += i;

		}
	
		return sum;

	}

	private static int sumOfDivisors(int p) {

		if (p == 1)
			return 0;

		int sum = 1;
		double square_root = Math.sqrt(p);

		for (int i = 2; i < square_root; i++)
			if (p % i == 0)
				sum += i + (p / i);

		if (Math.pow((int) square_root, 2) == p)
			sum += square_root;

		return sum;
	}

}
