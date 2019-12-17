package java_.solution.problem_0662;

import java.awt.Point;
import java.util.ArrayList;

public class Problem {

	public static int solve() {
		calcFibonacci((int) Math.sqrt(size * size + size * size) + 1);
		generateValidMoves();
		return run();
	}

	final static int size = 10000;
	final static int[][] field = new int[size + 1][size + 1];
	final static ArrayList<Point> validMoves = new ArrayList<>();
	final static ArrayList<Integer> fibonacci = new ArrayList<>();

	static int run() {
		field[0][0] = 1;

		for (int x = 0; x <= size; x++) {
			for (int y = x == 0 ? 1 : x; y <= size; y++) {
				long count = 0;

				for (Point move : validMoves) {
					if (move.getY() <= y && move.getX() <= x) {
						count += field[(int) (x - move.getX())][(int) (y - move.getY())];
					}
				}

				int value = (int) (count % 1000000007);
				field[x][y] = value;
				field[y][x] = value;
			}
		}

		return field[size][size];
	}

	static void calcFibonacci(int limit) {
		fibonacci.add(1);
		fibonacci.add(2);

		int next = fibonacci.get(fibonacci.size() - 1) + fibonacci.get(fibonacci.size() - 2);
		while (next < limit) {
			fibonacci.add(next);
			next = fibonacci.get(fibonacci.size() - 1) + fibonacci.get(fibonacci.size() - 2);
		}
	}

	static void generateValidMoves() {
		for (int x = 0; x <= size; x++) {
			for (int y = 0; y <= size; y++) {
				double sqRoot = Math.sqrt(x * x + y * y);
				if (fibonacci.contains((int) sqRoot) && sqRoot == (int) sqRoot) {
					validMoves.add(new Point(x, y));
				}
			}
		}
	}

}