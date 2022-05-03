package p00;

public class Problem_0091 {

    private static final int SIZE = 50;

    public static int solve() {
        int result = SIZE * SIZE * 3; //right angle in origin + angle on x or y-axis

        for (int x = 1; x < SIZE; x++) {
            for (int y = 1; y <= SIZE; y++) {
                int gcd = getGCD(x, y);
                result += Math.min((SIZE - x) / (y / gcd), y / (x / gcd)) * 2;
            }
        }

        return result;
    }

    private static int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }
}
