package p00;

public class Problem_0021 {

	private static final int[] SAVE = new int[10001];

	public static int solve() {

		int sum = 0;

		for (int i = 2; i < 10000; i++) {

			if (SAVE[i] == 0)
				SAVE[i] = sumOfDivisors(i);

			if (SAVE[i] < 10001) {
				if (SAVE[SAVE[i]] == 0)
					SAVE[SAVE[i]] = sumOfDivisors(SAVE[i]);

				if (i == SAVE[SAVE[i]] && i != SAVE[i])
					sum += i;

			} else if (i == sumOfDivisors(SAVE[i]) && i != SAVE[i])
				sum += i;

		}
	
		return sum;

	}

	private static int sumOfDivisors(int p) {

		if (p == 1)
			return 0;

		int sum = 1;
		double square_root = Math.sqrt(p);

		for (int i = 2; i < square_root; i++)
			if (p % i == 0)
				sum += i + (p / i);

		if (Math.pow((int) square_root, 2) == p)
			sum += square_root;

		return sum;
	}

}
