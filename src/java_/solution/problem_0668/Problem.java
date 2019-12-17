package java_.solution.problem_0668;

public class Problem {

    private final static long limit = 10000000000L;
    private final static byte[] templates = {1, 2, 4, 8, 16, 32, 64, -128};
    private final static byte[] sieve = new byte[(int) (limit / 8) + 1];
    private static long count = limit - 2;

    public static long solve() {
        run();
        return count;
    }

    private static void run() {
        for (long a = 3; a <= limit; a += 2) {
            byte temp = templates[(int) (a & 7)];
            if ((sieve[(int) (a / 8)] & temp) != temp) {
                long quotient = limit / a;
                count -= Math.min(a, quotient);
                long aa = a + a;
                for (long b = aa + a; b <= limit; b += aa)
                    sieve[(int) (b / 8)] |= templates[(int) (b & 7)];
            }
        }
    }

}