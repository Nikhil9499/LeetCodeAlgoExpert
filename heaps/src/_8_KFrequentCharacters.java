import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _8_KFrequentCharacters {
	public static void main(String[] args) {
		System.out.println(kFrequentCharacter("bcdaa", 3));
		System.out.println(kFrequentCharacter("bcddaa", 2));
	}
	static String kFrequentCharacter(String str, int k) {
		Map<Character, Integer> freqMap = new HashMap<>();

		int n = str.length();

		for (int i=0; i<n; i++) {
			char ch = str.charAt(i);
			freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
		}

		List<Map.Entry<Character, Integer>> list = new LinkedList<>(freqMap.entrySet());

		list.sort((o1, o2) -> {
			if (!o1.getValue().equals(o2.getValue())) {
				return (o2.getValue()).compareTo(o1.getValue());
			} else {
				return o1.getKey() - o2.getKey();
			}
		});

		if (list.size() < k) {
			return "-1";
		}

		int count = 0;
		for (int i=0; i<list.size(); i++) {
			if (i==0 || !list.get(i).getValue().equals(list.get(i - 1).getValue())) {
				count++;
			}
			if (count == k) {
				return list.get(i).getKey()+"";
			}
		}
		return "-1";
	}
}
