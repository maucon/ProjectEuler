package p00;

public class Problem_0039 {

	public static int solve() {

		int highest_amount = 0;
		int p = 0;

		for (int i = 3; i <= 1000; i++) {

			int count = 0;

			for (int c = i / 3 + 1; c < i / 2; c++) {
				int squared = (int) Math.pow(c, 2);

				for (int a = 1; a <= (i - c) / 2; a++) {
					double b = Math.sqrt(squared - Math.pow(a, 2));

					if (a + b + c == i)
						count++;
				}

			}

			if (count > highest_amount) {
				highest_amount = count;
				p = i;
			}

		}
		return p;
	}

}
