package java_.solution.problem_0039;

public class Problem {

	public static final String DESCRIPTION = "If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.\r\n\r\n"
			+ "\t\t  {20,48,52}, {24,45,51}, {30,40,50}\r\n\r\n"
			+ "\t  For which value of p ≤ 1000, is the number of solutions maximised?";

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
