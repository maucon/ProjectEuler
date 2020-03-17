package p01;

public class Problem_0113 {

    final static int maxLength = 100;
    static long result = 9; //     9 * ( maxLength - 1 + 2) - 9 * (maxLength);

    public static long solve() {
        long[] values = new long[]{1, 1, 1, 1, 1, 1, 1, 1, 1};

        for (int i = 2; i <= maxLength; i++) {
            long[] newValues = new long[9];

            for (int j = 0; j < 9; j++) {
                for (int k = j; k < 9; k++) {
                    newValues[k] += values[j];
                }
            }

            values = newValues;
            for (int j = 0; j < 9; j++) {
                result += values[j] * (maxLength - i + 2);
            }
        }
        return result;
    }

}
