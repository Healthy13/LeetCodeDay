public class leetcode283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Solution283 solution = new Solution283();
        solution.moveZeroes(nums);
    }
}

class Solution283 {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        // 第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋值给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        // 非0元素统计完了，剩下的就是0了
        // 所以第二次遍历把末尾的元素赋值为0即可
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
