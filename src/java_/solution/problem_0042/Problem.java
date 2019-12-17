package java_.solution.problem_0042;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem {

	public static int solve() {
		ArrayList<String> WORDS = readWords();

		ArrayList<Integer> values = new ArrayList<>();
		int highest_value = 0;

		assert WORDS != null;
		for (String s : WORDS) {
			int value = 0;

			for (int j = 0; j < s.length(); j++)
				value += (int) s.charAt(j) - 64;

			if (value > highest_value)
				highest_value = value;

			values.add(value);
		}

		ArrayList<Integer> triangle_numbers = new ArrayList<>();
		triangle_numbers.add(1);
		int count = 2;

		while (triangle_numbers.get(triangle_numbers.size() - 1) < highest_value) {
			triangle_numbers.add((int) (count / 2d * (count + 1)));
			count++;
		}

		triangle_numbers.remove(triangle_numbers.size() - 1);

		int triangle_words = 0;
		for (Integer value : values)
			if (triangle_numbers.contains(value))
				triangle_words++;

		return triangle_words;
	}

	private static ArrayList<String> readWords() {

		try {
			BufferedReader br = new BufferedReader(
					new FileReader(new File(new File("src/java.sol.problem_0042/words.txt").getAbsolutePath())));

			String s = br.readLine();
			br.close();
			return new ArrayList<>(Arrays.asList(s.replaceAll("\"", "").split(",")));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
