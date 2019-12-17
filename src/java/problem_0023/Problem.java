package java.problem_0023;

import java.util.ArrayList;

public class Problem {

	public static final String DESCRIPTION = "A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.\r\n"
			+ "\t  A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.\r\n"
			+ "\t  As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.\r\n"
			+ "\t  Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.";

	public static int solve() {

		ArrayList<Integer> abundant = new ArrayList<Integer>();

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
