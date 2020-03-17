package p00;

public class Problem_0014 {

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
