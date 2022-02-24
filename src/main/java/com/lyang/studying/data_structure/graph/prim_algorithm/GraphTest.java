package com.lyang.studying.data_structure.graph.prim_algorithm;

import java.util.Arrays;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/10 4:55 下午
 * @desc 深度优先算法，广度优先算法
 */
public class GraphTest {

    public static void main(String[] args) {


        System.out.println("======获取第一个相邻顶点======");
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
        graph.addEdge(v1,v0,10);
        graph.addEdge(v1,v2,18);
        graph.addEdge(v1,v6,16);
        graph.addEdge(v1,v8,12);
        graph.addEdge(v2,v1,18);
        graph.addEdge(v2,v3,22);
        graph.addEdge(v2,v8,8);
        graph.addEdge(v3,v2,22);
        graph.addEdge(v3,v4,20);
        graph.addEdge(v3,v6,24);
        graph.addEdge(v3,v7,16);
        graph.addEdge(v3,v8,21);
        graph.addEdge(v4,v3,20);
        graph.addEdge(v4,v5,26);
        graph.addEdge(v4,v7,7);
        graph.addEdge(v5,v0,11);
        graph.addEdge(v5,v4,26);
        graph.addEdge(v5,v6,17);
        graph.addEdge(v6,v1,16);
        graph.addEdge(v6,v3,24);
        graph.addEdge(v6,v5,17);
        graph.addEdge(v6,v7,19);
        graph.addEdge(v7,v3,16);
        graph.addEdge(v7,v4,7);
        graph.addEdge(v7,v6,19);
        graph.addEdge(v8,v1,12);
        graph.addEdge(v8,v2,8);
        graph.addEdge(v8,v3,21);

        System.out.println("==========邻接矩阵==========");
        for (int[] ints : graph.adjMat) {
            System.out.println(Arrays.toString(ints));
        }     System.out.println(graph.getFirstNeighbor(v0).getValue()+" 邻接 V1");
        System.out.println(graph.getFirstNeighbor(v1).getValue()+" 邻接 V0");
        System.out.println(graph.getFirstNeighbor(v2).getValue()+" 邻接 V1");
        System.out.println(graph.getFirstNeighbor(v3).getValue()+" 邻接 V2");
        System.out.println(graph.getFirstNeighbor(v4).getValue()+" 邻接 V3");
        System.out.println(graph.getFirstNeighbor(v5).getValue()+" 邻接 V0");
        System.out.println(graph.getFirstNeighbor(v6).getValue()+" 邻接 V1");
        System.out.println(graph.getFirstNeighbor(v7).getValue()+" 邻接 V3");
        System.out.println(graph.getFirstNeighbor(v8).getValue()+" 邻接 V1");

        System.out.println("======获取顶点相对第一个相邻顶点的相邻顶点======");
        System.out.println(graph.getNextNeighbor(v0, v1).getValue() + " 下一个相邻顶点 v5");
        System.out.println(graph.getNextNeighbor(v1, v3).getValue() + " 下一个相邻顶点 v6");
        System.out.println(graph.getNextNeighbor(v2, v1).getValue() + " 下一个相邻顶点 v3");
        System.out.println(graph.getNextNeighbor(v3, v1).getValue() + " 下一个相邻顶点 v2");
        System.out.println(graph.getNextNeighbor(v4, v1).getValue() + " 下一个相邻顶点 v3");
        System.out.println((graph.getNextNeighbor(v5, v6) == null ? "null":graph.getNextNeighbor(v5, v6).getValue() )+ " 下一个相邻顶点 null");
        System.out.println(graph.getNextNeighbor(v6, v5).getValue() + " 下一个相邻顶点 v7");
        System.out.println(graph.getNextNeighbor(v7, v1).getValue() + " 下一个相邻顶点 v3");
        System.out.println(graph.getNextNeighbor(v8, v1).getValue() + " 下一个相邻顶点 v2");

        System.out.println("======深度优先遍历======");
        graph.depthFirstSearch();

        System.out.println("======广度优先遍历======");
        graph.breadthFirstSearch();

        System.out.println("======普里姆算法=======");
        graph.prim2();

    }

}
