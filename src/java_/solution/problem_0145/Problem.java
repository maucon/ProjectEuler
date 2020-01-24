package java_.solution.problem_0145;

public class Problem {

    public static int solve() {
        int solution = 0;

        outer:
        for (int i = 1; i < 1000000000; i++) {
            if (i % 10 == 0) {
                continue;
            }
            for (char c : (((Integer.parseInt(new StringBuilder(i + "").reverse().toString())) + i) + "").toCharArray()) {
                if (Integer.parseInt(c + "") % 2 == 0) {
                    continue outer;
                }
            }
            solution += 1;
        }

        return solution;
    }

}

//for (int i = 0; i < 1000; i++)
//	if (i % 3 == 0 || i % 5 == 0)
//		solution += i;