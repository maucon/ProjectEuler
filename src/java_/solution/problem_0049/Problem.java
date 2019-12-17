package java_.solution.problem_0049;

public class Problem {

	private static final boolean[] SIEVE = new boolean[10000];

	public static String solve() {
		calculatePrimes();

		for (int i = 1489; i < 10000; i += 2)
			if (!SIEVE[i])
				for (int j = 2; j < (10000 - i) / 2; j += 2)
					if (!SIEVE[i + j] && arePermutations(i, i + j) && !SIEVE[i + j + j]
							&& arePermutations(i, i + j + j))
						return "" + i + (i + j) + (i + j + j);

		return "-";
	}

	private static boolean arePermutations(int pN1, int pN2) {
		String n1 = pN1 + "";

		for (String sn1 : (pN2 + "").split(""))
			n1 = n1.replaceFirst(sn1, "");

		return n1.length() == 0;
	}

	private static void calculatePrimes() {

		for (int j = 4; j < 10000; j += 2)
			SIEVE[j] = true;

		for (int i = 3; i < 100; i += 2) {

			while (i < 100 && SIEVE[i])
				i++;

			if (i == 100)
				break;

			for (int j = i * 2; j < 10000; j += i)
				SIEVE[j] = true;
		}
	}
}
