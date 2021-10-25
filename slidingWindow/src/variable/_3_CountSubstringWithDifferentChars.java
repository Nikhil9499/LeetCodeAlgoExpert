package variable;

import java.util.HashMap;
import java.util.Map;

public class _3_CountSubstringWithDifferentChars {
	public static void main(String[] args) {
		System.out.println(substringWithDifferentChars("aabb"));
		System.out.println(substringWithNoRepeatingChars("aabb"));

		System.out.println(substringWithDifferentChars("abca"));
		System.out.println(substringWithNoRepeatingChars("abca"));

		System.out.println(substringWithDifferentChars("aabcbcdbca"));
		System.out.println(substringWithNoRepeatingChars("aabcbcdbca"));
	}

	public static int substringWithDifferentChars(String str) {
		Map<Character, Integer> map = new HashMap<>();
		int n = str.length();
		int ans = 0;
		int i = -1, j = -1;
		while (true) {
			boolean flag1 = false, flag2 = false;

			// acquire
			while (j < n - 1) {
				flag1 = true;
				j++;
				char ch = str.charAt(j);
				map.put(ch, map.getOrDefault(ch, 0) + 1);

				if (map.get(ch) == 2) {
					break;
				} else {
					ans += j - i;
				}
			}

			// release
			while (i < j) {
				flag2 = true;
				i++;
				char ch = str.charAt(i);
				map.put(ch, map.get(ch) - 1);

				if (map.get(ch) == 1) {
					ans += j - i;
					break;
				}
			}

			if (!(flag1 && flag2)) {
				break;
			}
		}
		return ans;
	}

	public static int substringWithNoRepeatingChars(String str) {
		int i = 0, j = 0, n = str.length();
		Map<Character, Integer> map = new HashMap<>();

		int count = 0;
		while (j < n) {
			char currChar = str.charAt(j);
			map.put(currChar, map.getOrDefault(currChar, 0) + 1);

			// check for duplicates
			if (isDupsPresent(map)) {
				boolean flag = true;
				while (flag || isDupsPresent(map)) {
					flag = false;
					char iTh = str.charAt(i);
					map.put(iTh, map.get(iTh) - 1);

					i++;
					if (map.get(iTh) == 1) {
						count += j - i + 1;
					}

					if (map.get(iTh) == 0) {
						map.remove(iTh);
					}
				}
			} else {
				count += j - i + 1;
			}
			j++;
		}
		//count += j-i;
		return count;
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
