package variable;

import java.util.HashMap;
import java.util.Map;

public class _2_LongestSubstringWithNoRepeatingChars {
	public static void main(String[] args) {
		String str = "abbacbcdbadbdbbdcb"; //
		System.out.println(longestSubstringWithNoRepeatingChars("string"));
		System.out.println(longestSubstringWithNoRepeatingChars("sstrring"));
		System.out.println(longestSubstringWithNoRepeatingChars(str));
	}

	public static int longestSubstringWithNoRepeatingChars(String str) {
		int i = 0, j = 0, n = str.length();
		Map<Character, Integer> map = new HashMap<>();
		int start=0,end=0;
		String ans = "";

		int maxLen = 0;
		while (j < n) {
			char currChar = str.charAt(j);
			map.put(currChar, map.getOrDefault(currChar, 0) + 1);

			// check for duplicates
			if (j != 0 && isDupsPresent(map)) {
				char iTh = str.charAt(i);
				map.put(iTh, map.get(iTh) - 1);
				if (map.get(iTh) == 0) {
					map.remove(iTh);
				}
				i++;
			} else {
				String possibleAns = str.substring(i,j+1);
				if (possibleAns.length() > ans.length()) {
					ans = possibleAns;
				}
				maxLen = Math.max(maxLen, j - i + 1);
			}
			j++;
		}
		System.out.println(ans);
		return maxLen;
	}

	private static boolean isDupsPresent(Map<Character, Integer> map) {
		for (Character ch : map.keySet()) {
			if (map.get(ch) > 1) {
				return true;
			}
		}
		return false;
	}
}
