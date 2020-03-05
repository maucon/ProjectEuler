package java_.solution.problem_0148;

public class Problem {

    // Really slow solution ~30min
    public static String solve() {
        long result = 500000000500000000L;

        for (long line = 8; line <= 1000000000; line++) {
            long biggestTriangle = (long) Math.pow(7, ((int) (Math.log(line) / Math.log(7))));
            long lineLeft = line;
            long factor = 1;

            for (long triangle = biggestTriangle; triangle >= 7; triangle /= 7) {
                if (line % triangle == 0) break;

                long amount = lineLeft / triangle;
                result -= ((triangle - line % triangle) * amount * factor);
                factor *= amount + 1;
                lineLeft = (lineLeft - (triangle - line % triangle) * amount) / (amount + 1);
            }
        }
        return result + "";
    }

}
