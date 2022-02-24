package com.lyang.studying.data_structure.graph.topological_test;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/23 1:30 下午
 * @desc 边节点
 */
public class EdgeNode {
    private int adjVex;
    private EdgeNode nextEdgeNode;

    public EdgeNode(int adjVex, EdgeNode nextEdgeNode) {
        this.adjVex = adjVex;
        this.nextEdgeNode = nextEdgeNode;
    }

    public int getAdjVex() {
        return adjVex;
    }

    public void setAdjVex(int adjVex) {
        this.adjVex = adjVex;
    }

    public EdgeNode getNextEdgeNode() {
        return nextEdgeNode;
    }

    public void setNextEdgeNode(EdgeNode nextEdgeNode) {
        this.nextEdgeNode = nextEdgeNode;
    }
}
