package knapsackBased.bounded;


public class _6_CountSubsetsSumMinDiff {
	public static void main(String[] args) {
		int[] arr = {1, 6, 11, 5};
		System.out.println(countMinDiffSubsets(arr, arr.length, 1));

		int[] arr1 = {1, 2, 3, 1};
		System.out.println(countMinDiffSubsets(arr1, arr1.length, 1));
	}

	public static int countMinDiffSubsets(int[] arr, int n, int givenDiff) {
		int sum = 0;
		for (int ele : arr) {
			sum += ele;
		}
		// s1+s2 = summation of array elements
		// s1-s2 = givenDiff
		int sumToBeSearched = (givenDiff + sum) / 2;

		return _4_CountSubsetsWithGivenSum.countSubsetsWithGivenSum(arr, sumToBeSearched, n);
	}
}
