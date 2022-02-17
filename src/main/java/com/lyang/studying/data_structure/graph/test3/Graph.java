package com.lyang.studying.data_structure.graph.test3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/17 11:00 上午
 * @desc
 */
public class Graph {

    private Vertex[] vertices;
    private final int vertexSize;
    public String[][] adjMat;
    private final String MAX_NUMBER = "m";
    private int currentIndex = 0;
    private boolean[] visited;

    public Graph(int size) {
        vertexSize = size;
        vertices = new Vertex[size];
        adjMat = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    adjMat[i][j] = MAX_NUMBER;
                } else {
                    adjMat[i][j] = "0";
                }
            }
        }
        visited = new boolean[size];

    }

    public void addVertex(Vertex vertex) {
        vertices[currentIndex++] = vertex;
    }

    public void addEdge(Vertex v1, Vertex v2, int weight) {
        int index1 = getVertexIndex(v1);
        int index2 = getVertexIndex(v2);

        adjMat[index1][index2] = String.valueOf(weight);
        adjMat[index2][index1] = String.valueOf(weight);

    }

    public Vertex getFirstNeighbor(Vertex vertex) {
        int vertexIndex = this.getVertexIndex(vertex);
        for (int i = 0; i < vertexSize; i++) {
            if (!adjMat[vertexIndex][i].equals("0") && !adjMat[vertexIndex][i].equals(MAX_NUMBER)) {
                return vertices[i];
            }
        }
        return null;
    }

    public Vertex getNextNeighbor(Vertex current,Vertex neighbor) {
        int vertexIndex = this.getVertexIndex(current);
        int neighborIndex = this.getVertexIndex(neighbor);
        for (int i = neighborIndex + 1; i < vertexSize; i++) {
            if (!adjMat[vertexIndex][i].equals("0") && !adjMat[vertexIndex][i].equals(MAX_NUMBER)) {
                return vertices[i];
            }
        }
        return null;
    }

    public void depthFirstSearch() {
        for (int i = 0; i < vertexSize; i++) {
            if (!visited[i]) {
                System.out.println("访问到了" + vertices[i].getValue() + "顶点");
                depthFirstSearch(vertices[i]);
            }
        }
    }


    public void breadthFirstSearch() {
        visited = new boolean[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            if (!visited[i]) {
                System.out.println("访问到了" + vertices[i].getValue() + "顶点");
                visited[i] = true;
                breadthFirstSearch(vertices[i]);
            }
        }
        visited = new boolean[vertexSize];
    }

    private void breadthFirstSearch(Vertex vertex) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(vertex);
        while (!queue.isEmpty()){
            Vertex currVertex = queue.remove();
            Vertex neighbor = this.getFirstNeighbor(currVertex);
            while (neighbor != null){
                int neighborIndex = this.getVertexIndex(neighbor);
                if (!visited[neighborIndex]){
                    System.out.println("访问到了" + vertices[neighborIndex].getValue() + "顶点");
                    visited[neighborIndex] = true;
                    queue.add(neighbor);
                }
                neighbor = this.getNextNeighbor(currVertex,neighbor);
            }
        }

    }

    private void depthFirstSearch(Vertex vertex) {
        int currentIndex = this.getVertexIndex(vertex);
        visited[currentIndex] = true;
        Vertex neighbor = this.getFirstNeighbor(vertex);
        while (neighbor != null) {
            int neighborIndex = this.getVertexIndex(neighbor);
            if (!visited[neighborIndex]) {
                System.out.println("访问到了" + vertices[neighborIndex].getValue() + "顶点");
                depthFirstSearch(neighbor);
            }
            neighbor = this.getFirstNeighbor(neighbor);
        }
    }

    private void depthFirstSearch1(Vertex vertex) {
        int currIndex = this.getVertexIndex(vertex);
        visited[currIndex] = true;
        Vertex neighbor = this.getFirstNeighbor(vertex);
        while (neighbor != null) {
            int neighborIndex = this.getVertexIndex(neighbor);
            if (!visited[neighborIndex]) {
                System.out.println("访问到了" + vertices[neighborIndex].getValue() + "顶点");
                depthFirstSearch1(neighbor);
            }
            neighbor = this.getFirstNeighbor(neighbor);
        }
    }

    private int getVertexIndex(Vertex vertex) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].getValue().equals(vertex.getValue())) {
                return i;
            }
        }
        return -1;
    }

}
