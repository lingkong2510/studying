package com.lyang.studying;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootTest
class StudyingApplicationTests {

    @Test
    void contextLoads() {
        int num = 11;
        char c = (char) (num + 65 - 1);
        System.out.println(c);

    }

    @Test
    void test1() {
        boolean flag = isPalindrome("0P");
        System.out.println("aa\\saa");

        String a = "  2  2 df .pd f中 过  3   5";
        a = a.replaceAll("\\s", "");
        System.out.println(a);

        String[] split = a.split("\\s");
        System.out.println(split.length);

        for (String s : split) {
            System.out.println("=" + s + "=");
        }

    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((97 <= c && c <= 122) || (48 <= c && 57 >= c)) {
                sb.append(c);
            }
        }
        char[] chars = sb.toString().toCharArray();
        int left = 0;
        int right = sb.length() - 1;
        boolean flag = true;
        while (left <= right) {
            int num = chars[left] ^ chars[right];
            if (num != 0) {
                flag = false;
                break;
            }
            left++;
            right--;
        }
        return flag;
    }

    @Test
    void Test3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        int index = 4;
        int pageSize = 4;
        int startIndex = (index - 1) * pageSize;
        int endIndex = index * pageSize;
        List<Integer> result = list.subList(startIndex, endIndex);
        System.out.println(result);
    }

    @Test
    void Test4() {
        int a = 2147483647;
        a++;

        System.out.println(a);
        System.out.println(Integer.MIN_VALUE);

        int b = Integer.MIN_VALUE;
        b--;
        System.out.println(b);
        System.out.println(Integer.MAX_VALUE);

        byte c = Byte.MAX_VALUE;
        c++;
        System.out.println(c);
        System.out.println(Byte.MIN_VALUE);

        short s = Short.MAX_VALUE;
        s = Short.MIN_VALUE;
    }

    @Test
    void Test5() {
        Map<Object, Object> map = new HashMap<>();
        map.put(null, 1);
        System.out.println(map.get(null));

    }

    @Test
    void Test6() {
        int a = 128;
        int i = a >> 1;
        System.out.println(i);

        int b = 9;
        System.out.println(b >>> 1);

        long low64 = 0;
        long high64 = 0;
        long bitIndex = 1L << ('A' - 64);
        high64 |= bitIndex;
        System.out.println(bitIndex);
        System.out.println(high64);

        long bitIndex2 = 1L << ('1' - 64);

    }


    @Test
    void test7() {
        boolean leetcode = isUnique("leetcode");
        System.out.println(leetcode);
    }

    public boolean isUnique(String astr) {
        long low64 = 0;
        long high64 = 0;
        for (char c : astr.toCharArray()){
            if (c >= 64){
                long bit = 1L << (c - 64);
                if ((high64 & bit) != 0){
                    return false;
                }
                high64 |= bit;
            }else{
                long bit = 1L << c;
                if ((low64 & bit) != 0){
                    return false;
                }
                low64 |= bit;
            }
        }

        return true;
    }

    @Test
    void test8(){
        byte b = 1;
        int i = b << (2 - 3);
        System.out.println(i);
    }

}
