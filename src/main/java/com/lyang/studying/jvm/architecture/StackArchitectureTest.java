package com.lyang.studying.jvm.architecture;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/1/8 4:29 下午
 * @desc JVM的架构模型——栈的架构模型
 */
public class StackArchitectureTest {
    public static void main(String[] args) {
        int i = 2;
        int j =3;
        int k = i + j;


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("hello");
    }
}
