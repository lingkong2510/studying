package com.lyang.studying.data_structure.graph.topological_test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/23 1:28 下午
 * @desc 拓扑排序
 */
public class Topological {

    private VertexNode[] vertexList;
    private int vertexSize;

    public Topological(int vertexSize) {
        this.vertexSize = vertexSize;
        vertexList = new VertexNode[vertexSize];
        VertexNode node0 = new VertexNode("V0", 0);
        VertexNode node1 = new VertexNode("V1", 0);
        VertexNode node2 = new VertexNode("V2", 2);
        VertexNode node3 = new VertexNode("V3", 0);
        VertexNode node4 = new VertexNode("V4", 2);
        VertexNode node5 = new VertexNode("V5", 3);
        VertexNode node6 = new VertexNode("V6", 1);
        VertexNode node7 = new VertexNode("V7", 2);
        VertexNode node8 = new VertexNode("V8", 2);
        VertexNode node9 = new VertexNode("V9", 2);
        VertexNode node10 = new VertexNode("V10", 1);
        VertexNode node11 = new VertexNode("V11", 2);
        VertexNode node12 = new VertexNode("V12", 1);
        VertexNode node13 = new VertexNode("V13", 2);
        vertexList[0] = node0;
        vertexList[1] = node1;
        vertexList[2] = node2;
        vertexList[3] = node3;
        vertexList[4] = node4;
        vertexList[5] = node5;
        vertexList[6] = node6;
        vertexList[7] = node7;
        vertexList[8] = node8;
        vertexList[9] = node9;
        vertexList[10] = node10;
        vertexList[11] = node11;
        vertexList[12] = node12;
        vertexList[13] = node13;

        node0.setFirstEdgeNode(new EdgeNode(11, new EdgeNode(5, new EdgeNode(4, null))));
        node1.setFirstEdgeNode(new EdgeNode(8, new EdgeNode(4, new EdgeNode(2, null))));
        node2.setFirstEdgeNode(new EdgeNode(9, new EdgeNode(6, new EdgeNode(5, null))));
        node3.setFirstEdgeNode(new EdgeNode(13, new EdgeNode(2, null)));
        node4.setFirstEdgeNode(new EdgeNode(7, null));
        node5.setFirstEdgeNode(new EdgeNode(12, new EdgeNode(8, null)));
        node6.setFirstEdgeNode(new EdgeNode(5, null));
        node8.setFirstEdgeNode(new EdgeNode(7, null));
        node9.setFirstEdgeNode(new EdgeNode(11, new EdgeNode(10, null)));
        node10.setFirstEdgeNode(new EdgeNode(13, null));
        node12.setFirstEdgeNode(new EdgeNode(9, null));
    }

    public void topologicalSort() {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertexSize; i++) {
            if (vertexList[i].getInDegree() == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            Integer index = queue.remove();
            vertexList[index].setInDegree(-1);
            VertexNode vertexNode = vertexList[index];
            System.out.println("顶点："+ vertexNode.getValue());
            count++;
            EdgeNode edgeNode = vertexNode.getFirstEdgeNode();
            while (edgeNode != null){
                int adjVex = edgeNode.getAdjVex();
                if (vertexList[adjVex].getInDegree() - 1 == 0){
                    queue.add(adjVex);
                }else{
                    vertexList[adjVex].setInDegree(vertexList[adjVex].getInDegree() - 1);
                }
                edgeNode = edgeNode.getNextEdgeNode();
            }
        }

        if (count < vertexSize){
            throw new RuntimeException("拓扑图有回环:"+count);
        }


    }
}
