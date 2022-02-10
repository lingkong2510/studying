package com.lyang.studying.algorithm;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/1/10 4:12 下午
 * @desc 字符串压缩。
 * 利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没
 * 有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 */
public class CompressString {

    public static String compressString(String S) {
        int left = 0;
        int num = 0;
        StringBuilder bs = new StringBuilder();
        for (int right = 1; right < S.length(); right++) {
            num++;
            String leftS = String.valueOf(S.charAt(left));
            String rightS = String.valueOf(S.charAt(right));
            if (!leftS.equals(rightS)) {
                bs.append(leftS).append(num);
                num = 0;
                left = right;
            }
        }
        bs.append(S.charAt(left)).append(num);
        return bs.toString().length() < S.length() ? bs.toString() : S;
    }

    public static void main(String[] args) {
        String S = "aabcccccaaa";
        System.out.println(compressString(S));
    }

}
