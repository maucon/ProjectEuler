package java.problem_0037;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem {

	public static final String DESCRIPTION = "The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.\r\n"
			+ "\t  Find the sum of the only eleven primes that are both truncatable from left to right and right to left.\r\n"
			+ "\t  NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.";

	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public static int solve() {

		String[] array = { "2", "3", "5", "7" };
		ArrayList<String> primes = new ArrayList<String>(Arrays.asList(array));

		int sum = 0;
		int count = 0;

		while (count < 11) {

			ArrayList<String> new_primes = new ArrayList<String>();

			for (int i = 0; i < primes.size(); i++)
				for (int j = 0; j < 10; j++) {

					String s = DIGITS[j] + primes.get(i);
					if (isPrime(Integer.valueOf(s)))
						new_primes.add(s);
					if (isValid(s)) {
						count++;
						sum += Integer.valueOf(s);
					}
				}

			primes = new_primes;
		}

		return sum;
	}

	private static boolean isValid(String pNumber) {

		int length = pNumber.length();

		for (int i = 0; i < length; i++)
			if (!isPrime(Integer.valueOf(pNumber.substring(0, length - i))))
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
