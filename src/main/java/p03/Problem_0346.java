package p03;

import java.util.HashSet;

public class Problem_0346 {

    static long limit = 1000000000000L;

    public static long solve() {
        HashSet<Long> repunits = new HashSet<>();

        for (long i = (long) Math.sqrt(limit); i >= 2; i--) {
            for (long num = 1 + i + i * i, step = i * i * i; num < limit; num += step, step *= i) {
                repunits.add(num);
            }
        }

        long sum = 1;
        for (Long ru : repunits) {
            sum += ru;
        }
        return sum;
    }
}
