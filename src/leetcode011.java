public class leetcode011 {
    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        Solution011 solution = new Solution011();
        int result = solution.maxArea(height);
        System.out.println(result);
    }
}

class Solution011 {
    /*
        相向双指针
        时间复杂度：o(n)
        循环一次就可以排除一个元素
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int max = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(max, ans);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}