package p00;

import java.util.ArrayList;

public class Problem_0025 {

	@SuppressWarnings("unchecked")
	public static int solve() {

		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		a.add(1);
		b.add(1);

		int index = 2;

		while (b.size() < 1000) {

			index++;

			ArrayList<Integer> save = (ArrayList<Integer>) b.clone();
			add(b, a);
			a = save;

		}

		return index;
	}

	private static void add(ArrayList<Integer> pB, ArrayList<Integer> pA) {

		int help = 0;

		for (int i = 0; i < pA.size(); i++) {
			int number = pB.get(i) + pA.get(i) + help;
			help = number / 10;
			pB.set(i, number - help * 10);
		}

		for (int i = pA.size(); i < pB.size(); i++) {
			if (help == 0)
				break;
			int number = pB.get(i) + help;
			help = number / 10;
			pB.set(i, number - help * 10);
		}

		if (help > 0) {
			String s = "" + help;
			for (int i = 0; i < s.length(); i++) {
				pB.add(Integer.valueOf("" + s.charAt(i)));
			}
		}

	}

}
