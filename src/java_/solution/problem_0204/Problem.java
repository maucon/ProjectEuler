package java_.solution.problem_0204;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem {

    public static int solve() {
        return run(1, 0);
    }

    static ArrayList<Integer> primes = new ArrayList<>(
            Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));

    static int run(long number, int primeIndex) {
        int count = 1;

        for (int i = primeIndex; i < primes.size(); i++) {
            long newNumber = number * primes.get(i);
            if (newNumber <= 1000000000) {
                count += run(newNumber, i);
            } else {
                break;
            }
        }

        return count;
    }
}
