package java_.solution.problem_0029;

import java.math.BigInteger;
import java.util.HashSet;

public class Problem {

    public static int solve() {

        HashSet<BigInteger> sorted = new HashSet<>();

        for (int a = 2; a <= 100; a++) {
            BigInteger number = BigInteger.valueOf(a);
            for (int b = 2; b <= 100; b++) {
                number = number.multiply(BigInteger.valueOf(a));
                sorted.add(number);
            }
        }

        return sorted.size();
    }

}