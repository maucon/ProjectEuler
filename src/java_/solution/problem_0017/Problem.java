package java_.solution.problem_0017;

public class Problem {

    private static final int[] BASIC = {0, 3, 3, 5, 4, 4, 3, 5, 5, 4}; // 1 - 9
    private static final int[] SPECIAL = {3, 6, 6, 8, 8, 7, 7, 9, 8, 8}; // 10 - 19
    private static final int[] TENS = {0, 0, 6, 6, 5, 5, 5, 7, 6, 6}; // 0 - 90 (10)

    public static int solve() {

        int solution = 0;

        for (int i = 0; i < 100; i++) {
            String s = "" + i;

            if (s.length() == 1) {
                solution += BASIC[Integer.parseInt(s)];
                continue;
            }

            String s1 = "" + s.charAt(s.length() - 2);
            int i1 = Integer.parseInt("" + s.charAt(s.length() - 1));
            if (s1.equals("1")) {
                solution += SPECIAL[i1];
                continue;
            }

            solution += BASIC[i1];
            solution += TENS[Integer.parseInt(s1)];

        }

        solution *= 10;

        for (int i = 0; i < 10; i++)
            solution += BASIC[i] * 100; // "one-", "two-", "three-"

        solution += 900 * 7; // "-hundred"
        solution += 891 * 3; // "and"
        solution += 11; // "one thousand"

        return solution;
    }

}
