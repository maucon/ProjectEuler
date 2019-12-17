package java.problem_0046;

import java.util.ArrayList;

public class Problem {

	public static final String DESCRIPTION = "It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.\r\n"
			+ "\t\t  9 = 7 + 2�12\r\n" + "\t\t  15 = 7 + 2�22\r\n" + "\t\t  21 = 3 + 2�32\r\n"
			+ "\t\t  25 = 7 + 2�32\r\n" + "\t\t  27 = 19 + 2�22\r\n" + "\t\t  33 = 31 + 2�12\r\n"
			+ "\t  It turns out that the conjecture was false.\r\n"
			+ "\t  What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?";

	public static int solve() {

		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);

		for (int n = 3; true; n += 2) {

			double sq_root = Math.sqrt(n);

			boolean prime = true;

			for (int i = 3; i <= sq_root; i += 2)
				if (n % i == 0) {
					prime = false;
					break;
				}

			if (prime) {
				primes.add(n);
				continue;
			}

			boolean valid = false;

			for (int i = 0; i < primes.size(); i++)
				if (Math.sqrt((n - primes.get(i)) / 2d) % 1 == 0) {
					valid = true;
					break;
				}

			if (!valid)
				return n;

		}
	}

}
