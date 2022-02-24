package com.lyang.studying.data_structure.graph.kruskal;

import java.util.Arrays;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/18 3:10 下午
 * @desc
 */
public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(15,9);
        createEdge(graph);
        graph.getEdges().forEach(edge -> {
            System.out.println("begin:"+edge.getBegin().getValue()+" , end:"+edge.getEnd().getValue() + " , weight:"+edge.getWeight());
        });

        System.out.println("最小生成树");
        graph.miniSpanTreeKruskal();

    }

    public static void createEdge(Graph graph) {
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

        Edge edge0 = new Edge(v4, v7, 7);
        Edge edge1 = new Edge(v2, v8, 8);
        Edge edge2 = new Edge(v0, v1, 10);
        Edge edge3 = new Edge(v0, v5, 11);
        Edge edge4 = new Edge(v1, v8, 12);
        Edge edge5 = new Edge(v3, v7, 16);
        Edge edge6 = new Edge(v1, v6, 16);
        Edge edge7 = new Edge(v5, v6, 17);
        Edge edge8 = new Edge(v1, v2, 18);
        Edge edge9 = new Edge(v6, v7, 19);
        Edge edge10 = new Edge(v3, v4, 20);
        Edge edge11 = new Edge(v3, v8, 21);
        Edge edge12 = new Edge(v2, v3, 22);
        Edge edge13 = new Edge(v3, v6, 24);
        Edge edge14 = new Edge(v4, v5, 26);

        graph.addEdge(edge0);
        graph.addEdge(edge1);
        graph.addEdge(edge2);
        graph.addEdge(edge3);
        graph.addEdge(edge4);
        graph.addEdge(edge5);
        graph.addEdge(edge6);
        graph.addEdge(edge7);
        graph.addEdge(edge8);
        graph.addEdge(edge9);
        graph.addEdge(edge10);
        graph.addEdge(edge11);
        graph.addEdge(edge12);
        graph.addEdge(edge13);
        graph.addEdge(edge14);

    }
}
