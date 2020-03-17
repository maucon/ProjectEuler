package p01;

public class Problem_0100 {
    public static long solve() {
        long b = 85;
        for (long n = 120, bOld, nOld; n <= 1000000000000L; b = (bOld = b) * 3 + (nOld = n) * 2 - 2, n = bOld * 4 + nOld * 3 - 3) { }
        return b;
    }
}
