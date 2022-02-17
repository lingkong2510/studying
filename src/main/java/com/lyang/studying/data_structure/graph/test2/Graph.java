package com.lyang.studying.data_structure.graph.test2;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/10 3:23 下午
 * @desc 带权邻接矩阵
 */
public class Graph {

    private Vertex[] vertices;
    private int currIndex;
    private int weight;
    private final int DEFAULT = -1;
    public int[][] adjMat;//邻接矩阵 adjacency matrix

    public Graph(int size) {
        vertices = new Vertex[size];
        adjMat = new int[size][size];
        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat[i].length; j++) {
                if (i == j) {
                    adjMat[i][j] = 0;
                } else {
                    adjMat[i][j] = DEFAULT;
                }
            }
        }
    }

    public void addVertex(Vertex vertex) {
        vertices[currIndex++] = vertex;
    }

    public int getOutDegree(Vertex vertex) {
        int degree = 0;
        int row = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].getValue().equals(vertex.getValue())) {
                row = i;
                break;
            }
        }

        for(int i = 0;i<adjMat[row].length;i++){
            if (adjMat[row][i] != 0 && adjMat[row][i] != DEFAULT){
                degree++;
            }
        }

        return degree;
    }

    public int getInDegree(Vertex vertex) {
        int degree = 0;
        int column = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].getValue().equals(vertex.getValue())) {
                column = i;
                break;
            }
        }

        for(int i = 0;i<adjMat[column].length;i++){
            if (adjMat[i][column] != 0 && adjMat[i][column] != DEFAULT){
                degree++;
            }
        }

        return degree;
    }

    public void addEdge(Vertex v1, Vertex v2, int weight) {
        int index1 = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].getValue().equals(v1.getValue())) {
                index1 = i;
            }
        }

        int index2 = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].getValue().equals(v2.getValue())) {
                index2 = i;
            }
        }

        adjMat[index1][index2] = weight;
    }


}
