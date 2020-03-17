package p00;

public class Problem_0028 {

	public static int solve() {

		int solution = 1;
		int number = 1;
		int add = 2;

		for (int i = 0; i < 500; i++) {
			solution += number * 4 + add * 10;
			number += add * 4;
			add += 2;
		}
		return solution;
	}

}
