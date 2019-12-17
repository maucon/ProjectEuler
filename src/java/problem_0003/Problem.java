package java.problem_0003;

public class Problem {

	public static final String DESCRIPTION = "The prime factors of 13195 are 5, 7, 13 and 29.\r\n"
			+ "\t  What is the largest prime factor of the number 600851475143 ?";

	public static int solve() {

		long number = 600851475143l;
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
