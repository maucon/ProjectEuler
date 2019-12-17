package java_.solution.problem_0006;

public class Problem {

	public static int solve() {

		int e = 0;
		int f = (int) Math.pow((int) ((Math.pow(100, 2) + 100) / 2), 2);

		for (int i = 0; i <= 100; i++)
			e += Math.pow(i, 2);

		return f - e;

	}

}

//int limit = 100;
//int e = limit * (limit + 1) / 2;
//int f = (2 * limit + 1) * (limit + 1) * limit / 6;
//return (int) (Math.pow(e, 2) - f);