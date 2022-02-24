package com.lyang.studying.data_structure.graph.topological_test;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/23 2:24 下午
 * @desc
 */
public class TopologicalDemo {

    public static void main(String[] args) {
        Topological topological = new Topological(14);
        topological.topologicalSort();
    }
}
