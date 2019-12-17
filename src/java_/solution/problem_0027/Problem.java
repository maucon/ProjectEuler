package java_.solution.problem_0027;

import java.util.ArrayList;

public class Problem {

	public static int solve() {

		ArrayList<Integer> primes = primes();

		int highest_amount_of_primes = 0;
		int product = 0;

		for (Integer prime : primes) {
			for (int a = -999; a < 1000; a += 2) {

				int n = 0;
				int b = prime;

				while (isPrime(n * n + a * n + b))
					n++;

				if (n > highest_amount_of_primes) {
					highest_amount_of_primes = n;
					product = a * b;
				}
			}
		}
		return product;
	}

	private static boolean isPrime(int pNumber) {

		if (pNumber < 0)
			return false;

		int square_root = (int) Math.sqrt(pNumber) + 1;
		for (int i = 2; i < square_root; i++)
			if (pNumber % i == 0)
				return false;

		return true;
	}

	private static ArrayList<Integer> primes() {

		boolean[] all_numbers = new boolean[1000];
		ArrayList<Integer> primes = new ArrayList<>();

		for (int i = 2; i < 1000; i++) {

			while (i < 1000 && all_numbers[i])
				i++;

			if (i == 1000)
				break;

			primes.add(i);

			for (int j = i; j < 1000; j += i)
				all_numbers[j] = true;
		}
		return primes;
	}

}
