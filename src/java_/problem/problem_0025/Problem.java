package java_.problem.problem_0025;

import java.util.ArrayList;

public class Problem {

	public static final String DESCRIPTION = "The Fibonacci sequence is defined by the recurrence relation:\r\n"
			+ "\t  Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.\r\n" + "\t  Hence the first 12 terms will be:\r\n\r\n"
			+ "\t\t  F1 = 1\r\n" + "\t\t  F2 = 1\r\n" + "\t\t  F3 = 2\r\n" + "\t\t  F4 = 3\r\n" + "\t\t  F5 = 5\r\n"
			+ "\t\t  F6 = 8\r\n" + "\t\t  F7 = 13\r\n" + "\t\t  F8 = 21\r\n" + "\t\t  F9 = 34\r\n"
			+ "\t\t  F10 = 55\r\n" + "\t\t  F11 = 89\r\n" + "\t\t  F12 = 144\r\n\r\n"
			+ "\t  The 12th term, F12, is the first term to contain three digits.\r\n"
			+ "\t  What is the index of the first term in the Fibonacci sequence to contain 1000 digits?";

	@SuppressWarnings("unchecked")
	public static int solve() {

		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
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
