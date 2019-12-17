package java_.solution.problem_0009;

public class Problem {

	public static int solve() {

		int a = 1000 / 3 - 1;

		while (true) {
			int b = a + 1;

			while (b <= 500) {

				int c = 1000 - a - b;

				if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2))
					return a * b * c;
				b++;
			}
			a--;
		}
	}

}
