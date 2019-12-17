package java_.solution.problem_0049;

public class Problem {

	public static final String DESCRIPTION = "The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.\r\n"
			+ "\t  There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.\r\n"
			+ "\t  What 12-digit number do you form by concatenating the three terms in this sequence?";

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
