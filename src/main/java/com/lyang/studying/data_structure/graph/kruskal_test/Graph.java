package com.lyang.studying.data_structure.graph.kruskal_test;

import org.apache.logging.log4j.util.PropertySource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/21 11:22 上午
 * @desc
 */
public class Graph {
    private List<Vertex> vertices;
    private List<Edge> edges;
    private int edgeSize;
    private int vertexSize;

    public Graph(int edgeSize,int vertexSize) {
        this.edgeSize = edgeSize;
        edges = new ArrayList<>(edgeSize);
        this.vertexSize = vertexSize;
        vertices = new ArrayList<>(vertexSize);
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public void sortEdge() {
        edges.sort(Comparator.comparing(Edge::getWeight));
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void addVertex(Vertex vertex){
        vertices.add(vertex);
    }

    public void miniSpanTreeKruskal() {
        int m, n, sum = 0;
        int[] parent = new int[edgeSize];
        for (int i = 0; i < edgeSize; i++) {
            Vertex begin = edges.get(i).getBegin();
            m = find(parent, begin);
            Vertex end = edges.get(i).getEnd();
            n = find(parent, end);
            if (m != n) {
                parent[m] = n;
                System.out.println("开始顶点:" + m + " ， 结束顶点：" + n + " ,权值：" + edges.get(i).getWeight());
                sum+=edges.get(i).getWeight();
            }
        }
        System.out.println("最短路径合："+sum);
    }

    private int find(int[] parent, Vertex vertex) {
        int index = getVertexIndex(vertex);
        while (parent[index] > 0){
            index = parent[index];
        }
        return index;
    }

    private int getVertexIndex(Vertex vertex) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getValue().equals(vertex.getValue())) {
                return i;
            }
        }
        return -1;
    }


}
