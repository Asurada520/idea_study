package com.ybzbcq.designpattern.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 组合模式 工程项目测试 定义树型 数据结构
 */
public class TreeNode {
    /* 节点名称 */
    private String name;
    /* 父节点 */
    private TreeNode parent;
    /* 子节点集合 */
    private Vector<TreeNode> children = new Vector<TreeNode>();

    public TreeNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public void add(TreeNode treeNode){
        children.add(treeNode);
    }

    public void remove(TreeNode treeNode){
        children.remove(treeNode);
    }

    public Enumeration<TreeNode> getChildren(){
        Enumeration<TreeNode> elements = children.elements();
        return elements;
    }
}
