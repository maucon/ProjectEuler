package java_.solution.problem_0684;

public class Problem {

	public static long solve() {
		run();
		return sum;
	}

	static long sum = 0;
	static final int mod = 1000000007;

	static void run() {
		long a = 0;
		long b = 1;
		int aMod9 = 0;
		int bMod9 = 1;
		long a9thPowerOf10Modmrd7 = 1;
		long b9thPowerOf10Modmrd7 = 1;

		for (int i = 2; i <= 90; i++) {
			b += a + (a = b) - a;
			bMod9 += aMod9 + (aMod9 = bMod9) - aMod9;

			long help = b9thPowerOf10Modmrd7;
			b9thPowerOf10Modmrd7 *= a9thPowerOf10Modmrd7;
			a9thPowerOf10Modmrd7 = help;
			b9thPowerOf10Modmrd7 %= mod;

			if (bMod9 >= 9) {
				bMod9 -= 9;
				b9thPowerOf10Modmrd7 *= 10;
				b9thPowerOf10Modmrd7 %= mod;
			}

			for (int j = bMod9 + 2; j <= 10; j++)
				sum -= b9thPowerOf10Modmrd7 * j - 1;

			sum += 60 * b9thPowerOf10Modmrd7 - 9 * (b / 9) - 15;
		}

		sum %= mod;
		if (sum < 0)
			sum += mod;
	}

}
