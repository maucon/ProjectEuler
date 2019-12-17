package java.problem_0019;

public class Problem {

	public static final String DESCRIPTION = "You are given the following information, but you may prefer to do some research for yourself.\r\n\r\n"
			+ "\t  1 Jan 1900 was a Monday.\r\n" + "\t  Thirty days has September,\r\n"
			+ "\t  April, June and November.\r\n" + "\t  All the rest have thirty-one,\r\n"
			+ "\t  Saving February alone,\r\n" + "\t  Which has twenty-eight, rain or shine.\r\n"
			+ "\t  And on leap years, twenty-nine.\r\n"
			+ "\t  A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.\r\n\r\n"
			+ "How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?";

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
