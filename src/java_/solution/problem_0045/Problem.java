package java_.solution.problem_0045;

public class Problem {

	public static long solve() {
		for (long h = 144; true; h++) {
			long n = h * (2 * h - 1);
			if ((Math.sqrt(1 + 24 * n) + 1) % 6 == 0)
				return n;
		}
	}

}
