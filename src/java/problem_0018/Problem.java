package java.problem_0018;

public class Problem {

	public static final String DESCRIPTION = "By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.\r\n\r\n"
			+ "\t   3\r\n" + "\t  7 4\r\n" + "\t 2 4 6\r\n" + "\t8 5 9 3\r\n\r\n"
			+ "That is, 3 + 7 + 4 + 9 = 23.\r\n\r\n"
			+ "Find the maximum total from top to bottom of the triangle below:\r\n\r\n" + "\t              75\r\n"
			+ "\t             95 64\r\n" + "\t            17 47 82\r\n" + "\t           18 35 87 10\r\n"
			+ "\t          20 04 82 47 65\r\n" + "\t         19 01 23 75 03 34\r\n"
			+ "\t        88 02 77 73 07 63 67\r\n" + "\t       99 65 04 28 06 16 70 92\r\n"
			+ "\t      41 41 26 56 83 40 80 70 33\r\n" + "\t     41 48 72 33 47 32 37 16 94 29\r\n"
			+ "\t    53 71 44 65 25 43 91 52 97 51 14\r\n" + "\t   70 11 33 28 77 73 17 78 39 68 17 57\r\n"
			+ "\t  91 71 52 38 17 14 91 43 58 50 27 29 48\r\n" + "\t 63 66 04 68 89 53 67 30 73 16 69 87 40 31\r\n"
			+ "\t04 62 98 27 23 09 70 98 73 93 38 53 60 04 23\r\n\r\n"
			+ "NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)";

	private static final int[][] PYRAMID = { { 75 }, { 95, 64 }, { 17, 47, 82 }, { 18, 35, 87, 10 },
			{ 20, 04, 82, 47, 65 }, { 19, 01, 23, 75, 03, 34 }, { 88, 02, 77, 73, 07, 63, 67 },
			{ 99, 65, 04, 28, 06, 16, 70, 92 }, { 41, 41, 26, 56, 83, 40, 80, 70, 33 },
			{ 41, 48, 72, 33, 47, 32, 37, 16, 94, 29 }, { 53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14 },
			{ 70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57 }, { 91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48 },
			{ 63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31 },
			{ 04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 04, 23 } };

	public static int solve() {

		for (int i = PYRAMID.length - 2; i >= 0; i--)
			for (int j = 0; j < PYRAMID[i].length; j++)
				PYRAMID[i][j] += PYRAMID[i + 1][j] > PYRAMID[i + 1][j + 1] ? PYRAMID[i + 1][j] : PYRAMID[i + 1][j + 1];

		return PYRAMID[0][0];
	}

}
