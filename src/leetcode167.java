public class leetcode167 {
    public static void main(String[] args) {
        int[] numbers = new int[] {2,7,11,15};
        int target = 9;
        Solution167 solution = new Solution167();
        int[] result = solution.twoSum(numbers, target);
        System.out.println("[");
        for (int res : result) {
            System.out.println(res);
        }
        System.out.println("]");
    }
}

class Solution167 {
    /*
        相向双指针解决两数之和问题，关键是利用了数组有序的条件
        时间复杂度：o(n)
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else {
                right--;
            }
        }
        return result;
    }
}