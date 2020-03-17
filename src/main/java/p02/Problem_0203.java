package p02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Problem_0203 {

    public static long solve() {
        HashSet<Long> distinctPascal = getDistinctPascal(51);
        ArrayList<Integer> primesSquared = new ArrayList<>(Arrays.asList(4, 9, 25, 49));

        long count = 0;
        for (Long p : distinctPascal) {
            boolean squareFree = true;
            for (int i = 0; i < primesSquared.size() && primesSquared.get(i) <= p; i++) {
                if (p % primesSquared.get(i) == 0) {
                    squareFree = false;
                    break;
                }
            }
            if (squareFree) {
                count += p;
            }
        }
        return count;
    }

    static HashSet<Long> getDistinctPascal(int rows) {
        HashSet<Long> distinct = new HashSet<>();

        long[] pascal = new long[0];
        for (int row = 1; row <= rows; row++) {
            long[] newPascal = new long[(row + 1) / 2];
            newPascal[0] = 1;
            for (int column = 1; column < (row % 2 == 0 ? newPascal.length : newPascal.length - 1); column++) {
                newPascal[column] = pascal[column - 1] + pascal[column];
            }
            if (row > 1 && (row & 1) == 1) {
                newPascal[newPascal.length - 1] = pascal[pascal.length - 1] * 2;
            }
            pascal = newPascal;

            for (Long p : pascal) {
                distinct.add(p);
            }
        }

        return distinct;
    }
}
