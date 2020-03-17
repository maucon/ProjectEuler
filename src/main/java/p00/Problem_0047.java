package p00;

import java.util.ArrayList;
import java.util.HashSet;

public class Problem_0047 {

	private static final ArrayList<Integer> PRIMES = new ArrayList<>();

	public static int solve() {

		PRIMES.add(2);
		PRIMES.add(3);

		int count = 0;
		for (int n = 210; true; n++) {
			if (!isPrime(n) && primeFactors(n) == 4) {
				count++;
			} else
				count = 0;

			if (count == 4)
				return n - 3;
		}
	}

	private static int primeFactors(int pNumber) {

		HashSet<Integer> factors = new HashSet<>();

		int number = pNumber;

		boolean finished = false;

		for (int prime : PRIMES) {
			if (prime > number) {
				finished = true;
				break;
			}

			while (number % prime == 0) {
				factors.add(prime);
				number /= prime;
			}
		}

		if (!finished) {
			for (int n = PRIMES.get(PRIMES.size() - 1) + 2; n <= number; n += 2) {

				if (isPrime(n)) {
					PRIMES.add(n);

					if (number % n == 0) {
						number /= n;
						factors.add(n);
					}
				}
			}
		}

		return factors.size();
	}

	private static boolean isPrime(int pNumber) {

		double sq_root = Math.sqrt(pNumber);

		for (int i = 3; i <= sq_root; i++)
			if (pNumber % i == 0)
				return false;

		return true;
	}

}
