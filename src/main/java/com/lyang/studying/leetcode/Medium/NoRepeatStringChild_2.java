package com.lyang.studying.leetcode.Medium;

import java.util.*;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/25 9:50 上午
 * @desc 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * Related Topics 哈希表 字符串 滑动窗口
 */
public class NoRepeatStringChild_2 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")+"==3");
        System.out.println(lengthOfLongestSubstring("bbbbb")+"==1");
        System.out.println(lengthOfLongestSubstring("pwwkew") + "==3");
        System.out.println(lengthOfLongestSubstring("aab") + "==2");
        System.out.println(lengthOfLongestSubstring("") + "==0");
        System.out.println(lengthOfLongestSubstring("dvdf") + "==3");
    }


    //pwwkew dvdf
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)),left);
            }
            map.put(s.charAt(right), right + 1);
            max = Math.max(right - left + 1, max);
        }
        return max;

    }

    public static int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 字符串的-1，相当于我们在左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;

    }

    public static int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer index = map.get(s.charAt(i));
            if (index != null) {
                map.entrySet().removeIf(obj -> obj.getValue() <= index);
            }
            map.put(s.charAt(i), i);
            sum = Math.max(sum, map.size());

        }
        return sum;

    }

}

