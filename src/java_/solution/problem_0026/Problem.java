package java_.solution.problem_0026;

import java.util.ArrayList;

public class Problem {

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
		ArrayList<Integer> list = new ArrayList<>();

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
