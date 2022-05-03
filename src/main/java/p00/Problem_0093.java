package p00;

import java.util.*;

public class Problem_0093 {

    public static String solve() {
        int[] set = getBestSet();
        return "" + set[0] + set[1] + set[2] + set[3];
    }

    private static int[] getBestSet() {
        int[] set = {1, 2, 3, 4};
        int longestChain = 0;

        for (int a = 0; a <= 6; a++) {
            for (int b = a + 1; b <= 7; b++) {
                for (int c = b + 1; c <= 8; c++) {
                    for (int d = c + 1; d <= 9; d++) {
                        int chain = getChain(a, b, c, d);
                        if (chain < longestChain) continue;

                        longestChain = chain;
                        set = new int[]{a, b, c, d};
                    }
                }
            }
        }

        return set;
    }

    private static int getChain(double a, double b, double c, double d) {
        Set<Double> possible = getPossible(new ArrayList<>(Arrays.asList(a, b, c, d)));

        for (double i = 1; ; i++) {
            if (!possible.contains(i))
                return (int) (i - 1);
        }
    }

    private static Set<Double> getPossible(List<Double> digits) {
        if (digits.size() == 1)
            return new HashSet<>(digits);
        if (digits.size() == 2)
            return getCombinations(new HashSet<>(Collections.singletonList(digits.get(0))), new HashSet<>(Collections.singletonList(digits.get(1))));

        Set<Double> possible = new HashSet<>();

        if (digits.size() >= 3) {
            for (int i = 0; i < digits.size(); i++) {
                double digit = digits.get(i);

                List<Double> single = new ArrayList<>(Collections.singletonList(digit));
                List<Double> multi = new ArrayList<>(digits);
                multi.remove(digit);

                possible.addAll(getCombinations(getPossible(single), getPossible(multi)));
            }
        }

        if (digits.size() == 4) {
            for (int i = 0; i < digits.size() - 1; i++) {
                for (int j = i + 1; j < digits.size(); j++) {
                    List<Double> a = new ArrayList<>(Arrays.asList(digits.get(i), digits.get(j)));
                    List<Double> b = new ArrayList<>(digits);
                    b.remove(i);
                    b.remove(j - 1);

                    possible.addAll(getCombinations(getPossible(a), getPossible(b)));
                }
            }
        }

        return possible;
    }

    private static Set<Double> getCombinations(Set<Double> a, Set<Double> b) {
        Set<Double> combinations = new HashSet<>();

        for (Double dA : a) {
            for (Double dB : b) {
                combinations.add(dA + dB);
                combinations.add(dA - dB);
                combinations.add(dB - dA);
                combinations.add(dA * dB);
                if (dB != 0)
                    combinations.add(dA / dB);
                if (dA != 0)
                    combinations.add(dB / dA);
            }
        }

        return combinations;
    }
}
