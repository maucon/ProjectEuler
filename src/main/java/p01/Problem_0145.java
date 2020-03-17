package p01;

public class Problem_0145 {

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