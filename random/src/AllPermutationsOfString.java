import java.util.ArrayList;
import java.util.List;

public class AllPermutationsOfString {
	public static void main(String[] args) {
		String str = "abc";
		printAllPermutations(str, "");
		System.out.println();
		printAllPermutations(str, 0, str.length()-1);
		System.out.println("Print list of all string permutation");
		List<String> ans = new ArrayList<>();
		System.out.println(allPermutations(str, ans, "", str.length()));
		//System.out.println(ans);
	}

	public static void printAllPermutations(String str, String ans) {

		if (str.length() == 0) {
			System.out.println(ans + " ");
			return;
		}

		for (int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			String rem = str.substring(0, i) + str.substring(i+1);
			printAllPermutations(rem, ans + ch);
		}

	}

	public static void printAllPermutations(String str, int l, int r) {

		if (l == r) {
			System.out.println(str + " ");
			return;
		}

		for (int i=l; i<=r; i++) {
			str = swap(str, l,i);
			printAllPermutations(str, l+1, r);
			str = swap(str, l, i);
		}

	}

	public static String swap(String str, int i, int j) {
		char[] charArr = str.toCharArray();
		char temp = charArr[i];
		charArr[i] = charArr[j];
		charArr[j] = temp;
		return new String(charArr);
	}

	public static List<String> allPermutations(String str, List<String> ans, String current, int n) {

		if (current.length() == n) {
			ans.add(current);
			return ans;
		}

		for (int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			String rem = str.substring(0, i) + str.substring(i+1);
			allPermutations(rem, ans,current + ch, n);
		}
		return ans;
	}

}
