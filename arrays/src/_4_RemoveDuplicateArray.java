import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class _4_RemoveDuplicateArray {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6 };

		// ans: 1,2,3,4,5,6 -> 6
		removeDuplicates(arr);
		removeDuplicateUsingSet1(arr);
		removeDuplicateUsingSet2(arr);
		removeDuplicateUsingMap(arr);

		arr = new int[] {5, 2, 6, 8, 6, 7, 5, 2, 8};

		// ans: 5, 2, 6, 8, 7 -> 5
		removeDuplicates(arr); // won't work -> for testing only
		removeDuplicateUsingSet1(arr);
		removeDuplicateUsingSet2(arr);
		removeDuplicateUsingMap(arr);
	}

	//Using constant space work only for sorted array
	public static void removeDuplicates(int[]arr) {
		int j=0;

		for (int i=0; i<arr.length-1; i++) {
			if (arr[i] != arr[i+1]) {
				arr[j++] = arr[i];
			}
		}

		arr[j++] = arr[arr.length-1];

		for(int i=0; i<j; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print(" -> " + (j));
		System.out.println();
	}

	// Using space
	public static void removeDuplicateUsingSet1(int[]arr) {
		HashSet<Integer> set = new LinkedHashSet<>();
		for(int ele: arr) {
			set.add(ele);
		}
		System.out.println(set + " -> " + set.size());
	}

	public static void removeDuplicateUsingSet2(int[]arr) {
		HashSet<Integer> set = new LinkedHashSet<>();
		int count = 0;
		for(int ele: arr) {
			if (set.contains(ele)) {
				continue;
			} else {
				count++;
				set.add(ele);
				System.out.print(ele+" ");
			}
		}
		System.out.print(" -> " + count);
		System.out.println();
	}

	public static void removeDuplicateUsingMap(int[]arr) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		int count = 0;
		for (int ele: arr) {
			if (map.containsKey(ele)) {
				continue;
			} else {
				count++;
				System.out.print(ele+" ");
				map.put(ele, true);
			}
		}
		System.out.print(" -> " + count);
		System.out.println();
	}
}
