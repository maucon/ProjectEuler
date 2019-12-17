package java_.solution.problem_0036;

import java.util.ArrayList;

public class Problem {

    private static final int[] BINARY = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768,
            65536, 131072, 262144, 524288};

    public static int solve() {
        int sum = 1;

        for (int i = 2; i <= 20; i++) {
            ArrayList<boolean[]> palindromes = generateBinaryPalindromes(i);

            for (boolean[] palindrome : palindromes) {
                int decimal = binaryToDecimal(palindrome);

                if (isPalindrom("" + decimal) && decimal < 1000000)
                    sum += decimal;
            }
        }

        return sum;
    }

    private static ArrayList<boolean[]> generateBinaryPalindromes(int pLength) {
        ArrayList<boolean[]> palindromes = new ArrayList<>();

        int amount = (int) Math.pow(2, Math.floor((pLength - 2) / (double) 2) + pLength % 2);
        for (int i = 0; i < amount; i++)
            palindromes.add(new boolean[pLength]);

        for (int i = 0; i < amount; i++) {
            boolean[] p = palindromes.get(i);
            p[0] = true;
            p[p.length - 1] = true;
        }

        int steps = 1;
        for (int i = 1; i < pLength / 2d; i++) {

            for (int j = 0; j < amount; j += steps * 2) {

                for (int h = j; h < j + steps; h++) {
                    boolean[] p = palindromes.get(h);
                    p[i] = true;
                    p[p.length - 1 - i] = true;
                }
            }
            steps *= 2;
        }

        return palindromes;
    }

    private static int binaryToDecimal(boolean[] pNumber) {
        int sum = 0;

        for (int i = 0; i < pNumber.length; i++)
            if (pNumber[i])
                sum += BINARY[i];

        return sum;
    }

    private static boolean isPalindrom(String s) {

        if (s.length() <= 1)
            return true;

        if (s.charAt(0) == s.charAt(s.length() - 1))
            return isPalindrom(s.substring(1, s.length() - 1));
        else
            return false;
    }

}
