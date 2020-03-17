package p00;

public class Problem_0051 {

	public static int solve() {

		for (int n = 3; true; n += 2) {

			if (isPrime(n)) {
				for (int i = 0; i < 10; i++) {

					if (("" + n).contains("" + i)) {
						int amount = 1;
						int first = n;
						for (int j = 0; j < 10; j++) {

							int value = Integer.parseInt(("" + n).replaceAll("" + i, "" + j));
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
