package p05;

public class Problem_0504 {

    private static final int SIZE = 100;

    public static long solve() {
        calcQuarterPoints();
        return count();
    }

    private static int[][] points;

    private static int count() {
        int count = 0;

        for (int a = 1; a <= SIZE; a++) {
            for (int b = 1; b <= SIZE; b++) {
                for (int c = 1; c <= SIZE; c++) {
                    for (int d = 1; d <= SIZE; d++) {
                        int sum = points[a][b] + points[b][c] + points[c][d] + points[d][a];
                        sum -= a + b + c + d;
                        sum += 1;
                        if (Math.sqrt(sum) % 1 == 0) count++;
                    }
                }
            }
        }

        return count;
    }

    private static void calcQuarterPoints() {
        points = new int[SIZE + 1][SIZE + 1];

        for (int x = 1; x <= SIZE; x++) {
            for (int y = x; y <= SIZE; y++) {
                int pointsInQuarter = pointsInQuarter(x, y);
                points[x][y] = pointsInQuarter;
                points[y][x] = pointsInQuarter;
            }
        }
    }

    private static int pointsInQuarter(double x, double y) {
        int sum = 0;

        for (int i = 1; i <= x; i++) {
            double product = i * y / x;
            if (product % 1 == 0) product--;

            sum += product + 1;
        }

        return sum;
    }
}
