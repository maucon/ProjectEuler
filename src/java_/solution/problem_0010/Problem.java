package java_.solution.problem_0010;

import java.util.ArrayList;

public class Problem {

	public static long solve() {

		long solution = 2;

		ArrayList<Integer> primes = new ArrayList<>();
		primes.add(2);
		int count = 1;

		while (count + 2 < 2000000) {
			count += 2;

			boolean prime = true;
			for (Integer integer : primes) {

				if (integer > Math.sqrt(count))
					break;

				if (count % integer == 0) {
					prime = false;
					break;
				}
			}

			if (prime) {
				primes.add(count);
				solution += count;
			}
		}

		return solution;
	}

//	public static long solve() {
//		int toN = 2000000;
//		boolean[] values = new boolean[toN];
//		Arrays.fill(values, true);
//		int stop = (int) Math.sqrt(toN) + 1;
//
//		for (int i = 2; i < stop; i++) {
//			if (values[i] == true) {
//				for (int j = i * i; j < toN; j += i) {
//					values[j] = false;
//				}
//			}
//		}
//
//		long sum = 0;
//		for (int i = 2; i < values.length; i++) {
//			if (values[i] == true) {
//				sum += i;
//			}
//		}
//		return sum;
//	}

}
