package java_.problem.problem_0007;

import java.util.ArrayList;

public class Problem {

	public static final String DESCRIPTION = "By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.\r\n"
			+ "\t  What is the 10 001st prime number?";

	public static int solve() {

		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		int count = 1;

		while (primes.size() < 10001) {
			count += 2;

			boolean prime = true;
			for (int i = 0; i < primes.size(); i++) {

				if (primes.get(i) > Math.sqrt(count))
					break;

				if (count % primes.get(i) == 0) {
					prime = false;
					break;
				}
			}

			if (prime)
				primes.add(count);
		}

		return primes.get(10000);
	}

}
