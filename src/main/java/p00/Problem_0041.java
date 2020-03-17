package p00;

public class Problem_0041 {

	private static final boolean[] SIEVE = new boolean[7654322];

	public static int solve() {
		calculatePrimes();

		for (int i = 7654321; i >= 2; i -= 2)
			if (!SIEVE[i])
				if (isPandigital(i))
					return i;
		return 0;
	}

	private static void calculatePrimes() {

		for (int j = 4; j < 7654321; j += 2)
			SIEVE[j] = true;

		for (int i = 3; i < 2767; i += 2) {

			while (i < 2767 && SIEVE[i])
				i++;

			if (i == 2767)
				break;

			for (int j = i * 2; j < 7654322; j += i)
				SIEVE[j] = true;
		}
	}

	private static boolean isPandigital(int pNumber) {
		String s = pNumber + "";

		for (int i = 1; i < 10; i++) {

			if (s.contains("" + i))
				s = s.replaceFirst("" + i, "");
			else if (s.length() != 0)
				return false;
			else
				break;
		}
		return true;
	}

}
