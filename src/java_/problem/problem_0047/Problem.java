package java_.problem.problem_0047;

import java.util.ArrayList;
import java.util.HashSet;

public class Problem {

	public static final String DESCRIPTION = "The first two consecutive numbers to have two distinct prime factors are:\r\n\r\n"
			+ "\t\t  14 = 2 � 7\r\n" + "\t\t  15 = 3 � 5\r\n\r\n"
			+ "\t  The first three consecutive numbers to have three distinct prime factors are:\r\n\r\n"
			+ "\t\t  644 = 2� � 7 � 23\r\n" + "\t\t  645 = 3 � 5 � 43\r\n" + "\t\t  646 = 2 � 17 � 19.\r\n\r\n"
			+ "\t  Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?";

	private static final ArrayList<Integer> PRIMES = new ArrayList<Integer>();

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

		HashSet<Integer> factors = new HashSet<Integer>();

		int number = pNumber;

		boolean finished = false;

		for (int i = 0; i < PRIMES.size(); i++) {
			int prime = PRIMES.get(i);

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
