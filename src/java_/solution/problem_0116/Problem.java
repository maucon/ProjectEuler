package java_.solution.problem_0116;

import java.util.stream.Stream;

public class Problem {

    final static int tiles = 50;
    final static long[][] savedResults = new long[3][tiles];

    public static long solve() {
        return Stream.iterate(2, n -> n + 1).limit(3).mapToLong(a -> runRecursive(a, tiles)).sum();
    }

    static long runRecursive(int tileLength, int tilesLeft) {
        return tilesLeft < tileLength ? 1 :
                savedResults[tileLength - 2][tilesLeft - 1] != 0 ?
                        savedResults[tileLength - 2][tilesLeft - 1] :
                        (savedResults[tileLength - 2][tilesLeft - 1] = (tilesLeft < tiles ? 1 : 0) +
                                Stream.iterate(0, n -> n + 1).limit(tilesLeft - tileLength + 1)
                                        .mapToLong(n -> runRecursive(tileLength, tilesLeft - tileLength - n)).sum());
    }

}
