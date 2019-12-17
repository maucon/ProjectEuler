package java.problem_0008;

import java.util.ArrayList;

public class Problem {

	public static final String DESCRIPTION = "The four adjacent digits in the 1000-digit number that have the greatest product are 9 � 9 � 8 � 9 = 5832.\r\n"
			+ "\t\t73167176531330624919225119674426574742355349194934\r\n"
			+ "\t\t96983520312774506326239578318016984801869478851843\r\n"
			+ "\t\t85861560789112949495459501737958331952853208805511\r\n"
			+ "\t\t12540698747158523863050715693290963295227443043557\r\n"
			+ "\t\t66896648950445244523161731856403098711121722383113\r\n"
			+ "\t\t62229893423380308135336276614282806444486645238749\r\n"
			+ "\t\t30358907296290491560440772390713810515859307960866\r\n"
			+ "\t\t70172427121883998797908792274921901699720888093776\r\n"
			+ "\t\t65727333001053367881220235421809751254540594752243\r\n"
			+ "\t\t52584907711670556013604839586446706324415722155397\r\n"
			+ "\t\t53697817977846174064955149290862569321978468622482\r\n"
			+ "\t\t83972241375657056057490261407972968652414535100474\r\n"
			+ "\t\t82166370484403199890008895243450658541227588666881\r\n"
			+ "\t\t16427171479924442928230863465674813919123162824586\r\n"
			+ "\t\t17866458359124566529476545682848912883142607690042\r\n"
			+ "\t\t24219022671055626321111109370544217506941658960408\r\n"
			+ "\t\t07198403850962455444362981230987879927244284909188\r\n"
			+ "\t\t84580156166097919133875499200524063689912560717606\r\n"
			+ "\t\t05886116467109405077541002256983155200055935729725\r\n"
			+ "\t\t71636269561882670428252483600823257530420752963450\r\n"
			+ "\t  Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?";

	private final static String string = "73167176531330624919225119674426574742355349194934"
			+ "96983520312774506326239578318016984801869478851843"
			+ "85861560789112949495459501737958331952853208805511"
			+ "12540698747158523863050715693290963295227443043557"
			+ "66896648950445244523161731856403098711121722383113"
			+ "62229893423380308135336276614282806444486645238749"
			+ "30358907296290491560440772390713810515859307960866"
			+ "70172427121883998797908792274921901699720888093776"
			+ "65727333001053367881220235421809751254540594752243"
			+ "52584907711670556013604839586446706324415722155397"
			+ "53697817977846174064955149290862569321978468622482"
			+ "83972241375657056057490261407972968652414535100474"
			+ "82166370484403199890008895243450658541227588666881"
			+ "16427171479924442928230863465674813919123162824586"
			+ "17866458359124566529476545682848912883142607690042"
			+ "24219022671055626321111109370544217506941658960408"
			+ "07198403850962455444362981230987879927244284909188"
			+ "84580156166097919133875499200524063689912560717606"
			+ "05886116467109405077541002256983155200055935729725"
			+ "71636269561882670428252483600823257530420752963450";

	public static long solve() {

		String[] strings = string.split("0");

		ArrayList<String> relevant_strings = new ArrayList<String>();

		for (int i = 0; i < strings.length; i++)
			if (strings[i].length() >= 13)
				relevant_strings.add(strings[i]);

		long solution = 0;

		for (int i = 0; i < relevant_strings.size(); i++) {

			String s = relevant_strings.get(i);

			int steps = s.length() - 12;

			for (int j = 0; j < steps; j++) {

				long product = 1;

				for (int h = j; h < j + 13; h++)
					product *= Integer.valueOf("" + s.charAt(h));

				if (product > solution)
					solution = product;

			}
		}

		return solution;
	}

}
