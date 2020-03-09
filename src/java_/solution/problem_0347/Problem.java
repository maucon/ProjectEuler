package java_.solution.problem_0347;



import java.util.ArrayList;
import java.util.Arrays;

public class Problem {

    static int limit = 10000000;

    public static long solve() {
        long sum = 0;
        ArrayList<Integer> primes = calcPrimes(limit / 2);
        for (int a = 0; a < primes.size(); a++) {
            int p = primes.get(a);
            if (p * p > limit) {
                break;
            }
            for (int b = a + 1; b < primes.size(); b++) {
                int q = primes.get(b);
                if (p * q > limit) {
                    break;
                }
                sum += M(p * q, p, q);
            }
        }
        return sum;
    }

    static long M(long num, int p, int q) {
        if (num * p <= limit) {
            if (num * q <= limit) {
                return Math.max(M(num * p, p, q), M(num * q, p, q));
            } else {
                while (num * p <= limit) {
                    num *= p;
                }
                return num;
            }
        } else if (num * q <= limit) {
            while (num * q <= limit) {
                num *= q;
            }
            return num;
        } else {
            return num;
        }
    }

    static ArrayList<Integer> calcPrimes(int limit) {
        ArrayList<Integer> primes = new ArrayList<>(Arrays.asList(2));

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

        return primes;
    }
}