package com.giannini.sofa;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Fenglin on 2017/5/28.
 */
public class SofaRouteTreeTempNode {

    private SofaRouteTreeNode node;

    /**
     * 节点当前深度
     */
    private int myDepth;

    /**
     * 父节点是几号
     */
    private int parent;

    /**
     * 自己是几号
     */
    private int myself;


    public SofaRouteTreeNode getNode() {
        return node;
    }

    public void setNode(SofaRouteTreeNode node) {
        this.node = node;
    }

    public int getMyDepth() {
        return myDepth;
    }

    public void setMyDepth(int myDepth) {
        this.myDepth = myDepth;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getMyself() {
        return myself;
    }

    public void setMyself(int myself) {
        this.myself = myself;
    }

    /**
     * 转换
     *
     * @param nodes
     * @return
     */
    public static List<SofaRouteTreeTempNode> convert(List<SofaRouteTreeNode> nodes) {
        List<SofaRouteTreeTempNode> tmpNodeList = new LinkedList<SofaRouteTreeTempNode>();

        for (SofaRouteTreeNode node : nodes) {
            SofaRouteTreeTempNode tmpNode = new SofaRouteTreeTempNode();
            tmpNode.setNode(node);
            String[] rpc = node.getRpcId().split("\\.");
            tmpNode.setMyDepth(rpc.length);
            tmpNode.setMyself(Integer.parseInt(rpc[rpc.length - 1]));
            tmpNode.setParent(rpc.length >= 2 ? Integer.parseInt(rpc[rpc.length - 2]) : -1);
            tmpNodeList.add(tmpNode);
        }
        return tmpNodeList;
    }
}
