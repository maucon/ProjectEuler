package java.problem_0033;

public class Problem {

	public static final String DESCRIPTION = "The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.\r\n"
			+ "\t  We shall consider fractions like, 30/50 = 3/5, to be trivial examples.\r\n"
			+ "\t  There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.\r\n"
			+ "\t  If the product of these four fractions is given in its lowest common terms, find the value of the denominator.";

	public static int solve() {

		int numerator = 1;
		int denominator = 1;

		for (int i = 10; i < 99; i++)
			for (int j = i + 1; j < 100; j++)

				if ((("" + i).charAt(1) == ("" + j).charAt(0) && ("" + i).charAt(1) != '0')
						? Double.valueOf("" + ("" + i).charAt(0)) / Double.valueOf("" + (("" + j)).charAt(1)) == i
								/ (double) j
						: false) {

					numerator *= i;
					denominator *= j;
				}

		return denominator / gcd(numerator, denominator);
	}

	private static int gcd(int pA, int pB) {
		return pA == pB ? pA : pA > pB ? gcd(pA - pB, pB) : gcd(pB - pA, pA);
	}

}
