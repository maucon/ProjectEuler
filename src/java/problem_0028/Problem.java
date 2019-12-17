package java.problem_0028;

public class Problem {

	public static final String DESCRIPTION = "Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:\r\n"
			+ "\r\n" + "\t\t21 22 23 24 25\r\n" + "\t\t20  7  8  9 10\r\n" + "\t\t19  6  1  2 11\r\n"
			+ "\t\t18  5  4  3 12\r\n" + "\t\t17 16 15 14 13\r\n" + "\r\n"
			+ "\t  It can be verified that the sum of the numbers on the diagonals is 101.\r\n" + "\r\n"
			+ "\t  What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?";

	public static int solve() {

		int solution = 1;
		int number = 1;
		int add = 2;

		for (int i = 0; i < 500; i++) {
			solution += number * 4 + add * 10;
			number += add * 4;
			add += 2;
		}
		return solution;
	}

}
