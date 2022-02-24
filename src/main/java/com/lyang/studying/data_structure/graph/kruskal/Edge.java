package com.lyang.studying.data_structure.graph.kruskal;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/18 2:55 下午
 * @desc 边
 */
public class Edge {

    private Vertex begin;
    private Vertex end;
    private Integer weight;

    public Edge(Vertex begin, Vertex end, int weight) {
        this.begin = begin;
        this.end = end;
        this.weight = weight;
    }

    public Vertex getBegin() {
        return begin;
    }

    public void setBegin(Vertex begin) {
        this.begin = begin;
    }

    public Vertex getEnd() {
        return end;
    }

    public void setEnd(Vertex end) {
        this.end = end;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
