import java.util.*;

public class Problem9_TwoSumTransactions {

    public List<int[]> twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                result.add(new int[]{complement, nums[i]});
            }

            map.put(nums[i], i);
        }

        return result;
    }

    public static void main(String[] args) {

        Problem9_TwoSumTransactions obj = new Problem9_TwoSumTransactions();

        int[] nums = {2, 7, 11, 15};

        List<int[]> pairs = obj.twoSum(nums, 9);

        for (int[] pair : pairs) {
            System.out.println(pair[0] + " + " + pair[1]);
        }
    }
}