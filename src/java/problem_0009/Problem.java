package java.problem_0009;

public class Problem {

	public static final String DESCRIPTION = "A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,\r\n"
			+ "\t  a2 + b2 = c2\r\n" + "\t  For example, 32 + 42 = 9 + 16 = 25 = 52.\r\n"
			+ "\t  There exists exactly one Pythagorean triplet for which a + b + c = 1000.\r\n"
			+ "\t  Find the product abc.";

	public static int solve() {

		int a = 1000 / 3 - 1;

		while (true) {
			int b = a + 1;

			while (true) {
				if (b > 500)
					break;

				int c = 1000 - a - b;

				if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2))
					return a * b * c;
				b++;
			}
			a--;
		}
	}

}
