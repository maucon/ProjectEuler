package java.problem_0042;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem {

	public static final String DESCRIPTION = "The n'th term of the sequence of triangle numbers is given by, t(n) = �n(n+1); so the first ten triangle numbers are:\r\n"
			+ "\t  1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...\r\n"
			+ "\t  By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.\r\n"
			+ "\t  Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?";

	private static ArrayList<String> WORDS;

	public static int solve() {
		WORDS = readWords();

		ArrayList<Integer> values = new ArrayList<Integer>();
		int highest_value = 0;

		for (int i = 0; i < WORDS.size(); i++) {
			int value = 0;
			String word = WORDS.get(i);

			for (int j = 0; j < word.length(); j++)
				value += Integer.valueOf(word.charAt(j)) - 64;

			if (value > highest_value)
				highest_value = value;

			values.add(value);
		}

		ArrayList<Integer> triangle_numbers = new ArrayList<Integer>();
		triangle_numbers.add(1);
		int count = 2;

		while (triangle_numbers.get(triangle_numbers.size() - 1) < highest_value) {
			triangle_numbers.add((int) (count / 2d * (count + 1)));
			count++;
		}

		triangle_numbers.remove(triangle_numbers.size() - 1);

		int triangle_words = 0;
		for (int i = 0; i < values.size(); i++)
			if (triangle_numbers.contains(values.get(i)))
				triangle_words++;

		return triangle_words;
	}

	private static ArrayList<String> readWords() {

		try {
			BufferedReader br = new BufferedReader(
					new FileReader(new File(new File("src/java.problem_0042/words.txt").getAbsolutePath())));

			String s = br.readLine();
			br.close();
			return new ArrayList<String>(Arrays.asList(s.replaceAll("\"", "").split(",")));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
