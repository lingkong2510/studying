package com.lyang.studying.data_structure.graph.kruskal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/18 2:55 下午
 * @desc
 */
public class Graph {

    public List<Edge> edges;

    private int edgeSize;

    private int currEdgeSize;

    private List<Vertex> vertices;

    private int vertexSize;


    public Graph(int edgeSize, int vertexSize) {
        this.edgeSize = edgeSize;
        this.vertexSize = vertexSize;
        edges = new ArrayList<>(edgeSize);
        vertices = new ArrayList<>(vertexSize);
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public int getEdgeSize() {
        return edgeSize;
    }

    public void setEdgeSize(int edgeSize) {
        this.edgeSize = edgeSize;
    }

    public int getCurrEdgeSize() {
        return currEdgeSize;
    }

    public void setCurrEdgeSize(int currEdgeSize) {
        this.currEdgeSize = currEdgeSize;
    }

    public void miniSpanTreeKruskal() {
        int m, n, sum = 0;
        int[] parent = new int[edgeSize];
        for (int i = 0; i < edgeSize; i++) {
            m = find(parent, edges.get(i).getBegin());
            n = find(parent, edges.get(i).getEnd());
            if (m != n) {
                parent[m] = n;
                System.out.println("开始顶点:" + m + " ， 结束顶点：" + n + " ,权值：" + edges.get(i).getWeight());
                sum += edges.get(i).getWeight();
            }
        }

        System.out.println("最短路径：" + sum);
    }

    private int find(int[] parent, Vertex vertex) {
        int index = getVertexIndex(vertex);
        while (parent[index] > 0) {
            index = parent[index];
        }
        return index;
    }

    private int getVertexIndex(Vertex vertex) {
        for (int i = 0; i < vertexSize; i++) {
            if (vertices.get(i).getValue().equals(vertex.getValue())) {
                return i;
            }
        }
        return -1;
    }


}
