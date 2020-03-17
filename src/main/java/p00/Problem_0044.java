package p00;

public class Problem_0044 {

	public static long solve() {
		long result = Integer.MAX_VALUE;
		int i = 1;

		while (true) {
			i++;
			long n = i * (3L * i - 1) / 2;

			for (int j = i - 1; j > 0; j--) {
				long m = j * (3L * j - 1) / 2;

				if (n - m > result)
					break;

				if (isPentagonal(n - m) && isPentagonal(n + m)) {
					if (n - m < result) {
						result = n - m;
						break;
					}
				}
			}

			if (n - (i - 1) * (3L * (i - 1) - 1) / 2 > result)
				break;
		}

		return result;
	}

	private static boolean isPentagonal(long pNumber) {
		return (Math.sqrt(1 + 24 * pNumber) + 1) % 6 == 0;
	}

}
