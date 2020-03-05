package java_.solution.problem_0349;



public class Problem {

    final static boolean[][] field = new boolean[1000][1000];
    static int x = 500, y = 500, dir = 0;
    final static long repeats = (1000000000000000000L - 12000) / 104;
    final static int stepsLeft = (int) ((1000000000000000000L - 12000) % 104);

    public static long solve() {
        return getBlackInSteps(12000) + getBlackInSteps(104) * repeats + getBlackInSteps(stepsLeft);
    }

    static int getBlackInSteps(int steps) {
        int black = 0;

        for (int i = 0; i < steps; i++) {
            black += field[x][y] ? -1 : 1;
            field[x][y] = !field[x][y];
            dir = (dir + (field[x][y] ? 3 : 1)) % 4;
            switch (dir) {
                case 0:
                    x++;
                    break;
                case 1:
                    y++;
                    break;
                case 2:
                    x--;
                    break;
                case 3:
                    y--;
            }
        }

        return black;
    }
}
