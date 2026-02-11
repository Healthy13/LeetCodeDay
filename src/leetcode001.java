import java.util.HashMap;
import java.util.Map;

public class leetcode001 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, target);
        for (int j : result) {
            System.out.println(j);
        }
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 方法一：暴力法
        int len = nums.length;
        int sum = 0; // 两数之和
        int[] result = new int[2];
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                sum = nums[i] + nums[j];
                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        // 方法二：哈希表法
        int len = nums.length;
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        for (int j = 0; j < len; j++) {
            int diff = target - nums[j];
            if (map.containsKey(diff) && map.get(diff) != j) {
                result[0] = j;
                result[1] = map.get(diff);
                return result;
            }
        }
        return result;
    }
}
