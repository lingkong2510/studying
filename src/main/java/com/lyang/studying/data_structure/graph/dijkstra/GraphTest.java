package com.lyang.studying.data_structure.graph.dijkstra;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/21 3:49 下午
 * @desc 迪杰斯特拉 Dijkstra 最短路径
 */
public class GraphTest {
    private static int vertexSize = 9;
    private static int Max = 1000;


    public static void shortestPathDijkstar(Graph graph) {
        boolean[] passPath = new boolean[vertexSize];
        int[] shortPath = new int[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            shortPath[i] = graph.getAdjMat()[0][i];
        }
        int k = 0;
        passPath[k] = true;
        shortPath[k] = 0;

        for (int i = 1; i < vertexSize; i++) {
            int min = Max;
            for (int j=0;j < vertexSize; j++){
                if (!passPath[j] && shortPath[j] < min){
                    k = j;
                    min = shortPath[k];
                }
            }
            passPath[k] = true;

            for (int j = 0; j < vertexSize; j++) {
                if (!passPath[j] && (min + graph.getAdjMat()[k][j]) <shortPath[j] ){
                    shortPath[j] = min + graph.getAdjMat()[k][j];
                }
            }
        }

        for (int i = 0; i < vertexSize; i++) {
            System.out.println("V0——>V"+i+"的最短距离是"+shortPath[i]);
        }




    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        shortestPathDijkstar(graph );
    }
}
