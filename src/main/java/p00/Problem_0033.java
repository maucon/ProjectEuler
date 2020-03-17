package p00;

public class Problem_0033 {

    public static int solve() {

        int numerator = 1;
        int denominator = 1;

        for (int i = 10; i < 99; i++)
            for (int j = i + 1; j < 100; j++)

                if ((("" + i).charAt(1) == ("" + j).charAt(0) && ("" + i).charAt(1) != '0') && Double.parseDouble("" + ("" + i).charAt(0)) / Double.parseDouble("" + (("" + j)).charAt(1)) == i
                        / (double) j) {

                    numerator *= i;
                    denominator *= j;
                }

        return denominator / gcd(numerator, denominator);
    }

    private static int gcd(int pA, int pB) {
        return pA == pB ? pA : pA > pB ? gcd(pA - pB, pB) : gcd(pB - pA, pA);
    }

}
