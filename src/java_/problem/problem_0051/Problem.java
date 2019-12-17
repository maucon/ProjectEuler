package java_.problem.problem_0051;

public class Problem {

	public static final String DESCRIPTION = "By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values:\r\n\t\t  13, 23, 43, 53, 73, and 83,\r\n\t  are all prime.\r\n\r\n"
			+ "\t  By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers, yielding the family:\r\n\t\t  56003, 56113, 56333, 56443, 56663, 56773, and 56993.\r\n\t  Consequently 56003, being the first member of this family, is the smallest prime with this property.\r\n"
			+ "\t  Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.";

	public static int solve() {

		for (int n = 3; true; n += 2) {

			if (isPrime(n)) {
				for (int i = 0; i < 10; i++) {

					if (("" + n).contains("" + i)) {
						int amount = 1;
						int first = n;
						for (int j = 0; j < 10; j++) {

							int value = Integer.valueOf(("" + n).replaceAll("" + i, "" + j));
							if (("" + value).length() < ("" + n).length())
								continue;

							if (j != i && isPrime(value)) {
								if (first > value)
									first = value;
								amount++;
							}
						}
						if (amount == 8)
							return first;
					}
				}
			}
		}
	}

	private static boolean isPrime(int pNumber) {

		if (pNumber % 2 == 0)
			return false;

		double sq_root = Math.sqrt(pNumber);

		for (int i = 3; i <= sq_root; i += 2)
			if (pNumber % i == 0)
				return false;

		return true;
	}

}
