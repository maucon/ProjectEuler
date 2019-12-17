package java_.solution.problem_0022;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Problem {

	public static int solve() {

		ArrayList<String> names = sort(Objects.requireNonNull(readNames()));

		int sum = 0;

		for (int i = 1; i <= names.size(); i++)
			sum += worth(names.get(i - 1)) * i;

		return sum;
	}

	private static ArrayList<String> sort(ArrayList<String> pNames) {

		if (pNames.size() == 1)
			return pNames;

		ArrayList<String> list1 = new ArrayList<>(pNames.subList(0, pNames.size() / 2));
		list1 = sort(list1);

		ArrayList<String> list2 = new ArrayList<>(pNames.subList(pNames.size() / 2, pNames.size()));
		list2 = sort(list2);

		ArrayList<String> sorted = new ArrayList<>();
		while (list1.size() > 0 && list2.size() > 0) {

			if (list1.get(0).compareTo(list2.get(0)) < 0) {
				sorted.add(list1.get(0));
				list1.remove(0);
			} else {
				sorted.add(list2.get(0));
				list2.remove(0);
			}
		}

		if (list1.size() == 0)
			sorted.addAll(list2);
		else
			sorted.addAll(list1);

		return sorted;
	}

	private static int worth(String pName) {

		int worth = 0;

		for (int i = 0; i < pName.length(); i++)
			worth += (int) pName.charAt(i) - 64;

		return worth;
	}

	private static ArrayList<String> readNames() {

		try {
			BufferedReader br = new BufferedReader(
					new FileReader(new File(new File("src/java.sol.problem_0022/names.txt").getAbsolutePath())));

			String s = br.readLine();
			br.close();
			return new ArrayList<>(Arrays.asList(s.replaceAll("\"", "").split(",")));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
