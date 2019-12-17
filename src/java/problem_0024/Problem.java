package java.problem_0024;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem {

	public static final String DESCRIPTION = "A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:\r\n"
			+ "\t  012   021   102   120   201   210\r\n"
			+ "\t  What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?";

	public static String solve() {

		int[] numbers = new int[10];
		int target = 999999;

		Integer[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
		String solution = "";

		for (int i = 0; i < 10; i++) {

			int fac = faculty(9 - i);

			numbers[i] = target / fac;
			target = target % fac;

			solution += list.get(numbers[i]);
			list.remove(numbers[i]);
		}
		return solution;
	}

	private static int faculty(int n) {
		int result = 1;

		for (int i = 2; i <= n; i++)
			result *= i;

		return result;
	}

}
