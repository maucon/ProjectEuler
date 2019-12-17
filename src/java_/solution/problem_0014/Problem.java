package java_.solution.problem_0014;

public class Problem {

	public static final String DESCRIPTION = "The following iterative sequence is defined for the set of positive integers:\r\n"
			+ "\t  n → n/2 (n is even)\r\n" + "\t  n → 3n + 1 (n is odd)\r\n"
			+ "\t  Using the rule above and starting with 13, we generate the following sequence:\r\n"
			+ "\t  13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1\r\n"
			+ "\t  It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.\r\n"
			+ "\t  Which starting number, under one million, produces the longest chain?\r\n"
			+ "\t  NOTE: Once the chain starts the terms are allowed to go above one million.";

	public static long solve() {

		int longest_chain = 0;
		long best_number = 0;

		int[] chain_lengths = new int[1000000];

		for (int i = 1; i < 1000000; i++) {
			long number = i;
			int chain = 0;

			while (number != 1) {

				if (number < 1000000 && chain_lengths[(int) number] != 0) {
					chain += chain_lengths[(int) number];
					break;
				}

				chain++;

				if (number % 2 == 0)
					number /= 2;
				else {
					number = (number * 3 + 1) / 2;

					chain++;
				}

			}

			chain_lengths[i] = chain;

			if (chain > longest_chain) {
				best_number = i;
				longest_chain = chain;
			}

		}

		return best_number;
	}

}
