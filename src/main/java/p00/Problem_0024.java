package p00;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem_0024 {

	public static String solve() {

		int[] numbers = new int[10];
		int target = 999999;

		Integer[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
		StringBuilder solution = new StringBuilder();

		for (int i = 0; i < 10; i++) {

			int fac = faculty(9 - i);

			numbers[i] = target / fac;
			target = target % fac;

			solution.append(list.get(numbers[i]));
			list.remove(numbers[i]);
		}
		return solution.toString();
	}

	private static int faculty(int n) {
		int result = 1;

		for (int i = 2; i <= n; i++)
			result *= i;

		return result;
	}

}
