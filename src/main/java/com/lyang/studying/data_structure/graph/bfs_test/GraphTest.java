package com.lyang.studying.data_structure.graph.bfs_test;

import java.util.Arrays;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/13 3:22 下午
 * @desc 广度优先搜索
 */
public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(9);
        Vertex v0 = new Vertex("V0");
        Vertex v1 = new Vertex("V1");
        Vertex v2 = new Vertex("V2");
        Vertex v3 = new Vertex("V3");
        Vertex v4 = new Vertex("V4");
        Vertex v5 = new Vertex("V5");
        Vertex v6 = new Vertex("V6");
        Vertex v7 = new Vertex("V7");
        Vertex v8 = new Vertex("V8");
        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.addVertex(v7);
        graph.addVertex(v8);

        graph.addEdge(v0,v1,10);
        graph.addEdge(v0,v5,11);
        graph.addEdge(v1,v2,18);
        graph.addEdge(v1,v8,12);
        graph.addEdge(v1,v6,16);
        graph.addEdge(v5,v6,17);
        graph.addEdge(v5,v4,26);
        graph.addEdge(v2,v8,8);
        graph.addEdge(v2,v3,22);
        graph.addEdge(v3,v6,24);
        graph.addEdge(v3,v8,21);
        graph.addEdge(v3,v7,16);
        graph.addEdge(v3,v4,20);
        graph.addEdge(v6,v7,19);
        graph.addEdge(v7,v4,7);

        System.out.println("==========邻接矩阵==========");
        for (int[] ints : graph.adjMat) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println("======深度优先遍历======");
        graph.depthFirstSearch();

        System.out.println("======广度优先遍历======");
        graph.breadthFirstSearch();

        System.out.println("======最小生成树=======");
        graph.prim4();

    }
}
