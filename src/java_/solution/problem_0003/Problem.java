package java_.solution.problem_0003;

public class Problem {

	public static int solve() {

		long number = 600851475143L;
		int prime = 2;

		while (number > 1) {

			if (number % prime == 0)
				number /= prime;
			else
				prime++;

		}
		return prime;
	}

}
