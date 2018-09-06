package Learn.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LearnRegex {

	public static void testString(String [] strs) {
		Pattern p =Pattern.compile("0\\d{3}-\\d{8}");
		for(String s:strs) {
		Matcher matcher = p.matcher(s);
			System.out.println(s+":"+matcher.matches());
		}
	}
	public static void main(String[] args) {
		String []strs= {"0575-88040203","1023-90392"};
		testString(strs);

	}

}
