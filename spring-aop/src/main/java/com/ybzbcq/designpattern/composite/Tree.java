package com.ybzbcq.designpattern.composite;

import org.springframework.util.StringUtils;

import java.util.Enumeration;

public class Tree {
    TreeNode root = null;

    public Tree(String name) {
        this.root = new TreeNode(name);
    }

    public static void main(String[] args) {
        Tree tree = new Tree("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");

        nodeB.add(nodeC);
        tree.root.add(nodeB);
        nodeC.setParent(nodeB);
        System.out.println("build the tree finished!");

        TreeNode root = tree.root;

        TreeNode parent = root.getParent();
        String rootName = root.getName();
        Enumeration<TreeNode> children = root.getChildren();

        System.out.println(parent);
        System.out.println(rootName);
        System.out.println(children);

        System.out.println("---------------------------------");
        TreeNode treeNode = children.nextElement();
        System.out.println(treeNode.getParent());
        System.out.println(treeNode.getName());
        System.out.println(treeNode.getChildren());


    }
}
