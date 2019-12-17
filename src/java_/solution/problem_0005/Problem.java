package java_.solution.problem_0005;

public class Problem {

	public static final String DESCRIPTION = "2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.\r\n"
			+ "\t  What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?";

	public static int solve() {
		int solution = 1;

		int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19 };

		for (int i = primes.length - 1; i >= 0; i--) {
			int max_times = 0;

			for (int h = 2; h <= 20; h++) {
				int count = 0;
				int number = h;

				while (number % primes[i] == 0) {
					count++;
					number /= primes[i];
				}

				max_times = Math.max(count, max_times);
			}

			solution *= Math.pow(primes[i], max_times);

		}
		return solution;
	}

}
