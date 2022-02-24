package com.lyang.studying.java8;

import java.util.Arrays;
import java.util.List;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/18 2:14 下午
 * @desc lambda演示
 */
public class LambdaDemo {

    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Lily", "Potter", "Hermine", "Ron", "Miler");
        String str = String.join(",", nameList);
    }
}
