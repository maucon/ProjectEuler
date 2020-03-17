package p03;

public class Problem_0348 {

    public static int solve() {
        int sum = 0;

        for (int count = 0, digits = 2; count < 5; digits++) {
            int limit = (int) Math.pow(10, (digits + 1) / 2);
            for (int a = (int) Math.pow(10, (digits - 1) / 2); a < limit; a++) {
                int palindrom = Integer.parseInt(a + "" + new StringBuilder().append((digits & 1) == 0 ? a : a / 10).reverse());
                if (possibleSquareCubeRepresentations(palindrom) == 4) {
                    sum += palindrom;
                    count++;
                }
            }
        }

        return sum;
    }

    static int possibleSquareCubeRepresentations(int num) {
        int count = 0;

        double thirdRoot = Math.pow(num, 1 / 3d);
        for (int i = 2; i < thirdRoot; i++) {
            int rest = num - i * i * i;
            if (rest > 3 && Math.sqrt(rest) % 1 == 0) {
                count++;
            }
        }

        return count;
    }
}
