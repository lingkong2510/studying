package com.lyang.studying.data_structure.graph.test1;

import java.util.Arrays;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/10 11:03 上午
 * @desc 测试图——无向图
 */
public class GraphTest {

    public static void main(String[] args) {
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");

        Graph graph = new Graph(5);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        graph.addEdge("B","C");
        graph.addEdge("B","A");
        graph.addEdge("B","D");
        graph.addEdge("B","E");
        graph.addEdge("A","C");

        int[][] matrix = graph.getAdjMat();
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
