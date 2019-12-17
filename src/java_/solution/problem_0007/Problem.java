package java_.solution.problem_0007;

import java.util.ArrayList;

public class Problem {

	public static int solve() {

		ArrayList<Integer> primes = new ArrayList<>();
		primes.add(2);
		int count = 1;

		while (primes.size() < 10001) {
			count += 2;

			boolean prime = true;
			for (Integer integer : primes) {

				if (integer > Math.sqrt(count))
					break;

				if (count % integer == 0) {
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
