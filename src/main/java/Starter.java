import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Starter {

    private Starter() {
        //TODO: dynamic timing testing with p 0 and j 0

        String cmd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("CLI active...");
        while (!(cmd = scanner.nextLine()).equals("exit")) {
            String[] command = cmd.split(" ");

            if (command.length != 2) {
                System.err.println("Invalid number of arguments!");
                continue;
            }

            try {
                int problemNumber = Integer.parseInt(command[1]);
                System.out.println("\033[4mProblem " + problemNumber + "\n\033[0m");

                if (problemNumber > 0) {
                    try {
                        Document doc = Jsoup.connect("https://projecteuler.net/problem=" + problemNumber).get();
                        System.out.println(doc.select("div.problem_content").first().text().replace(". ", ".\n"));
                        System.out.println();
                    } catch (IOException e) {
                        System.err.println("Can't find problem description!");
                    }
                }

                switch (command[0].toLowerCase()) {
                    case "py":
                    case "python":
                    case "p":
                        solvePython(problemNumber);
                        break;
                    case "jar":
                    case "java":
                    case "j":
                        solveJava(problemNumber);
                        break;
//                    case "c#":
//                    case "csharp":
//                    case "c":
//                        break;
                    default:
                        System.out.println("Invalid language: " + command[0]);
                        break;
                }

            } catch (NumberFormatException e) {
                System.err.println("Invalid argument!");
            }
        }

        System.out.println("CLI closed!");
    }

    private static void solvePython(int problemNumber) {
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd src && cd main && cd python && starter.py " + problemNumber);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;
            long start_time = System.nanoTime();
            while ((line = br.readLine()) != null) {
                if (line.contains("SOLUTION:")) {
                    String solution = line.split(":")[1];

                    long end_time = System.nanoTime() - start_time;
                    printResult(solution, end_time - 160653100);
                    return;
                }
                System.out.println(line);
            }

            System.err.println("Problem not solved yet!");

        } catch (IOException e) {
            System.err.println("Problem not solved yet!");
        }
    }

    private static void solveJava(int problemNumber) {
        try {
            StringBuilder pack = new StringBuilder("p" + (problemNumber / 100));
            while (pack.length() < 3) pack.insert(1, "0");

            StringBuilder pN = new StringBuilder("" + problemNumber);
            while (pN.length() < 4) pN.insert(0, "0");

            long start_time = System.nanoTime();
            Object solution = Class.forName(pack + ".Problem_" + pN).getDeclaredConstructor().newInstance().getClass().getMethod("solve").invoke(null);
            long end_time = System.nanoTime() - start_time;

            printResult(solution, end_time - 30500);

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            System.err.println("Problem not solved yet!");
        }
    }

    private static void printResult(Object solution, long time) {
        StringBuilder t = new StringBuilder(time + "");
        while (t.length() < 11) t.insert(0, 0);
        for (int i = t.length() - 3; i > 0; i -= 3)
            t = new StringBuilder(t.substring(0, i) + ":" + t.substring(i));

        System.out.println("Solution: " + solution);
        System.out.println("Time:     " + t.toString());
        System.out.println("         [ s| ms| μs| ns]");
    }


    public static void main(String[] args) {
        new Starter();
    }
}
