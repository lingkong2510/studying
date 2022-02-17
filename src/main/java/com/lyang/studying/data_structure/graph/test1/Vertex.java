package com.lyang.studying.data_structure.graph.test1;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/10 10:40 上午
 * @desc 顶点
 */
public class Vertex {

    private String value;

    public Vertex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
