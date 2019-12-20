package java_.solution.problem_0031;

public class Problem {

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