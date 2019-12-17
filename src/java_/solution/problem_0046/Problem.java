package java_.solution.problem_0046;

import java.util.ArrayList;

public class Problem {

	public static int solve() {

		ArrayList<Integer> primes = new ArrayList<>();
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

			for (Integer integer : primes)
				if (Math.sqrt((n - integer) / 2d) % 1 == 0) {
					valid = true;
					break;
				}

			if (!valid)
				return n;

		}
	}

}
