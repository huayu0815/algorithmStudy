package com.huayu.study.algorithmStudy;

/**
 * Created by zhaohuayu on 17/1/1.
 * 给定树的前序preStr,中序inStr,输出后序postStr
 */
public class ReCreateTree {

    public static void main(String[] args) {
        //String preStr = "DBACEGF" ;
        //String inStr = "ABCDEFG" ;
        String preStr = "BCAD" ;
        String inStr = "CBAD" ;
        ReCreateTree reCreateTree = new ReCreateTree() ;
        Tree tree = reCreateTree.createTree(preStr, inStr) ;
        System.out.println(reCreateTree.postPointTree(tree));
    }



    public Tree createTree(String preStr, String inStr) {
        Tree tree = new Tree() ;
        String inNodeStr = String.valueOf(preStr.charAt(0));
        tree.setNode(inNodeStr);

        int cutPoint = inStr.indexOf(inNodeStr) ;
        String leftInTreeStr ;
        if (cutPoint > 0) {
            leftInTreeStr = inStr.substring(0, cutPoint) ;
        } else {
            leftInTreeStr = "" ;
        }
        String rightInTreeStr ;
        if (cutPoint + 1 < inStr.length()) {
            rightInTreeStr = inStr.substring(cutPoint + 1) ;
        } else {
            rightInTreeStr = "" ;
        }
        if (leftInTreeStr.length() > 0) {
            String leftPreInTreeStr = preStr.substring(1, 1+ leftInTreeStr.length()) ;
            tree.setLeftTree(createTree(leftPreInTreeStr, leftInTreeStr));
        }
        if (rightInTreeStr.length() > 0) {
            String rightPreInTreeStr = preStr.substring(preStr.length() - rightInTreeStr.length()) ;
            tree.setRightTree(createTree(rightPreInTreeStr, rightInTreeStr));
        }
        return tree ;
    }

    public String postPointTree(Tree tree) {
        StringBuffer sb = new StringBuffer() ;
        if (tree.getLeftTree() != null) {
            sb.append(postPointTree(tree.getLeftTree()));
        }
        if (tree.getRightTree() != null) {
            sb.append(postPointTree(tree.getRightTree())) ;
        }
        sb.append(tree.getNode()) ;
        return sb.toString() ;
    }


    //定义树的数据结构
    class Tree {
        String node;
        Tree leftTree;
        Tree rightTree;

        public String getNode() {
            return node;
        }

        public void setNode(String node) {
            this.node = node;
        }

        public Tree getLeftTree() {
            return leftTree;
        }

        public void setLeftTree(Tree leftTree) {
            this.leftTree = leftTree;
        }

        public Tree getRightTree() {
            return rightTree;
        }

        public void setRightTree(Tree rightTree) {
            this.rightTree = rightTree;
        }

    }
}
