package java_.solution.problem_0035;

public class Problem {

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
			StringBuilder s = new StringBuilder();

			for (int j = 0; j < length; j++)
				s.append(chars[(j + i) % length]);

			if (SIEVE[Integer.parseInt(s.toString())])
				return false;
		}

		return true;
	}

}
