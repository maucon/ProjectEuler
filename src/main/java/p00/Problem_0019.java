package p00;

public class Problem_0019 {

	private static final int[] DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static int solve() {

		int solution = 0;

		int day = 2; // 01.01.1901 -> Tuesday

		for (int year = 1901; year < 2001; year++)
			for (int month = 0; month < 12; month++) {

				day += DAYS[month];

				if (month == 1 && year % 4 == 0)
					day++;

				if (day % 7 == 0)
					solution++;

			}

		return solution;
	}

}
