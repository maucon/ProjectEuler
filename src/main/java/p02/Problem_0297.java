package p02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Problem_0297 {

    static long limit = 99999999999999999L;

    public static long solve() {
        ArrayList<Long> fibonacci = new ArrayList<>(Arrays.asList(1L, 2L));
        HashMap<Long, Long> fibNeeded = new HashMap<>();
        fibNeeded.put(1L, 1L);
        fibNeeded.put(2L, 2L);

        long a = 3;
        long b = 2;
        for (; a <= limit; a = a + b + (b = a) - b) {
            fibonacci.add(a);
            long needed = (a - b) + fibNeeded.get(b) + fibNeeded.get(a - b) - 1;
            fibNeeded.put(a, needed);
        }

        long highestFib = fibonacci.get(fibonacci.size() - 1);
        long left = limit - highestFib;
        long count = fibNeeded.get(highestFib) + left;

        int help = 0;
        for (int fibIndex = fibonacci.size() - 1; left > 0; fibIndex--) {
            long fib = fibonacci.get(fibIndex);
            if (fib <= left) {
                count += fibNeeded.get(fib) + help * fib;
                help++;
                left -= fib;
            }
        }

        return count;
    }

}
