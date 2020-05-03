package luv2code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class MaxVowelsInFixedSizeSubstring {

	public static void main(String[] args) {

		String s = "BCDFGH"; //"ABEIEFC";
		int windowSize = 3;
		List<Character> chList = new ArrayList<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));

		int count = 0;
		int prevCount = 0;
		List<Character> finalChars = new ArrayList<>();

		Queue<Character> queue = new LinkedList<>();
		for (char ch : s.toCharArray()) {
			if (queue.size() == windowSize) {
				if(count > prevCount) {
					finalChars = queue.stream().collect(Collectors.toList());
					prevCount = count;
				}
				Character pop = queue.remove();
				if(chList.contains(pop)) {
					count--;
				}
			}
			if (chList.contains(ch)) {
				count++;
			}
			queue.add(ch);
		}

		System.out.println("Count = " + prevCount);
		finalChars.stream().forEach(System.out::print);

	}

}
