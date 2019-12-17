package java_.problem.problem_0031;

public class Problem {

	public static final String DESCRIPTION = "In England the currency is made up of pound, �, and pence, p, and there are eight COINS in general circulation:\r\n"
			+ "\t  1p, 2p, 5p, 10p, 20p, 50p, �1 (100p) and �2 (200p).\r\n"
			+ "\t  It is possible to make �2 in the following way:\r\n"
			+ "\t  1ף1 + 1�50p + 2�20p + 1�5p + 1�2p + 3�1p\r\n"
			+ "\t  How many different ways can �2 be made using any number of COINS?";

	private static final int[] COINS = { 200, 100, 50, 20, 10, 5, 2, 1 };

	public static int solve() {

		return possibilities(200, 0);
	}

	private static int possibilities(int pValue, int pCoin) {

		if (pValue == 0)
			return 0;

		int possibilities = 0;

		for (int i = pCoin; i < 8; i++)
			if (COINS[i] < pValue)
				possibilities += possibilities(pValue - COINS[i], i);
			else if (COINS[i] == pValue)
				possibilities++;

		return possibilities;
	}

}

//int[] ways = new int[201];
//ways[0] = 1;
//
//for (int i = 0; i < 8; i++)
//	for (int j = COINS[i]; j <= 200; j++)
//		ways[j] = ways[j] + ways[j - COINS[i]];
//
//return ways[200];