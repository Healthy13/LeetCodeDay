import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode049 {
    public static void main(String[] args) {
        Solution049 solution = new Solution049();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = solution.groupAnagrams2(strs);
        System.out.println("[");
        for (List<String> item : res) {
            System.out.println(item);
        }
        System.out.println("]");
    }
}

class Solution049 {
    // 两种方法去解决问题：1、排序法 2、哈希法
    // 1、排序法
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList> result = new HashMap<>();
        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(s);
        }
        return new ArrayList(result.values());
    }

    // 实际结果，第一种方法要更高效一点

    // 2、哈希法
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, ArrayList<String>> result = new HashMap<>();
        for (String s : strs) {
            int[] count_table = new int[26];
            for (char c : s.toCharArray()) {
                // 当前是第几个字母，字母出现的次数
                count_table[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int count : count_table) {
                sb.append("#");
                sb.append(count);
            }
            String key = sb.toString();
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(s);
        }
        return new ArrayList(result.values());
    }
}
