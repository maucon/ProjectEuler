package java_.solution.problem_0038;

public class Problem {

	public static final String DESCRIPTION = "Take the number 192 and multiply it by each of 1, 2, and 3:\r\n\r\n"
			+ "\t\t  192 � 1 = 192\r\n" + "\t\t  192 � 2 = 384\r\n" + "\t\t  192 � 3 = 576\r\n\r\n"
			+ "\t  By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)\r\n"
			+ "\t  The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).\r\n"
			+ "\t  What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?";

	public static int solve() {

		for (int i = 9876; i >= 9123; i--) {
			String number = "" + i + i * 2;
			if (isPandigital(number))
				return Integer.valueOf(number);
		}

		return 0;
	}

	private static boolean isPandigital(String pNumber) {

		if (pNumber.length() != 9 || pNumber.contains("" + 0))
			return false;

		for (int i = 1; i < 10; i++)
			if (!pNumber.contains("" + i))
				return false;

		return true;
	}

}
