package java_.solution.problem_0037;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem {

	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public static int solve() {

		String[] array = { "2", "3", "5", "7" };
		ArrayList<String> primes = new ArrayList<>(Arrays.asList(array));

		int sum = 0;
		int count = 0;

		while (count < 11) {

			ArrayList<String> new_primes = new ArrayList<>();

			for (String prime : primes)
				for (int j = 0; j < 10; j++) {

					String s = DIGITS[j] + prime;
					if (isPrime(Integer.parseInt(s)))
						new_primes.add(s);
					if (isValid(s)) {
						count++;
						sum += Integer.parseInt(s);
					}
				}

			primes = new_primes;
		}

		return sum;
	}

	private static boolean isValid(String pNumber) {

		int length = pNumber.length();

		for (int i = 0; i < length; i++)
			if (!isPrime(Integer.parseInt(pNumber.substring(0, length - i))))
				return false;

		return true;
	}

	private static boolean isPrime(int pNumber) {

		if (pNumber == 1 || (pNumber != 2 && pNumber % 2 == 0))
			return false;

		double square_root = Math.sqrt(pNumber);

		for (int i = 3; i <= square_root; i += 2) {
			if (pNumber % i == 0)
				return false;
		}

		return true;
	}

}
