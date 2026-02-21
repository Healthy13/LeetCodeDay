import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode015 {
    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        Solution015 solution = new Solution015();
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result.toString());
    }
}

class Solution015 {

    /**
     * 015、三数之和
     *
     * 可以看成是，外层一个循环，两数之和问题，主要是去重
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums); // 先进行排序
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于零，则结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重复
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }
}
