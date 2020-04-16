package com.sh.pojo;

import java.util.ArrayList;
import java.util.List;

public class Children {
    private List<Node> list = new ArrayList<Node>();
    // ...get set 方法，构造方法
    public List<Node> getList() {
        return list;
    }

    public void setList(List<Node> list) {
        this.list = list;
    }
    public int getSize() {
        return list.size();
    }
    public void addChild(Node node) {
        list.add(node);
    }
}

