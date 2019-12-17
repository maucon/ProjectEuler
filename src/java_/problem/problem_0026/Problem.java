package java_.problem.problem_0026;

import java.util.ArrayList;

public class Problem {

	public static final String DESCRIPTION = "A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:\r\n"
			+ "\r\n" + "\t      1/2	= 	0.5\r\n" + "\t      1/3	= 	0.(3)\r\n" + "\t      1/4	= 	0.25\r\n"
			+ "\t      1/5	= 	0.2\r\n" + "\t      1/6	= 	0.1(6)\r\n" + "\t      1/7	= 	0.(142857)\r\n"
			+ "\t      1/8	= 	0.125\r\n" + "\t      1/9	= 	0.(1)\r\n" + "\t      1/10	= 	0.1 \r\n" + "\r\n"
			+ "\t  Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.\r\n"
			+ "\t  Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.\r\n";

	public static int solve() {

		int solution = 0;
		int border = 2;

		for (int i = 999; i >= border; i -= 2) {

			int recurringCycle = lenghtOfRecurringCycle(i);
			if (recurringCycle > border) {
				border = recurringCycle;
				solution = i;
			}
		}

		return solution;
	}

	public static int lenghtOfRecurringCycle(int b) {
		int a = 1;
		ArrayList<Integer> list = new ArrayList<Integer>();

		while (a != 0) {

			a %= b;

			for (int i = 0; i < list.size(); i++)
				if (list.get(i) == a)
					return list.size();

			list.add(a);

			if (list.size() >= b)
				return 0;

			a *= 10;
		}
		return 0;
	}
}
