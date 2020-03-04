package java_.solution.problem_0205;

public class Problem {

    public static double solve() {
        calcPossibilities();
        calcPeteProbabilities();
        return round(calcPeteWinProbability(), 7);
    }

    static double round(double number, int decimalPlaces) {
        double d = Math.pow(10, decimalPlaces);
        return Math.round(number * d) / d;
    }

    static double calcPeteWinProbability() {
        double prob = 0d;
        for (int i = 6; i <= 35; i++) {
            prob += colin[i] / 46656d * peteProb[i + 1];
        }
        return prob;
    }

    static double[] peteProb = new double[37];

    static void calcPeteProbabilities() {
        double prob = 1d;
        for (int i = 7; i <= 36; i++) {
            peteProb[i] = prob;
            prob -= pete[i] / 262144d;
        }
    }

    static int[] pete = new int[37];
    static int[] colin = new int[37];

    static void calcPossibilities() {
        for (int p = 9; p <= 22; p++) {
            pete[p] = pete[45 - p] = possibleThrows(p, 9, 4);
        }
        for (int c = 6; c <= 21; c++) {
            colin[c] = colin[42 - c] = possibleThrows(c, 6, 6);
        }
    }

    static int possibleThrows(int number, int diceCount, int diceSides) {
        int count = 0;
        for (int i = 1; i <= diceSides; i++) {
            if (number - i > 0) {
                count += possibleThrows(number - i, diceCount - 1, diceSides);
            } else if (number - i == 0 && diceCount == 1) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
