package p03;

import java.util.ArrayList;
import java.util.Collections;

public class Problem_0387 {

    static long limit = 100000000000000L;

    public static long solve() {
        long sum = 0;
        calcPrimes((int) Math.sqrt(limit));
        for (int i = 1; i <= 9; i++) {
            sum += rec(i, i, false);
        }
        return sum;
    }

    static long rec(long num, int digitSum, boolean previousWasStrong) {
        if (num >= limit) {
            return 0;
        }

        long sum = 0;
        if (previousWasStrong && isPrime(num)) {
            sum += num;
        }
        if (num % digitSum == 0) {
            boolean strong = isPrime(num / digitSum);
            for (int i = 0; i <= 9; i++) {
                sum += rec(Long.parseLong(num + "" + i), digitSum + i, strong);
            }
        }
        return sum;
    }

    static boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }
        int sqRoot = (int) Math.sqrt(num);
        for (int i = 0; primes.get(i) <= sqRoot; i++) {
            if (num % primes.get(i) == 0) {
                return false;
            }
        }
        return true;
    }

    static ArrayList<Integer> primes = new ArrayList<>(Collections.singletonList(2));

    static void calcPrimes(int limit) {

        boolean[] sieve = new boolean[limit + 1];
        int sqRoot = (int) Math.sqrt(limit);

        for (int i = 3; i <= limit; i += 2) {
            if (!sieve[i]) {
                primes.add(i);
                if (i <= sqRoot) {
                    for (int j = i * 3; j <= limit; j += i * 2) {
                        sieve[j] = true;
                    }
                }
            }
        }
    }
}
