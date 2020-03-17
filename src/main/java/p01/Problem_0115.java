package p01;

import java.util.stream.Stream;

public class Problem_0115 {

    final static long[] savedResults = new long[1000];
    final static int min = 50;

    public static long solve() {
        for (int i = 60; ; i++) {
            long res = runRecursive(i);
            if (res > 1000000) {
                return i;
            }
        }
    }

    static long runRecursive(int tilesLeft) {
        return tilesLeft < min ?
                1 :
                savedResults[tilesLeft - 1] != 0 ?
                        savedResults[tilesLeft - 1] :
                        (savedResults[tilesLeft - 1] = 1 + Stream.iterate(min, n -> n + 1).limit(tilesLeft - min + 1)
                                .mapToLong(n -> Stream.iterate(0, m -> m + 1).limit(tilesLeft - n + 1)
                                        .mapToLong(m -> runRecursive(tilesLeft - m - n - 1)).sum()).sum());
    }


}
