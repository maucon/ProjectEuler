package java_.problem.problem_0001;

public class Problem {

    public static final String DESCRIPTION = "If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.\r\n"
            + "\t  Find the sum of all the multiples of 3 or 5 below 1000.";

    public static int solve() {

        int solution = 0;

        for (int a = 3; a < 1000; a += 3)
            solution += a;

        for (int b = 5; b < 1000; b += 5)
            solution += b % 3 == 0 ? 0 : b;

        return solution;
    }

}

//for (int i = 0; i < 1000; i++)
//	if (i % 3 == 0 || i % 5 == 0)
//		solution += i;