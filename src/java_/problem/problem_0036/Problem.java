package java_.problem.problem_0036;

import java.util.ArrayList;

public class Problem {

	public static final String DESCRIPTION = "The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.\r\n"
			+ "\t  Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.\r\n"
			+ "\t  (Please note that the palindromic number, in either base, may not include leading zeros.)";

	public static int solve() {
		int sum = 1;

		for (int i = 2; i <= 20; i++) {
			ArrayList<boolean[]> palindromes = generateBinaryPalindromes(i);

			for (int j = 0; j < palindromes.size(); j++) {
				int decimal = binaryToDecimal(palindromes.get(j));

				if (isPalindrom("" + decimal) && decimal < 1000000)
					sum += decimal;
			}
		}

		return sum;
	}

	private static ArrayList<boolean[]> generateBinaryPalindromes(int pLength) {
		ArrayList<boolean[]> palindromes = new ArrayList<boolean[]>();

		int amount = (int) Math.pow(2, (pLength - 2) / 2 + pLength % 2);
		for (int i = 0; i < amount; i++)
			palindromes.add(new boolean[pLength]);

		for (int i = 0; i < amount; i++) {
			boolean[] p = palindromes.get(i);
			p[0] = true;
			p[p.length - 1] = true;
		}

		int steps = 1;
		for (int i = 1; i < pLength / 2d; i++) {

			for (int j = 0; j < amount; j += steps * 2) {

				for (int h = j; h < j + steps; h++) {
					boolean[] p = palindromes.get(h);
					p[i] = true;
					p[p.length - 1 - i] = true;
				}
			}
			steps *= 2;
		}

		return palindromes;
	}

	private static final int[] BINARY = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768,
			65536, 131072, 262144, 524288 };

	private static int binaryToDecimal(boolean[] pNumber) {
		int sum = 0;

		for (int i = 0; i < pNumber.length; i++)
			if (pNumber[i])
				sum += BINARY[i];

		return sum;
	}

	private static boolean isPalindrom(String s) {

		if (s.length() <= 1)
			return true;

		if (s.charAt(0) == s.charAt(s.length() - 1))
			return isPalindrom(s.substring(1, s.length() - 1));
		else
			return false;
	}

}
