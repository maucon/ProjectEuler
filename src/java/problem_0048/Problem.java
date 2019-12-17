package java.problem_0048;

public class Problem {

	public static final String DESCRIPTION = "The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.\r\n"
			+ "\t  Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.";

	public static long solve() {

		long sum = 1;

		for (int i = 2; i < 1001; i++)
			sum += getLastTen(i);

		String s = sum + "";
		return Long.valueOf(s.substring(s.length() - 10, s.length()));
	}

	private static long getLastTen(int pNumber) {

		String[] number_as_string = (pNumber + "").split("");
		int[] digits = new int[10];

		for (int i = 0; i < number_as_string.length; i++)
			digits[i] = Integer.valueOf(number_as_string[number_as_string.length - i - 1]);

		for (int i = 1; i < pNumber; i++) {
			long help = 0;

			for (int j = 0; j < digits.length; j++) {
				long product = digits[j] * pNumber + help;
				help = product / 10;
				digits[j] = (int) (product - help * 10);
			}
		}

		String s = "";
		for (int i = 9; i >= 0; i--)
			s += digits[i];

		return Long.valueOf(s);
	}

}
