package p06;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_0698 {

    static final List<Integer> low123Numbers = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 11, 12, 13, 21, 22, 23, 31, 32, 33));
    static long n = 111111111111222333L;
    static int numberLength;
    static long helpCount;
    static int[] digitsUsed = new int[4];

    static void calcNumberLength(long n) {
        int length = 1;
        for (long nextResult = resultsForLength(length); helpCount + nextResult <= n; nextResult = resultsForLength(++length)) {
            helpCount += nextResult;
        }
        numberLength = length;
    }

    static String calculateDigits() {
        StringBuilder resultDigits = new StringBuilder();

        int digitsLeft = numberLength;

        while (resultDigits.length() < numberLength) {
            String nextDigit = "1";

            digitsUsed[1]++;
            digitsLeft--;

            long possible123s = possibleCompletions(digitsLeft);
            if (possible123s + helpCount < n) {
                nextDigit = "2";
                helpCount += possible123s;

                digitsUsed[1]--;
                digitsUsed[2]++;

                possible123s = possibleCompletions(digitsLeft);
                if (possible123s + helpCount < n) {
                    nextDigit = "3";
                    helpCount += possible123s;

                    digitsUsed[2]--;
                    digitsUsed[3]++;
                }
            }

            resultDigits.append(nextDigit);
        }

        return resultDigits.toString();
    }

    static long possibleCompletions(int digitsLeft) {
        long result = 0;

        for (int i = 0; i < low123Numbers.size() && low123Numbers.get(i) - digitsUsed[1] <= digitsLeft; i++) {
            if (low123Numbers.get(i) - digitsUsed[1] < 0)
                continue;

            long innerResult = 0;
            for (int j = 0; j < low123Numbers.size() && low123Numbers.get(j) - digitsUsed[2] <= digitsLeft - (low123Numbers.get(i) - digitsUsed[1]); j++) {
                if (low123Numbers.get(j) - digitsUsed[2] < 0)
                    continue;

                if (low123Numbers.contains(digitsUsed[3] + digitsLeft - (low123Numbers.get(i) - digitsUsed[1]) - (low123Numbers.get(j) - digitsUsed[2]))) {
                    innerResult += nCr(digitsLeft - (low123Numbers.get(i) - digitsUsed[1]), low123Numbers.get(j) - digitsUsed[2]);
                }
            }

            result += nCr(digitsLeft, (low123Numbers.get(i) - digitsUsed[1])) * innerResult;
        }

        return result;
    }

    static long resultsForLength(int length) {
        long result = 0;

        for (int i = 0; i < low123Numbers.size() && low123Numbers.get(i) <= length; i++) {

            long res2 = 0;
            for (int j = 0; j < low123Numbers.size() && low123Numbers.get(j) <= length - low123Numbers.get(i); j++) {
                if (low123Numbers.contains(length - low123Numbers.get(i) - low123Numbers.get(j))) {
                    res2 += nCr(length - low123Numbers.get(i), low123Numbers.get(j));
                }
            }

            result += nCr(length, low123Numbers.get(i)) * res2;
        }

        return result;
    }

    static long nCr(int n, int r) {
        return fac(n).divide(fac(r).multiply(fac(n - r))).longValue();
    }

    static BigInteger fac(int num) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= num; i++) {
            result = result.multiply(new BigInteger(i + ""));
        }
        return result;
    }

    public static String solve() {
        calcNumberLength(n);
        return new BigInteger(calculateDigits()).mod(new BigInteger("123123123")).toString();
    }

}