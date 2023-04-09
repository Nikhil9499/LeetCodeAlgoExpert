import java.util.*;

public class _12_TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 4, 3, 2, 1, 3, 3, 3};
        System.out.println(topKFrequent(arr, 2));
        System.out.println(topKFrequentUsingBucketSortTechnique(arr, 2));
    }

//    Time: O(DlogD) where D = no. of distinct elements
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        System.out.println(freqMap);

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Integer> listAns = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            listAns.add(minHeap.poll().getKey());
        }
        return listAns;
    }

    // Time: O(D); where D = no. of distinct elements using bucketSort technique
    public static List<Integer> topKFrequentUsingBucketSortTechnique(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        System.out.println(freqMap);

        List<List<Integer>> bucket = new ArrayList<>(nums.length+1);
        for (int i=0; i<= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int val = entry.getValue();
            int key = entry.getKey();
            bucket.get(val).add(key);
        }
        System.out.println("Bucket is " + bucket);

        List<Integer> listAns = new ArrayList<>();
        for (int i=nums.length; i>=0; i--) {
            if (bucket.get(i).size() !=0) {
                for (int ele: bucket.get(i)) {
                    if (listAns.size() == k) {
                        return listAns;
                    }
                    listAns.add(ele);
                }
            }
        }
        return listAns;

    }

}
