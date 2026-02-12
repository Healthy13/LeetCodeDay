import java.util.HashSet;
import java.util.Set;

public class leetcode128 {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        Solution128 solution = new Solution128();
        int result = solution.longestConsecutive(nums);
        System.out.println(result);
    }
}

class Solution128 {
    /*
        核心思路：对于 nums 中的元素 x，以 x 为起点，
        不断查找下一个数 x+1,x+2,⋯ 是否在 nums 中，并统计序列的长度

        为了做到 O(n) 的时间复杂度，需要两个关键优化：
        1、把 nums 中的数都放入一个哈希集合中，这样可以 O(1) 判断数字是否在 nums 中。
        2、如果 x−1 在哈希集合中，则不以 x 为起点。为什么？
        因为以 x−1 为起点计算出的序列长度，一定比以 x 为起点计算出的序列长度要长！
        这样可以避免大量重复计算。比如 nums=[3,2,4,5]，从 3 开始，我们可以找到 3,4,5 这个连续序列；
        而从 2 开始，我们可以找到 2,3,4,5 这个连续序列，一定比从 3 开始的序列更长。
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }
        int ans = 0;
        for (int x : st) {
            if (st.contains(x - 1)) {  // 如果 x 不是序列的起点，直接跳过
                continue;
            }
            // x 是序列的起点
            int y = x + 1;
            while (st.contains(y)) { // 不断查找下一个数是否在哈希集合中
                y++;
            }
            // 循环结束后，y-1 是最后一个在哈希集合中的数
            ans = Math.max(ans, y - x);
        }
        return ans;
    }
}
