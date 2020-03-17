package p00;

public class Problem_0045 {

	public static long solve() {
		for (long h = 144; true; h++) {
			long n = h * (2 * h - 1);
			if ((Math.sqrt(1 + 24 * n) + 1) % 6 == 0)
				return n;
		}
	}

}
