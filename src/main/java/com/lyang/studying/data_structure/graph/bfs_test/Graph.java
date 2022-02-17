package com.lyang.studying.data_structure.graph.bfs_test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/13 3:11 下午
 * @desc 广度优先搜索
 */
public class Graph {

    private final Vertex[] vertices;
    private int currentIndex;
    private int vertexSize;
    public int[][] adjMat;
    private boolean isVisited[];
    private final int MAX_NUMBER = 1000;

    public Graph(int size) {
        vertexSize = size;
        vertices = new Vertex[size];
        adjMat = new int[size][size];
        isVisited = new boolean[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    adjMat[i][j] = MAX_NUMBER;
                }
            }
        }
    }

    public void addVertex(Vertex vertex) {
        vertices[currentIndex++] = vertex;
    }

    public void addEdge(Vertex v1, Vertex v2, int weight) {
        int row = getVertexIndex(v1);
        int col = getVertexIndex(v2);
        adjMat[row][col] = weight;
        adjMat[col][row] = weight;
    }

    private int getVertexIndex(Vertex vertex) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].getValue().equals(vertex.getValue())) {
                return i;
            }
        }
        return -1;
    }

    public void depthFirstSearch() {
        isVisited = new boolean[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            Vertex vertex = vertices[i];
            int index = getVertexIndex(vertex);
            if (!isVisited[index]) {
                System.out.println("访问到了：" + vertex.getValue() + "顶点");
                isVisited[index] = true;
                depthFirstSearch(vertex);
            }
        }
        isVisited = new boolean[vertices.length];
    }

    private void depthFirstSearch(Vertex vertex) {
        Vertex neighbor = getFirstNeighbor1(vertex);
        while (neighbor != null) {
            int neighborIndex = getVertexIndex(neighbor);
            if (!isVisited[neighborIndex]) {
                System.out.println("访问到了：" + neighbor.getValue() + "顶点");
                isVisited[neighborIndex] = true;
                depthFirstSearch(neighbor);
            }
            neighbor = getNextNeighbor(vertex, neighbor);

        }
    }

    public void breadthFirstSearch() {
        isVisited = new boolean[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            if (!isVisited[i]) {
                System.out.println("访问到了：" + vertices[i].getValue() + "顶点");
                isVisited[i] = true;
                breadthFirstSearch(vertices[i]);
            }
        }
        isVisited = new boolean[vertices.length];
    }

    private void breadthFirstSearch(Vertex vertex) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(vertex);
        while (!queue.isEmpty()) {
            Vertex currVertex = queue.remove();
            Vertex neighbor = getFirstNeighbor1(currVertex);
            while (neighbor != null) {
                int neighborIndex = getVertexIndex(neighbor);
                if (!isVisited[neighborIndex]) {
                    System.out.println("访问到了：" + vertices[neighborIndex].getValue() + "顶点");
                    isVisited[neighborIndex] = true;
                    queue.add(neighbor);
                }
                neighbor = getNextNeighbor(currVertex, neighbor);
            }
        }
    }

    private Vertex getFirstNeighbor1(Vertex vertex) {
        int index = getVertexIndex(vertex);
        for (int i = 0; i < adjMat[index].length; i++) {
            if (adjMat[index][i] != 0 && adjMat[index][i] != MAX_NUMBER) {
                return vertices[i];
            }
        }
        return null;
    }

    private Vertex getNextNeighbor(Vertex currVertex, Vertex neighbor) {
        int currIndex = getVertexIndex(currVertex);
        int neighborIndex = getVertexIndex(neighbor);
        for (int i = neighborIndex + 1; i < adjMat[currIndex].length; i++) {
            if (adjMat[currIndex][i] != 0 && adjMat[currIndex][i] != MAX_NUMBER) {
                return vertices[i];
            }
        }
        return null;
    }

    public void prim() {
        //最小代价顶点权值的数组，为0表示已经获取最小权值
        int[] lowcost = new int[vertexSize];
        //放顶点权值
        int[] adjvex = new int[vertexSize];

        int min, minIndex, sum = 0;
        for (int i = 0; i < vertexSize; i++) {
            lowcost[i] = adjMat[0][i];
        }
        for (int i = 1; i < vertexSize; i++) {
            min = MAX_NUMBER;
            minIndex = 0;
            for (int j = 1; j < vertexSize; j++) {
                if (lowcost[j] < min && lowcost[j] > 0) {
                    min = lowcost[j];
                    minIndex = j;
                }
            }
            System.out.println("顶点:" + adjvex[minIndex] + "权值：" + min);
            sum += min;
            lowcost[minIndex] = 0;
            for (int j = 1; j < vertexSize; j++) {
                if (lowcost[j] != 0 && adjMat[minIndex][j] < lowcost[j]) {
                    lowcost[j] = adjMat[minIndex][j];
                    adjvex[j] = minIndex;
                }
            }
        }
        System.out.println("最小生成的树的权值和：" + sum);
        System.out.println(Arrays.toString(adjvex));
    }

    public void prim1() {
        int[] lowcost = new int[vertexSize];
        int[] adjvex = new int[vertexSize];
        int minIndex, min, sum = 0;

        for (int i = 0; i < vertexSize; i++) {
            lowcost[i] = adjMat[0][i];
        }

        for (int i = 1; i < vertexSize; i++) {
            min = MAX_NUMBER;
            minIndex = 0;
            for (int j = 1; j < vertexSize; j++) {
                if (lowcost[j] > 0 && lowcost[j] < min) {
                    min = lowcost[j];
                    minIndex = j;
                }
            }
            System.out.println("顶点:" + adjvex[minIndex] + "权值：" + min);
            sum += min;
            lowcost[minIndex] = 0;
            for (int j = 1; j < vertexSize; j++) {
                if (lowcost[j] != 0 && adjMat[minIndex][j] < lowcost[j]) {
                    lowcost[j] = adjMat[minIndex][j];
                    adjvex[j] = minIndex;
                }
            }
        }
        System.out.println("最小生成的树的权值和：" + sum);
        System.out.println(Arrays.toString(adjvex));

    }

    public void prim2() {
        int[] lowcost = new int[vertexSize];
        int[] adjvex = new int[vertexSize];

        int min, minIndex, sum = 0;
        for (int i = 0; i < vertexSize; i++) {
            lowcost[i] = adjMat[0][i];
        }

        for (int i = 1; i < vertexSize; i++) {
            min = MAX_NUMBER;
            minIndex = 0;
            for (int j = 1; j < vertexSize; j++) {
                if (lowcost[j] != 0 && lowcost[j] < min) {
                    min = lowcost[j];
                    minIndex = j;
                }
            }
            System.out.println("顶点:" + adjvex[minIndex] + "权值：" + min);
            sum += min;
            lowcost[minIndex] = 0;

            for (int j = 1; j < vertexSize; j++) {
                if (lowcost[j] != 0 && lowcost[j] > adjMat[minIndex][j]) {
                    lowcost[j] = adjMat[minIndex][j];
                    adjvex[j] = minIndex;
                }
            }
        }
        System.out.println("最小生成的树的权值和：" + sum);
        System.out.println(Arrays.toString(adjvex));

    }

    public void prim3() {
        int[] lowcost = new int[vertexSize];
        int[] adjvex = new int[vertexSize];

        for (int i = 0; i < vertexSize; i++) {
            lowcost[i] = adjMat[0][i];
        }

        int min, minIndex, sum = 0;
        for (int i = 1; i < vertexSize; i++) {
            minIndex = 0;
            min = MAX_NUMBER;
            for (int j = 1; j < vertexSize; j++) {
                if (lowcost[j] != 0 && lowcost[j] < min) {
                    min = lowcost[j];
                    minIndex = j;
                }
            }
            System.out.println("顶点:" + adjvex[minIndex] + "权值：" + min);
            sum += min;
            lowcost[minIndex] = 0;
            for (int j = 1; j < vertexSize; j++) {
                if (lowcost[j] != 0 && lowcost[j] > adjMat[minIndex][j]) {
                    lowcost[j] = adjMat[minIndex][j];
                    adjvex[j] = minIndex;
                }
            }
        }
        System.out.println("最小生成的树的权值和：" + sum);
        System.out.println(Arrays.toString(adjvex));
    }

    public void prim4() {
        int[] lowcost = new int[vertexSize];
        int[] adjvex = new int[vertexSize];

        for (int i = 0; i < vertexSize; i++) {
            lowcost[i] = adjMat[0][i];
        }

        int min, minIndex, sum = 0;

        for (int i = 1;i<vertexSize; i++){
            min = MAX_NUMBER;
            minIndex = 0;
            for(int j = 1; j < vertexSize; j++){
                if (lowcost[j] != 0&& lowcost[j] < min){
                    min = lowcost[j];
                    minIndex = j;
                }
            }
            System.out.println("顶点:" + adjvex[minIndex] + "权值：" + min);
            sum += min;
            lowcost[minIndex] = 0;

            for (int j = 1;j<vertexSize;j++){
                if (lowcost[j] != 0 && lowcost[j] > adjMat[minIndex][j]){
                    lowcost[j] = adjMat[minIndex][j];
                    adjvex[j] = minIndex;
                }
            }

        }
        System.out.println("最小生成的树的权值和：" + sum);
        System.out.println(Arrays.toString(adjvex));

    }
}
