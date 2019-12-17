package java_.solution.problem_0023;

import java.util.ArrayList;

public class Problem {

	public static int solve() {

		ArrayList<Integer> abundant = new ArrayList<>();

		for (int i = 0; i < 28112; i++)
			if (isAbundant(i))
				abundant.add(i);

		boolean[] sum = new boolean[28123];

		for (int i = 0; i < abundant.size(); i++)
			for (int j = i; j < abundant.size(); j++)
				sum[(abundant.get(i) + abundant.get(j)) < 28123 ? abundant.get(i) + abundant.get(j) : 24] = true;

		int solution = 0;

		for (int i = 0; i < 28123; i++)
			if (!sum[i])
				solution += i;

		return solution;
	}

	private static boolean isAbundant(int pNumber) {

		if (pNumber < 12)
			return false;

		double square_root = Math.sqrt(pNumber);

		int sum = (Math.pow((int) square_root, 2) == pNumber ? (int) square_root + 1 : 1);

		for (int i = 2; i < square_root; i++)
			if (pNumber % i == 0)
				sum += i + pNumber / i;

		return sum > pNumber;
	}

}
