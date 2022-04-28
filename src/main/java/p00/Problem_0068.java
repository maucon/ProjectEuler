package p00;

public class Problem_0068 {

    private static final int[] ORDER = new int[]{0, 9, 1, 2, 1, 3, 4, 3, 5, 6, 5, 7, 8, 7, 9};

    public static long solve() {
        int[] gonRing = new int[10];
        boolean[] usedNumbers = new boolean[11];

        gonRing[0] = 6;
        usedNumbers[6] = true;

        return fillOuter(gonRing, usedNumbers, 2);
    }

    private static long fillOuter(int[] current, boolean[] usedNumbers, int index) {
        if (index == 10)
            return fillInner(current, usedNumbers, 1);

        long highest = 0;
        for (int i = 7; i <= 10; i++) {
            if (usedNumbers[i]) continue;

            current[index] = i;
            usedNumbers[i] = true;

            highest = Math.max(highest, fillOuter(current, usedNumbers, index + 2));
            usedNumbers[i] = false;
        }

        return highest;
    }

    private static long fillInner(int[] current, boolean[] usedNumbers, int index) {
        if (index == 11)
            return getResult(current);

        long highest = 0;
        for (int i = 1; i <= 5; i++) {
            if (usedNumbers[i]) continue;

            current[index] = i;
            usedNumbers[i] = true;

            highest = Math.max(highest, fillInner(current, usedNumbers, index + 2));
            usedNumbers[i] = false;
        }

        return highest;
    }

    private static long getResult(int[] gonRing) {
        if (!isMagic(gonRing))
            return 0;

        StringBuilder result = new StringBuilder();
        for (int j : ORDER) {
            result.append(gonRing[j]);
        }

        return Long.parseLong(result.toString());
    }

    private static boolean isMagic(int[] gonRing) {
        int sum = 0;
        int s = 0;

        for (int i = 0; i < ORDER.length; i++) {
            s += gonRing[ORDER[i]];

            if ((i + 1) % 3 == 0) {
                if (sum != 0 && s != sum) return false;

                sum = s;
                s = 0;
            }
        }

        return true;
    }
}