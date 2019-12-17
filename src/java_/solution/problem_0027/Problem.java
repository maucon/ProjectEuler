package java_.solution.problem_0027;

import java.util.ArrayList;

public class Problem {

	public static final String DESCRIPTION = "Euler discovered the remarkable quadratic formula:\r\n"
			+ "\r\n\t\tn2+n+41\r\n\r\n"
			+ "\t  It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤39.\r\n"
			+ "\t  However, when n=40,402+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,412+41+41\r\n"
			+ "\t  is clearly divisible by 41.\r\n\r\n" + "\t  The incredible formula n2−79n+1601\r\n"
			+ "\t  was discovered, which produces 80 primes for the consecutive values 0≤n≤79.\r\n"
			+ "\t  The product of the coefficients, −79 and 1601, is −126479.\r\n"
			+ "\t  Considering quadratics of the form:\r\n\r\n" + "\t\tn2+an+b, where |a|<1000 and |b|≤1000\r\n\r\n"
			+ "\t\twhere |n| is the modulus/absolute value of n\r\n" + "\t\te.g. |11|=11 and |−4|=4\r\n\r\n"
			+ "\t  Find the product of the coefficients, aand b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n=0.";

	public static int solve() {

		ArrayList<Integer> primes = primes();

		int highest_amount_of_primes = 0;
		int product = 0;

		for (int p = 0; p < primes.size(); p++) {
			for (int a = -999; a < 1000; a += 2) {

				int n = 0;
				int b = primes.get(p);

				while (isPrime(n * n + a * n + b))
					n++;

				if (n > highest_amount_of_primes) {
					highest_amount_of_primes = n;
					product = a * b;
				}
			}
		}
		return product;
	}

	private static boolean isPrime(int pNumber) {

		if (pNumber < 0)
			return false;

		int square_root = (int) Math.sqrt(pNumber) + 1;
		for (int i = 2; i < square_root; i++)
			if (pNumber % i == 0)
				return false;

		return true;
	}

	private static ArrayList<Integer> primes() {

		boolean[] all_numbers = new boolean[1000];
		ArrayList<Integer> primes = new ArrayList<Integer>();

		for (int i = 2; i < 1000; i++) {

			while (i < 1000 && all_numbers[i])
				i++;

			if (i == 1000)
				break;

			primes.add(i);

			for (int j = i; j < 1000; j += i)
				all_numbers[j] = true;
		}
		return primes;
	}

}
