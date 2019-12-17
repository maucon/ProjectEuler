package java_.start;

import java_.problem.problem_0001.Problem;

public class Main {

	public Main() {
		System.out.println("Problem:  " + java_.problem.problem_0001.Problem.DESCRIPTION + "\r\n");
		long start_time = System.nanoTime();
		System.out.println("Solution: " + Problem.solve());
		System.out.println("Time:     " + timeFormat(System.nanoTime() - start_time - 300000));
		System.out.println("         [ s| ms| μs| ns]");
	}

	private String timeFormat(long l) {
		StringBuilder t = new StringBuilder(l + "");

		while (t.length() < 11)
			t.insert(0, 0);

		for (int i = 8; i > 0; i -= 3)
			t = new StringBuilder(t.substring(0, i) + ":" + t.substring(i));

		return t.toString();
	}

	public static void main(String[] args) {
		new Main();
	}

}