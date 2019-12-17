package java.problem_0050;

public class Problem {

	public static final String DESCRIPTION = "The prime 41, can be written as the sum of six consecutive primes:\r\n"
			+ "\t  41 = 2 + 3 + 5 + 7 + 11 + 13\r\n"
			+ "\t  This is the longest sum of consecutive primes that adds to a prime below one-hundred.\r\n"
			+ "\t  The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.\r\n"
			+ "\t  Which prime, below one-million, can be written as the sum of the most consecutive primes?";

	public static final boolean[] SIEVE = new boolean[1000000];

	public static int solve() {
		calculatePrimes();

		int highest = 1;
		int longest_term = 1;

		int sum = 0;
		int chain = 0;

		for (int i = 2; i < 1000000; i++) {
			if (!SIEVE[i]) {
				sum += i;

				if (sum >= 1000000)
					break;

				chain++;

				if (chain > longest_term && !SIEVE[sum]) {
					highest = sum;
					longest_term = chain;
				}
			}
		}

		for (int start = 3; start < 1000000 / longest_term; start += 2) {
			sum = 0;
			chain = 0;

			for (int i = start; i < 1000000; i += 2) {
				if (!SIEVE[i]) {
					sum += i;

					if (sum > 1000000)
						break;

					chain++;

					if (chain > longest_term && !SIEVE[sum]) {
						highest = sum;
						longest_term = chain;
					}
				}
			}
		}

		return highest;
	}

	private static void calculatePrimes() {

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
	}

}
