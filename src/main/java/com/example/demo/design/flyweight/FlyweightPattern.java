package com.example.demo.design.flyweight;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 享元模式
 * 运用共享技术来有效地支持大量细粒度对象的复用
 */
public class FlyweightPattern {

    public static void main(String[] args) {


        // Tree("xx","uu") 只会创建一次
        TreeNode treeNode = new TreeNode("100", "99", TreeFactory.getTree("xx", "uu"));
        TreeNode treeNode1 = new TreeNode("88", "99", TreeFactory.getTree("xx", "uu"));


    }

}

class Tree{
    final String name;
    final String data;

    public Tree(String name, String data) {
        System.out.println("name_"+name +"--- create ");
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}

class TreeNode{

    String x;
    String y;
    Tree tree;

    public TreeNode(String x, String y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }

}

class TreeFactory{
    private static Map<String,Tree> map = new ConcurrentHashMap<>();

    public static Tree getTree(String name,String data){
        if (map.containsKey(name)){
            return map.get(name);
        }

        Tree tree = new Tree(name, data);
        map.put(name,tree);
        return tree;
    }

}
