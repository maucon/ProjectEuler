package java.problem_0684;

public class Problem {

	public static final String DESCRIPTION = "Define s(n) to be the smallest number that has a digit sum of n. For example s(10)=19.\r\n" + 
			"Let S(k)=∑n=1ks(n). You are given S(20)=1074.\r\n\r\n" + 
			"Further let fi be the Fibonacci sequence defined by f0=0,f1=1 and fi=fi−2+fi−1 for all i≥2.\r\n\r\n" + 
			"Find ∑i=290S(fi).\r\n" + 
			"Give your answer modulo 1000000007.";

	public static long solve() {
		run();
		return sum;
	}

	static long sum = 0;
	static int mod = 1000000007;

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
