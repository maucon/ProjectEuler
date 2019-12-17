package java.problem_0043;

import java.util.ArrayList;

public class Problem {

	public static final String DESCRIPTION = "The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.\r\n"
			+ "\t  Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:\r\n\r\n"
			+ "\t\t  d2d3d4=406 is divisible by 2\r\n" + "\t\t  d3d4d5=063 is divisible by 3\r\n"
			+ "\t\t  d4d5d6=635 is divisible by 5\r\n" + "\t\t  d5d6d7=357 is divisible by 7\r\n"
			+ "\t\t  d6d7d8=572 is divisible by 11\r\n" + "\t\t  d7d8d9=728 is divisible by 13\r\n"
			+ "\t\t  d8d9d10=289 is divisible by 17\r\n\r\n"
			+ "\t  Find the sum of all 0 to 9 pandigital numbers with this property.";

	private static final int[] DIVISORS = { 13, 11, 7, 5, 3, 2 };

	public static long solve() {
		ArrayList<String> pandigitals = new ArrayList<String>();

		for (int i = 17; i < 100; i += 17)
			pandigitals.add("0" + i);

		for (int n = 102; n < 1000; n += 17) {
			String sub17 = "" + n;

			if (sub17.charAt(0) != sub17.charAt(1) && sub17.charAt(0) != sub17.charAt(2)
					&& sub17.charAt(1) != sub17.charAt(2))
				pandigitals.add(sub17);
		}

		for (int divisor = 0; divisor < 6; divisor++) {
			ArrayList<String> new_pandigitals = new ArrayList<String>();

			if (divisor == 2) {
				for (int j = 0; j < pandigitals.size(); j++) {
					String s = pandigitals.get(j);

					if (!s.contains("5")) {
						String ss = 5 + s;

						if (Integer.valueOf(ss.substring(0, 3)) % DIVISORS[divisor] == 0)
							new_pandigitals.add(ss);
					}
				}
			} else {

				for (int j = 0; j < pandigitals.size(); j++) {
					String s = pandigitals.get(j);

					for (int i = 0; i < 10; i++)
						if (!s.contains(i + "")) {
							String ss = i + s;

							if (Integer.valueOf(ss.substring(0, 3)) % DIVISORS[divisor] == 0)
								new_pandigitals.add(ss);
						}
				}
			} 

			pandigitals = new_pandigitals;
		}

		long sum = 0;

		for (int i = 0; i < pandigitals.size(); i++)
			for (int j = 1; j < 10; j++)
				if (!pandigitals.get(i).contains(j + ""))
					sum += Long.valueOf(j + pandigitals.get(i));

		return sum;
	}

}
