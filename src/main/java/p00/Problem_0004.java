package p00;

public class Problem_0004 {

	public static int solve() {

		int solution = 0;

		for (int j = 999; j > 99; j--)	
			if (j * 999 > solution) {

				for (int h = 999; h > 99; h--)
					if (j * h > solution) {

						if (isPalindrom(h * j + ""))
							solution = h * j;
						
					} else
						break;
			} else
				break;
		
		return solution;

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
