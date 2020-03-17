package p00;

public class Problem_0002 {

    public static int solve() {

        int solution = 0;

        int a = 1;
        int b = 2;

        while (b < 4000000) {

            solution += b % 2 == 0 ? b : 0;

            int new_number = a + b;
            a = b;
            b = new_number;

        }

        return solution;

    }

}

//int a = 1;
//int b = 1;
//int c = 2;
//
//while (c < 4000000) {
//	solution += c;
//	a = b + c;
//	b = c + a;
//	c = a + b;
//}