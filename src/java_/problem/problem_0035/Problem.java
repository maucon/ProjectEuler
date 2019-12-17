package java_.problem.problem_0035;

public class Problem {

	public static final String DESCRIPTION = "The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.\r\n"
			+ "\t  There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.\r\n"
			+ "\t  How many circular primes are there below one million?";

	private static final boolean[] SIEVE = new boolean[1000000];

	public static int solve() {

		for (int j = 4; j < 1000000; j += 2)
			SIEVE[j] = true;

		for (int i = 3; i < 1000; i += 2) {

			while (i < 1000 && SIEVE[i])
				i++;

			if (i == 1000)
				break;

			for (int j = i * 2; j < 1000000; j += i)
				SIEVE[j] = true;

		}

		int count = 1;

		for (int i = 3; i < 1000000; i += 2) {
			if (!SIEVE[i] && isCircularPrime(i))
				count++;
		}

		return count;
	}

	private static boolean isCircularPrime(int pNumber) {
		char[] chars = ("" + pNumber).toCharArray();
		int length = chars.length;

		for (int i = 1; i < length; i++) {
			String s = "";

			for (int j = 0; j < length; j++)
				s += chars[(j + i) % length];

			if (SIEVE[Integer.valueOf(s)])
				return false;
		}

		return true;
	}

}
