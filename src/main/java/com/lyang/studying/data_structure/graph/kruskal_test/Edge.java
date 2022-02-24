package com.lyang.studying.data_structure.graph.kruskal_test;

import com.lyang.studying.data_structure.graph.kruskal_test.Vertex;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/21 11:23 上午
 * @desc
 */
public class Edge {

    private Vertex begin;

    private Vertex end;

    private int weight;

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
