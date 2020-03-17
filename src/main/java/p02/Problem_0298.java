package p02;

import java.util.Locale;

public class Problem_0298 {

    static int turns = 50;

    public static String solve() {
        calcProbabilities(2, 1, 1);
        double sum = 0;
        for (int i = 0; i <= turns; i++) {
            System.out.println(i + "\t:\t" + probabilities[i]);
            sum += probabilities[i];
        }
        System.out.println(sum);
        return String.format(Locale.ENGLISH, "%.9g%n", calcResult());
    }

    static double calcResult() {
        double result = 0;
        for (int i = 0; i <= turns; i++) {
            for (int j = i + 1; j <= turns; j++) {
                result += Math.abs(i - j) * probabilities[i] * probabilities[j] * 2;
            }
        }
        return result;
    }

    static double[] probabilities = new double[turns + 1];

    static void calcProbabilities(int turn, int memory, double probability) {
        if (turn == turns + 1) {
            probabilities[turns + 1 - memory] += probability;
        } else if (memory == 5) {
            int score = turn - 6;
            for (int i = 0; i <= turns + 1 - turn; i++) {
                probabilities[i + score] += nCr(turns + 1 - turn, i) * Math.pow(0.5, i) * Math.pow(0.5, turns + 1 - turn - i) * probability;
            }
        } else {
            calcProbabilities(turn + 1, memory, probability * memory / 10);
            calcProbabilities(turn + 1, memory + 1, probability * (1 - memory / 10d));
        }
    }

    static long nCr(int n, int r) {
        double result = 1;
        for (double i = 0; i < r; i++) {
            result *= (n - i) / (r - i);
        }
        return (long) (result + 0.1);
    }
}
