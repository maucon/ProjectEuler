package p01;

import java.util.stream.Stream;

public class Problem_0114 {

    final static int tiles = 50;
    final static long[] savedResults = new long[tiles];

    public static long solve() {
        return runRecursive(tiles);
    }

    static long runRecursive(int tilesLeft) {
        return tilesLeft < 3 ?
                1 :
                savedResults[tilesLeft - 1] != 0 ?
                        savedResults[tilesLeft - 1] :
                        (savedResults[tilesLeft - 1] = 1 + Stream.iterate(3, n -> n + 1).limit(tilesLeft - 2)
                                .mapToLong(n -> Stream.iterate(0, m -> m + 1).limit(tilesLeft - n + 1).mapToLong(m -> runRecursive(tilesLeft - m - n - 1)).sum()).sum());
    }

}
