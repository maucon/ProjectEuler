package p01;

import java.util.HashSet;

public class Problem_0125 {

    private static final int limit = 100000000;

    public static long solve() {
        HashSet<Integer> conPalindromes = new HashSet<>();

        for (int startSquare = 1, startAdd = 1; startSquare < limit / 2; startSquare += (startAdd += 2))
            for (int add = startAdd + 2, nextSquare = startSquare + add, sum = startSquare + nextSquare; sum < limit; sum += nextSquare += add += 2)
                if (isPalindrome(String.valueOf(sum))) conPalindromes.add(sum);

        return conPalindromes.stream().mapToLong(i -> i).sum();
    }

    private static boolean isPalindrome(String s) {
        return (s.length() <= 1) || (s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(s.substring(1, s.length() - 1)));
    }
}
