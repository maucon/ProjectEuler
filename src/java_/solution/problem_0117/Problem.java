package java_.solution.problem_0117;

import java.util.stream.Stream;

public class Problem {

    final static int tiles = 50;
    final static long[] savedResults = new long[tiles];

    public static long solve() {
        return runRecursive(tiles);
    }

    static long runRecursive(int tilesLeft) {
        return tilesLeft < 2 ?
                1 :
                savedResults[tilesLeft - 1] != 0 ? savedResults[tilesLeft - 1] : (savedResults[tilesLeft - 1] = 1 + Stream
                        .iterate(2, n -> n + 1).limit(Math.min(3, tilesLeft - 1)).mapToLong(
                                n -> Stream.iterate(0, m -> m + 1).limit(tilesLeft - n + 1).mapToLong(m -> runRecursive(tilesLeft - n - m))
                                        .sum()).sum());
    }

}
