package p00;

import java.math.BigInteger;

public class Problem_0015 {

	public static BigInteger solve() {
		return Faculty(40).divide(Faculty(20).pow(2));
	}

	private static BigInteger Faculty(int n) {
		BigInteger result = BigInteger.ONE;

		for (int i = 2; i <= n; i++)
			result = result.multiply(BigInteger.valueOf(i));

		return result;
	}

}
