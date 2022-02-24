package com.lyang.studying.data_structure.linear;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/21 5:23 下午
 * @desc 斐波那契
 */
public class FibonacciDemo {

    public static void main(String[] args) {
        //斐波那契数列：1 1 2 3 5 8 13 21 34 。。。。
        //就是从第三位数开始是前两项数字的和
        int result = fibonacci(7);
        System.out.println(result);
    }

    public static int fibonacci(int num){
        if (num ==1 || num ==2){
            return 1;
        }else{
            return fibonacci(num-1)+fibonacci(num-2);
        }
    }

}
