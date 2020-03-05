package java_;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public Main() {

        // ----------------------------------------------
        int problemNumber = 347;
        // ----------------------------------------------

        try {
            StringBuilder pN = new StringBuilder("" + problemNumber);
            while (pN.length() < 4) pN.insert(0, "0");

            System.out.println("\033[4mProblem " + problemNumber + "\n\033[0m");

            try {
                BufferedReader br = new BufferedReader(new FileReader(new File("src/problem/description/problem_" + pN + ".txt")));
                String line;
                while ((line = br.readLine()) != null) System.out.println(line);
                br.close();
            } catch (FileNotFoundException fnfe) {
                System.out.println("\033[91mNo problem description found!\033[0m");
            }

            System.out.println();

            long start_time = System.nanoTime();
            Object solution =
                    Class.forName("java_.solution.problem_" + pN + ".Problem").getDeclaredConstructor().newInstance().getClass().getMethod("solve").invoke(null);
            long end_time = System.nanoTime() - start_time - 300000;

            System.out.println("Solution: " + solution);
            System.out.println("Time:     " + timeFormat(end_time));
            System.out.println("         [ s| ms| μs| ns]");

        } catch (Exception e) {
            System.err.println("Problem not solved yet!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main();
    }

    private String timeFormat(long l) {
        StringBuilder t = new StringBuilder(l + "");

        while (t.length() < 11) t.insert(0, 0);

        for (int i = 8; i > 0; i -= 3)
            t = new StringBuilder(t.substring(0, i) + ":" + t.substring(i));

        return t.toString();
    }

}