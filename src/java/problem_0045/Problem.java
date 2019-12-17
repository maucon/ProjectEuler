package java.problem_0045;

public class Problem {

	public static final String DESCRIPTION = "Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:\r\n\r\n"
			+ "\t  Triangle:    Tn=n(n+1)/2  ->  1, 3, 6, 10, 15, ...\r\n"
			+ "\t  Pentagonal:  Pn=n(3n−1)/2 ->  1, 5, 12, 22, 35, ...\r\n"
			+ "\t  Hexagonal:   Hn=n(2n−1)   ->  1, 6, 15, 28, 45, ...\r\n\r\n"
			+ "\t  It can be verified that T285 = P165 = H143 = 40755.\r\n"
			+ "\t  Find the next triangle number that is also pentagonal and hexagonal.";

	public static long solve() {
		for (long h = 144; true; h++) {
			long n = h * (2 * h - 1);
			if ((Math.sqrt(1 + 24 * n) + 1) % 6 == 0)
				return n;
		}
	}

}
