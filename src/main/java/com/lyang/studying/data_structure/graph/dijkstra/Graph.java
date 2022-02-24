package com.lyang.studying.data_structure.graph.dijkstra;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/21 7:20 下午
 * @desc
 */
public class Graph {

    public int[][] adjMat;
    private int vertexSize = 9;
    private int Max = 1000;

    public Graph() {
        adjMat = new int[9][9];
        adjMat[0] = new int[]{0, 1, 5, Max, Max, Max, Max, Max, Max};
        adjMat[1] = new int[]{1,0,3,7,5, Max, Max, Max, Max};
        adjMat[2] = new int[]{5,3,0,Max,1, 7, Max, Max, Max};
        adjMat[3] = new int[]{Max,7,Max,0,2,Max, 3, Max, Max};
        adjMat[4] = new int[]{Max,5,1,2,0,3,6,9, Max};
        adjMat[5] = new int[]{Max,Max,7,Max,3,0,Max,5, Max};
        adjMat[6] = new int[]{Max,Max,Max,3,6,Max,0,2,7};
        adjMat[7] = new int[]{Max,Max,Max,Max,9,5,0,2,4};
        adjMat[8] = new int[]{Max,Max,Max,Max,Max,Max,7,4,0};

    }

    public int[][] getAdjMat() {
        return adjMat;
    }

    public void setAdjMat(int[][] adjMat) {
        this.adjMat = adjMat;
    }

    public int getVertexSize() {
        return vertexSize;
    }

    public void setVertexSize(int vertexSize) {
        this.vertexSize = vertexSize;
    }

    public int getMax() {
        return Max;
    }

    public void setMax(int max) {
        Max = max;
    }
}
