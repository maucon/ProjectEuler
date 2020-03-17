package p00;

public class Problem_0001 {

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