import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		System.out.println("Nikhil solving LeetCode");
		List<String> keys = List.of("test1", "test2");
		System.out.println(String.format("ADMIN_DROPDOWN : No data found for the keys %s", String.join(",", keys)));

		System.out.println(firstRep("go"));

		int[]arr = {1,5,7,9,3};
		post_order(arr, arr.length);
	}

	static char firstRep(String s) {
		char c = (char)(-1);
		int[]arr = new int[26];
		int n = s.length();

		for (int i=0; i<n; i++) {
			arr[s.charAt(i)-'a']++;
		}

		for (int i=0; i<n; i++) {
			if(arr[s.charAt(i)-'a'] > 1) {
				System.out.println("here");
				return s.charAt(i);
			}
		}
		return (char) -1;
	}

	public static void post_order(int pre[], int size) {
		int[]inorder = new int[size];
		for (int i=0; i<size; i++) {
			inorder[i] = pre[i];
		}
		Arrays.sort(inorder);
		
	}
}
