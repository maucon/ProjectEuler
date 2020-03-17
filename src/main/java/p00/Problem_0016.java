package p00;

import java.util.ArrayList;

public class Problem_0016 {

	public static int solve() {

		ArrayList<Integer> number = new ArrayList<>();
		number.add(1);

		for (int i = 0; i < 40; i++) {

			int help = 0;

			for (int h = 0; h < number.size(); h++) {

				int product = number.get(h) * 33554432 + help;
				help = product / 10;

				number.set(h, product - help * 10);

			}

			String string = String.valueOf(help);
			for (int h = string.length() - 1; h >= 0; h--)
				number.add(Integer.valueOf("" + string.charAt(h)));

		}

		int solution = 0;

		for (Integer integer : number) solution += integer;

		return solution;
	}

}
