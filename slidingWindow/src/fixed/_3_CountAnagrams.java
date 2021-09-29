package fixed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _3_CountAnagrams {

	static int[] hash = new int[256];

	public static void main(String[] args) {
//		String text = "aabaabaa";
//		String word = "aaba";

//		String text = "forxxorfxdofr";
//		String word = "for";

		String text = "bpaa";
		String word = "aa";
		System.out.print(countAnagrams(text, word));
	}

	public static List<Integer> findAnagrams(String txt, String ptr) {
		List<Integer> ans = new ArrayList<>();

		Map<Character, Integer> ptrMap = new HashMap<>();
		for (int i=0; i<ptr.length(); i++) {
			ptrMap.put(ptr.charAt(i), ptrMap.getOrDefault(ptr.charAt(i), 0) + 1);
		}

		int i=0, j=0, n=txt.length(), k = ptr.length();

		while(j<n) {
			if (ptrMap.containsKey(txt.charAt(j)))
				hash[txt.charAt(j)]++;

			if (j-i+1 < k) {
				j++;
			} else if (j-i+1 == k) {
				if (isAnagram(ptrMap)) {
					ans.add(i);
				}
				if (ptrMap.containsKey(txt.charAt(i)))
					hash[txt.charAt(i)]--;
				i++;
				j++;
			}
		}

		return ans;
	}

	public static int countAnagrams(String txt, String ptr) {
		int ans = 0;

		//populateHashBasedOnPattern(ptr);
		Map<Character, Integer> ptrMap = new HashMap<>();
		for (int i=0; i<ptr.length(); i++) {
			ptrMap.put(ptr.charAt(i), ptrMap.getOrDefault(ptr.charAt(i), 0) + 1);
		}

		int i=0, j=0, n=txt.length(), k = ptr.length();

		while(j<n) {
			if (ptrMap.containsKey(txt.charAt(j)))
				hash[txt.charAt(j)]++;

			if (j-i+1 < k) {
				j++;
			} else if (j-i+1 == k) {
				if (isAnagram(ptrMap)) {
					ans++;
				}
				if (ptrMap.containsKey(txt.charAt(i)))
					hash[txt.charAt(i)]--;
				i++;
				j++;
			}
		}

		return ans;
	}

	public static boolean isAnagram(Map<Character, Integer> map) {
		for (Map.Entry<Character, Integer> entry: map.entrySet()) {
			if (hash[entry.getKey()] != entry.getValue()) {
				return false;
			}
		}
		return true;
	}

}
