import java.nio.file.Paths;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        String key = "61971cc96b0c0162fa921bad->21-22->CBSE->MonthlyTest->MonthlyTest-CBSE-IX-Mathematics-3524-17-01-2023-309712->IX->Mathematics->3524";
        System.out.println(key.replaceAll("->", "/"));
        System.out.println(Paths.get("test", "1", "2"));

//        System.out.println(Long.valueOf(null));
        List<UserInfo> allStudentSheetInfoWrtSlugAndQuiz = List.of(new UserInfo(1, "1"));
        List<UserInfo> ndUserInfos = allStudentSheetInfoWrtSlugAndQuiz.stream().filter(userInfo -> userInfo.getRollNo() == -1).toList();
        System.out.println(ndUserInfos);
        for(UserInfo u: ndUserInfos) {
            System.out.println("hello");
        }


        List<UserInfo> dbStudents = new ArrayList<>();
        UserInfo u1 = new UserInfo(1, "1");
        UserInfo u2 = new UserInfo(2, "2");
        UserInfo u3 = new UserInfo(3, "3");
        dbStudents.add(u1);
        dbStudents.add(u2);
        dbStudents.add(u3);

//        System.out.println(dbStudents);

        List<UserInfo> feStudents = new ArrayList<>();
        feStudents.add(u2);
        feStudents.add(u3);

//        System.out.println(feStudents);

        List<UserInfo> toBeDeleted = new ArrayList<>();
        List<UserInfo> finalToBeDeleted = toBeDeleted;
        dbStudents.forEach(dbStudent -> {
            if(!feStudents.contains(dbStudent)) {
                finalToBeDeleted.add(dbStudent);
            }
        });
//        for (UserInfo dbStudent: dbStudents) {
//            if (!feStudents.contains(dbStudent)) {
//                toBeDeleted.add(dbStudent);
//            }
//        }
//        System.out.println(toBeDeleted);

        toBeDeleted = new ArrayList<>(dbStudents);
        toBeDeleted.removeAll(feStudents);
//        System.out.println(toBeDeleted);
        List<Integer> integers = Arrays.asList(1, 2, 3);
    }

    public static class UserInfo {
        int id;
        String name;

        int rollNo;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getRollNo() {
            return rollNo;
        }

        public UserInfo(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof UserInfo userInfo)) return false;
            return id == userInfo.id && name.equals(userInfo.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "UserInfo{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();


        for (int i=0; i<nums.length - 2; i++) {
            int j=i+1, k=nums.length-1;
            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> subAns = Arrays.asList(nums[i],  nums[j],  nums[k]);
                    set.add(subAns);
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return new ArrayList<List<Integer>>(set);

    }



}
