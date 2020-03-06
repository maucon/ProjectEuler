package java_.solution.problem_0704;

public class Problem {
    final static long n = 10000000000000000L;

    public static long solve() {
        long result = 0;

        int log2 = (int) (Math.log(n) / Math.log(2));
        long range = (long) (n - Math.pow(2, log2)) + 1;
        for (long i = 2, f = log2; f > 0; i *= 2, f--) {
            result += (range / i + (range % i >= i / 2 ? 1 : 0)) * f;
        }
        for (int i = log2; i > 1; i--) {
            range = (long) (Math.pow(2, i) - Math.pow(2, i - 1));
            for (int f = i - 1; f > 0; f--) {
                result += (range /= 2) * f;
            }
        }

        return result;
    }
}
