package com.lyang.studying.data_structure.graph.test1;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/10 10:57 上午
 * @desc 图
 */
public class Graph {

    private final Vertex[] vertexes;
    private int currentSize;
    public int[][] adjMat;//邻接矩阵 adjacency matrix

    public Graph(int size){
        vertexes = new Vertex[size];
        adjMat = new int[size][size];
    }

    public void addVertex(Vertex vertex){
        vertexes[currentSize++] = vertex;
    }

    public void addEdge(String v1,String v2){
        int index1 = 0;
        for (int i = 0; i < vertexes.length; i++){
            if (vertexes[i].getValue().equals(v1)){
                index1 = i;
                break;
            }
        }

        int index2 = 0;
        for (int i = 0; i < vertexes.length; i++){
            if (vertexes[i].getValue().equals(v2)){
                index2 = i;
                break;
            }
        }

        adjMat[index1][index2] = 1;
        adjMat[index2][index1] = 1;
    }

    public int[][] getAdjMat() {
        return adjMat;
    }
}
