package java_.solution.problem_0012;

public class Problem {

	public static int solve() {

		int c = 1;
		int value = 1;

		while (true) {
			double square_root = Math.sqrt(value);

			int count = (int) square_root == square_root ? 1 : 0;

			for (int i = 1; i < square_root; i++)
				if (value % i == 0)
					count += 2;

			if (count > 500)
				break;

			c++;
			value += c;
		}

		return value;
	}

}
