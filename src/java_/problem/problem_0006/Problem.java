package java_.problem.problem_0006;

public class Problem {

	public static final String DESCRIPTION = "The sum of the squares of the first ten natural numbers is,\r\n"
			+ "\t  12 + 22 + ... + 102 = 385\r\n" + "\t  The square of the sum of the first ten natural numbers is,\r\n"
			+ "\t  (1 + 2 + ... + 10)2 = 552 = 3025\r\n"
			+ "\t  Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.\r\n"
			+ "\t  Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.";

	public static int solve() {

		int e = 0;
		int f = (int) Math.pow((int) ((Math.pow(100, 2) + 100) / 2), 2);

		for (int i = 0; i <= 100; i++)
			e += Math.pow(i, 2);

		return f - e;

	}

}

//int limit = 100;
//int e = limit * (limit + 1) / 2;
//int f = (2 * limit + 1) * (limit + 1) * limit / 6;
//return (int) (Math.pow(e, 2) - f);