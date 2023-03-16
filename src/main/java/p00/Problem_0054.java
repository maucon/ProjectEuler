package p00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Problem_0054 {

    private static final String[] SUITS = {"H", "C", "S", "D"};
    private static final String[] CARDS = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};

    private static int count = 0;

    public static int solve() {
        ArrayList<String> hands = read();
        for (String s : hands)
            compareHands(s.substring(0, 14), s.substring(15));

        return count;
    }

    private static void compareHands(String handOne, String handTwo) {
        int[] cardsOne = countCards(handOne);
        int[] cardsTwo = countCards(handTwo);
        boolean sameSuitOne = testSameSuit(handOne);
        boolean sameSuitTwo = testSameSuit(handTwo);

        if (compare(testStraightFlush(cardsOne, sameSuitOne), testStraightFlush(cardsTwo, sameSuitTwo), cardsOne, cardsTwo))
            return;
        if (compare(testXOfAKind(cardsOne, 4), testXOfAKind(cardsTwo, 4), cardsOne, cardsTwo))
            return;
        if (compare(testFullHouse(cardsOne), testFullHouse(cardsTwo), cardsOne, cardsTwo))
            return;
        if (compareSameSuit(sameSuitOne, sameSuitTwo, cardsOne, cardsTwo))
            return;
        if (compare(testStraight(cardsOne), testStraight(cardsTwo), cardsOne, cardsTwo))
            return;
        if (compare(testXOfAKind(cardsOne, 3), testXOfAKind(cardsTwo, 3), cardsOne, cardsTwo))
            return;
        if (compare(testTwoPairs(cardsOne), testTwoPairs(cardsTwo), cardsOne, cardsTwo))
            return;
        if (compare(testXOfAKind(cardsOne, 2), testXOfAKind(cardsTwo, 2), cardsOne, cardsTwo))
            return;
        compareHighestCards(cardsOne, cardsTwo);
    }

    private static boolean compareSameSuit(boolean sameSuitOne, boolean sameSuitTwo, int[] cardsOne, int[] cardsTwo) {
        if (sameSuitOne && !sameSuitTwo) {
            count++;
            return true;
        }
        if (sameSuitTwo && !sameSuitOne)
            return true;
        if (!sameSuitOne)
            return false;

        compareHighestCards(cardsOne, cardsTwo);
        return true;
    }

    private static boolean compare(int a, int b, int[] cardsOne, int[] cardsTwo) {
        if (a > b) {
            count++;
            return true;
        }
        if (b > a)
            return true;
        if (a == -1) return false;
        compareHighestCards(cardsOne, cardsTwo);

        return true;
    }

    private static void compareHighestCards(int[] cardsOne, int[] cardsTwo) {
        for (int i = CARDS.length - 1; i >= 0; i--) {
            if (cardsOne[i] > cardsTwo[i]) {
                count++;
                return;
            }
            if (cardsTwo[i] > cardsOne[i])
                return;
        }
    }

    private static int testFullHouse(int[] cards) {
        int pair = testXOfAKind(cards, 2);
        if (pair == -1) return -1;
        int triple = testXOfAKind(cards, 3);
        if (triple == -1) return -1;
        return (triple + 1) * CARDS.length + pair;
    }

    private static int testTwoPairs(int[] cards) {
        int higherPair = -1;
        for (int i = cards.length - 1; i >= 0; i--)
            if (cards[i] == 2) {
                if (higherPair == -1)
                    higherPair = i;
                else
                    return higherPair * CARDS.length + i;
            }
        return -1;
    }

    private static int testXOfAKind(int[] cards, int x) {
        for (int i = 0; i < cards.length; i++)
            if (cards[i] == x) return i;
        return -1;
    }

    private static int testStraightFlush(int[] cards, boolean sameSuit) {
        if (!sameSuit) return -1;
        return testStraight(cards);
    }

    private static int testStraight(int[] cards) {
        int consecutive = 0;
        for (int i = 0; i < CARDS.length; i++)
            if (cards[i] == 0) {
                if (consecutive > 0) return -1;
            } else if (++consecutive == 5)
                return i;

        return -1;
    }

    private static boolean testSameSuit(String hand) {
        for (String suit : SUITS) if ((" " + hand).split(suit).length - 1 == 5) return true;
        return false;
    }

    private static int[] countCards(String hand) {
        int[] cards = new int[CARDS.length];
        for (int i = 0; i < CARDS.length; i++)
            cards[i] = (" " + hand).split(CARDS[i]).length - 1;

        return cards;
    }

    private static ArrayList<String> read() {
        ArrayList<String> hands = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new URL("https://projecteuler.net/project/resources/p054_poker.txt").openConnection().getInputStream()));
            hands = br.lines().collect(Collectors.toCollection(ArrayList::new));
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hands;
    }
}
