package java_.solution.problem_0043;

import java.util.ArrayList;

public class Problem {

	private static final int[] DIVISORS = { 13, 11, 7, 5, 3, 2 };

	public static long solve() {
		ArrayList<String> pandigitals = new ArrayList<>();

		for (int i = 17; i < 100; i += 17)
			pandigitals.add("0" + i);

		for (int n = 102; n < 1000; n += 17) {
			String sub17 = "" + n;

			if (sub17.charAt(0) != sub17.charAt(1) && sub17.charAt(0) != sub17.charAt(2)
					&& sub17.charAt(1) != sub17.charAt(2))
				pandigitals.add(sub17);
		}

		for (int divisor = 0; divisor < 6; divisor++) {
			ArrayList<String> new_pandigitals = new ArrayList<>();

			if (divisor == 2) {
				for (String s : pandigitals) {
					if (!s.contains("5")) {
						String ss = 5 + s;

						if (Integer.parseInt(ss.substring(0, 3)) % DIVISORS[divisor] == 0)
							new_pandigitals.add(ss);
					}
				}
			} else {

				for (String s : pandigitals) {
					for (int i = 0; i < 10; i++)
						if (!s.contains(i + "")) {
							String ss = i + s;

							if (Integer.parseInt(ss.substring(0, 3)) % DIVISORS[divisor] == 0)
								new_pandigitals.add(ss);
						}
				}
			} 

			pandigitals = new_pandigitals;
		}

		long sum = 0;

		for (String pandigital : pandigitals)
			for (int j = 1; j < 10; j++)
				if (!pandigital.contains(j + ""))
					sum += Long.parseLong(j + pandigital);

		return sum;
	}

}
