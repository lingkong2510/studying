package com.lyang.studying.data_structure.graph.dfs_test;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/11 1:44 下午
 * @desc
 */
public class Graph {
    private final Vertex[] vertices;
    private int currIndex ;
    public int[][] adjMat;
    private final int vertexSize;
    private boolean[] isVisited;
    private final int MAX_NUMBER = -1;

    public Graph(int vertexSize) {
        this.vertexSize = vertexSize;
        vertices = new Vertex[vertexSize];
        isVisited = new boolean[vertexSize];
        adjMat = new int[vertexSize][vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            for (int j = 0;j< vertexSize;j++){
                if (i != j){
                    adjMat[i][j] = MAX_NUMBER;
                }
            }
        }
    }

    public void addVertex(Vertex vertex){
        vertices[currIndex++] = vertex;
    }

    public void addEdge(Vertex v1,Vertex v2,int weight){
        int row = getVertexIndex(v1);
        int col = getVertexIndex(v2);
        adjMat[row][col] = weight;
        adjMat[col][row] = weight;
    }

    private int getVertexIndex(Vertex vertex){
        for (int i = 0; i < vertices.length;i++){
            if (vertices[i].getValue().equals(vertex.getValue())){
                return i;
            }
        }
        return -1;
    }

    public Vertex getFirstNeighbor(Vertex vertex){
        int index = getVertexIndex(vertex);
        for (int i = 0;i<vertices.length; i++){
            int weight = adjMat[index][i];
            if (weight != 0&& weight != MAX_NUMBER){
                return vertices[i];
            }
        }
        return null;

    }

    public  Vertex getNextNeighbor(Vertex v1,Vertex v2){
        int index1 = getVertexIndex(v1);
        int index2 = getVertexIndex(v2);
        for (int i = index2 +1; i < adjMat[index1].length; i++) {
            int weight = adjMat[index1][i];
            if (weight != 0 && weight != MAX_NUMBER){
                return vertices[i];
            }
        }
        return null;
    }

    private void depthFirstSearch(Vertex vertex){
        int index = getVertexIndex(vertex);
        isVisited[index] = true;
        Vertex firstNeighbor = getFirstNeighbor(vertex);
        while (firstNeighbor != null){
            int neighborIndex = getVertexIndex(firstNeighbor);
            if (!isVisited[neighborIndex]){
                System.out.println("访问到了"+vertices[neighborIndex].getValue()+"顶点");
                depthFirstSearch(firstNeighbor);
            }

            firstNeighbor = getNextNeighbor(vertex,firstNeighbor);
        }
    }

    public void depthFirstSearch(){
        for (int i = 0; i < vertices.length ; i++) {
            if (!isVisited[i]){
                System.out.println("访问到了" + vertices[i].getValue() + "顶点");
                depthFirstSearch(vertices[i]);
            }
        }
    }



}
