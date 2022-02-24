package com.lyang.studying.data_structure.graph.topological_test;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/23 1:29 下午
 * @desc 顶点节点
 */
public class VertexNode {

    private int inDegree;
    private String value;
    private EdgeNode firstEdgeNode;

    public VertexNode(String value, int inDegree) {
        this.value = value;
        this.inDegree = inDegree;
    }

    public EdgeNode getFirstEdgeNode() {
        return firstEdgeNode;
    }

    public void setFirstEdgeNode(EdgeNode firstEdgeNode) {
        this.firstEdgeNode = firstEdgeNode;
    }

    public int getInDegree() {
        return inDegree;
    }

    public void setInDegree(int inDegree) {
        this.inDegree = inDegree;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
