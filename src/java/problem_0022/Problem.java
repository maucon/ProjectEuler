package java.problem_0022;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem {

	public static final String DESCRIPTION = "Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order.\r\n\t  Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.\r\n"
			+ "\t  For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 � 53 = 49714.\r\n"
			+ "\r\n\t  What is the total of all the name scores in the file?";

	public static int solve() {

		ArrayList<String> names = sort(readNames());

		int sum = 0;

		for (int i = 1; i <= names.size(); i++)
			sum += worth(names.get(i - 1)) * i;

		return sum;
	}

	private static ArrayList<String> sort(ArrayList<String> pNames) {

		if (pNames.size() == 1)
			return pNames;

		ArrayList<String> list1 = new ArrayList<String>();
		list1.addAll(pNames.subList(0, pNames.size() / 2));
		list1 = sort(list1);

		ArrayList<String> list2 = new ArrayList<String>();
		list2.addAll(pNames.subList(pNames.size() / 2, pNames.size()));
		list2 = sort(list2);

		ArrayList<String> sorted = new ArrayList<String>();
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
			worth += Integer.valueOf(pName.charAt(i)) - 64;

		return worth;
	}

	private static ArrayList<String> readNames() {

		try {
			BufferedReader br = new BufferedReader(
					new FileReader(new File(new File("src/java.problem_0022/names.txt").getAbsolutePath())));

			String s = br.readLine();
			br.close();
			return new ArrayList<String>(Arrays.asList(s.replaceAll("\"", "").split(",")));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
