package com.lyang.studying.data_structure.graph.prim_algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/10 3:23 下午
 * @desc 带权邻接矩阵
 */
public class Graph {

    private final Vertex[] vertices;
    private int currIndex;
    private final int DEFAULT = -1;
    public int[][] adjMat;//邻接矩阵 adjacency matrix
    private boolean[] isVisited;

    public Graph(int size) {
        vertices = new Vertex[size];
        adjMat = new int[size][size];
        isVisited = new boolean[size];
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
        int row = getVertexIndex(vertex);

        for(int i = 0;i<adjMat[row].length;i++){
            if (adjMat[row][i] != 0 && adjMat[row][i] != DEFAULT){
                degree++;
            }
        }

        return degree;
    }

    public int getInDegree(Vertex vertex) {
        int degree = 0;
        int column =getVertexIndex(vertex);

        for(int i = 0;i<adjMat[column].length;i++){
            if (adjMat[i][column] != 0 && adjMat[i][column] != DEFAULT){
                degree++;
            }
        }

        return degree;
    }

    public void addEdge(Vertex v1, Vertex v2, int weight) {
        int index1 = getVertexIndex(v1);

        int index2 = getVertexIndex(v2);

        adjMat[index1][index2] = weight;
    }

    /**
     * 获取某一个顶点的第一个邻接点
     * @param vertex 某一个顶点
     * @return 邻接点
     */
    public Vertex getFirstNeighbor(Vertex vertex){
        int index = getVertexIndex(vertex);

        for (int i = 0;i<adjMat[index].length;i++) {
            int ele = adjMat[index][i];
            if (ele != 0 && ele != DEFAULT){
                return vertices[i];
            }
        }
        return null;
    }

    /**
     * 根据前一个邻接点的坐标获取下一个邻接点
     * @param v1 表示要找的顶点
     * @param v2 表示改顶点相对于哪个邻接点去获取下一个邻接点
     * @return 邻接点
     */
    public Vertex getNextNeighbor(Vertex v1,Vertex v2){
        int currVertexIndex = getVertexIndex(v1);//当前顶点坐标
        int relativeVertexIndex = getVertexIndex(v2);//相对顶点坐标

        for (int i = relativeVertexIndex + 1; i < vertices.length; i++) {
            int ele = adjMat[currVertexIndex][i];
            if (ele != 0 && ele != DEFAULT){
                return vertices[i];
            }
        }

        return null;
    }

    private void depthFirstSearch(Vertex vertex){
        int currIndex = getVertexIndex(vertex);
        isVisited[currIndex] = true;

        Vertex firstNeighbor = this.getFirstNeighbor(vertex);
        while (firstNeighbor != null){
            int index = getVertexIndex(firstNeighbor);
            if (!isVisited[index]){
                //需要遍历的该顶点
                System.out.println("访问到了："+firstNeighbor.getValue()+"顶点");
                depthFirstSearch(firstNeighbor);
            }
            firstNeighbor = getNextNeighbor(vertex,firstNeighbor);
        }
    }

    public void depthFirstSearch(){
        isVisited = new boolean[vertices.length];
        for (int i = 0;i<vertices.length; i++){
            if (!isVisited[i]){
                System.out.println("访问到了："+vertices[i].getValue()+"顶点");
                depthFirstSearch(vertices[i]);
            }
        }
        isVisited = new boolean[vertices.length];
    }

    private int getVertexIndex(Vertex vertex){
        for (int i = 0; i < vertices.length; i++){
            if (vertices[i].getValue().equals(vertex.getValue())){
                return i;
            }
        }
        return -1;
    }

    public  void breadthFirstSearch(){
        isVisited = new boolean[vertices.length];
        for (int i = 0; i < vertices.length; i++){
            if (!isVisited[i]){
                System.out.println("访问到了:"+vertices[i].getValue()+"顶点");
                breadthFirstSearch(vertices[i]);
            }
        }
        isVisited = new boolean[vertices.length];
    }

    private void breadthFirstSearch(Vertex vertex){
        Vertex curVertex,neighborVertex;
        int index = this.getVertexIndex(vertex);
        isVisited[index] = true;
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(vertex);

        while (!queue.isEmpty()){
            curVertex = queue.remove();
            neighborVertex = getFirstNeighbor(curVertex);
            while (neighborVertex != null){
                int neighborIndex = getVertexIndex(neighborVertex);
                if (!isVisited[neighborIndex]){
                    System.out.println("访问到了:"+vertices[neighborIndex].getValue()+"顶点");
                    isVisited[neighborIndex] = true;
                    queue.add(neighborVertex);
                }
                neighborVertex = getNextNeighbor(curVertex,neighborVertex);
            }

        }

    }

}
