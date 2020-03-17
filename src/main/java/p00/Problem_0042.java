package p00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem_0042 {

    public static int solve() {
        ArrayList<String> WORDS = readWords();

        ArrayList<Integer> values = new ArrayList<Integer>();
        int highest_value = 0;

        for (String s : WORDS) {
            int value = 0;

            for (int j = 0; j < s.length(); j++)
                value += (int) s.charAt(j) - 64;

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
        for (Integer value : values)
            if (triangle_numbers.contains(value))
                triangle_words++;

        return triangle_words;
    }

    private static ArrayList<String> readWords() {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new URL("https://projecteuler.net/project/resources/p042_words.txt").openConnection().getInputStream()));

            String s = br.readLine();
            br.close();
            return new ArrayList<String>(Arrays.asList(s.replaceAll("\"", "").split(",")));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
