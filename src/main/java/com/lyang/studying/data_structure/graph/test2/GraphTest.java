package com.lyang.studying.data_structure.graph.test2;

import java.util.Arrays;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/10 3:50 下午
 * @desc 带权邻接矩阵测试
 */
public class GraphTest {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        Vertex v0 = new Vertex("V0");
        Vertex v1 = new Vertex("V1");
        Vertex v2 = new Vertex("V2");
        Vertex v3 = new Vertex("V3");
        Vertex v4 = new Vertex("V4");
        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        graph.addEdge(v1,v0,9);
        graph.addEdge(v2,v0,2);
        graph.addEdge(v1,v2,3);
        graph.addEdge(v2,v3,5);
        graph.addEdge(v0,v4,6);
        graph.addEdge(v3,v4,1);

        for (int[] ints : graph.adjMat) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("===============");
        System.out.println(v0.getValue()+"的出度是："+graph.getOutDegree(v0));
        System.out.println(v1.getValue()+"的出度是："+graph.getOutDegree(v1));
        System.out.println(v2.getValue()+"的出度是："+graph.getOutDegree(v2));
        System.out.println(v3.getValue()+"的出度是："+graph.getOutDegree(v3));
        System.out.println(v4.getValue()+"的出度是："+graph.getOutDegree(v4));

        System.out.println(v0.getValue()+"的入度是："+graph.getInDegree(v0));
        System.out.println(v1.getValue()+"的入度是："+graph.getInDegree(v1));
        System.out.println(v2.getValue()+"的入度是："+graph.getInDegree(v2));
        System.out.println(v3.getValue()+"的入度是："+graph.getInDegree(v3));
        System.out.println(v4.getValue()+"的入度是："+graph.getInDegree(v4));


    }
}
