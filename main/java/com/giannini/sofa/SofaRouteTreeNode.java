package com.giannini.sofa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.*;

/**
 * 将无序节点整理成一颗树
 * （根据sofa的rpcid来确定树的层级和归属）
 * <p>
 * Created by Fenglin on 2017/5/28.
 */
public class SofaRouteTreeNode implements Comparable<SofaRouteTreeNode> {

    @JSONField(ordinal = 0)
    private String rpcId;

    @JSONField(serialize = false)
    private String currentId;

    @JSONField(ordinal = 1)
    private List<SofaRouteTreeNode> nodes;

    public String getRpcId() {
        return rpcId;
    }

    public void setRpcId(String rpcId) {
        this.rpcId = rpcId;
        if (rpcId != null) {
            String[] tmp = rpcId.split("\\.");
            this.currentId = tmp[tmp.length - 1];
        }
    }

    public void setCurrentId(String currentId) {
        this.currentId = currentId;
    }

    public List<SofaRouteTreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<SofaRouteTreeNode> nodes) {
        this.nodes = nodes;
    }

    @JSONField(serialize = false)
    public int getDepth() {
        return rpcId.split("\\.").length;
    }

    public String getCurrentId() {
        return currentId;
    }

    /**
     * 排序算法1，深度优先
     *
     * @param next
     * @return
     */
//    public int compareTo(SofaRouteTreeNode next) {
//
//        int thisRpcLevel = this.rpcId.split("\\.").length; //正则匹配点号
//        int nextRpcLevel = next.getRpcId().split("\\.").length;
//        int minLevel = Math.min(thisRpcLevel, nextRpcLevel);
//
//        String[] thisRcpIds = this.rpcId.split("\\.");
//        String[] nextRcpIds = next.getRpcId().split("\\.");
//        for (int i = 0; i < minLevel; i++) {
//            Integer thisId = Integer.parseInt(thisRcpIds[i]);
//            Integer nextId = Integer.parseInt(nextRcpIds[i]);
//            if (i == (minLevel - 1)) {
//                if (thisId != nextId || thisRpcLevel == nextRpcLevel) {
//                    return thisId - nextId;
//                } else if (i == (thisRpcLevel - 1)) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            } else if (thisId == nextId) {
//                continue;
//            } else {
//                return thisId - nextId;
//            }
//        }
//        return 0;
//    }

    /**
     * 排序算法2， 广度优先
     *
     * @param next
     * @return
     */
    public int compareTo(SofaRouteTreeNode next) {

        int thisRpcLevel = this.rpcId.split("\\.").length;//正则匹配点号
        int nextRpcLevel = next.getRpcId().split("\\.").length;

        if (thisRpcLevel != nextRpcLevel) {
            return thisRpcLevel - nextRpcLevel;
        } else {
            // 相同的情况，一级级比较下去！
            for (int i = 1; i < thisRpcLevel; i++) {
                Integer thisnum = Integer.valueOf(this.rpcId.split("\\.")[i]);
                Integer nextnum = Integer.valueOf(next.getRpcId().split("\\.")[i]);
                if (thisnum != nextnum) {
                    return thisnum - nextnum;
                } else {
                    continue;
                }
            }
            // 相等
            return 0;
        }
    }

    public static List<SofaRouteTreeNode> make() {

        SofaRouteTreeNode node1 = new SofaRouteTreeNode();
        node1.setRpcId("0");

        SofaRouteTreeNode node2 = new SofaRouteTreeNode();
        node2.setRpcId("0.1");
        SofaRouteTreeNode node3 = new SofaRouteTreeNode();
        node3.setRpcId("0.2");
        SofaRouteTreeNode node4 = new SofaRouteTreeNode();
        node4.setRpcId("0.3");

        SofaRouteTreeNode node5 = new SofaRouteTreeNode();
        node5.setRpcId("0.1.1");
        SofaRouteTreeNode node20 = new SofaRouteTreeNode();
        node20.setRpcId("0.1.2");
        SofaRouteTreeNode node6 = new SofaRouteTreeNode();
        node6.setRpcId("0.2.1");
        SofaRouteTreeNode node7 = new SofaRouteTreeNode();
        node7.setRpcId("0.2.2");
        SofaRouteTreeNode node8 = new SofaRouteTreeNode();
        node8.setRpcId("0.3.1");
        SofaRouteTreeNode node9 = new SofaRouteTreeNode();
        node9.setRpcId("0.3.2");
        SofaRouteTreeNode node10 = new SofaRouteTreeNode();
        node10.setRpcId("0.3.3");

        SofaRouteTreeNode node11 = new SofaRouteTreeNode();
        node11.setRpcId("0.1.1.1");
        SofaRouteTreeNode node12 = new SofaRouteTreeNode();
        node12.setRpcId("0.2.1.1");
        SofaRouteTreeNode node13 = new SofaRouteTreeNode();
        node13.setRpcId("0.2.1.2");
        SofaRouteTreeNode node14 = new SofaRouteTreeNode();
        node14.setRpcId("0.3.2.1");
        SofaRouteTreeNode node15 = new SofaRouteTreeNode();
        node15.setRpcId("0.3.2.2");
        SofaRouteTreeNode node16 = new SofaRouteTreeNode();
        node16.setRpcId("0.3.2.3");
        SofaRouteTreeNode node17 = new SofaRouteTreeNode();
        node17.setRpcId("0.3.3.1");

        SofaRouteTreeNode node18 = new SofaRouteTreeNode();
        node18.setRpcId("0.3.2.2.1");
        SofaRouteTreeNode node19 = new SofaRouteTreeNode();
        node19.setRpcId("0.2.1.2.1");

        // 孤点
        SofaRouteTreeNode node21 = new SofaRouteTreeNode();
        node21.setRpcId("0.4.1.2.1");
        SofaRouteTreeNode node22 = new SofaRouteTreeNode();
        node22.setRpcId("0.5.1");


        List<SofaRouteTreeNode> nodes = new ArrayList<SofaRouteTreeNode>();
        nodes.add(node7);
        nodes.add(node8);
        nodes.add(node9);
        nodes.add(node14);
        nodes.add(node15);
        nodes.add(node3);
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node4);
        nodes.add(node5);
        nodes.add(node10);
        nodes.add(node11);
        nodes.add(node12);
        nodes.add(node13);
        nodes.add(node6);
        nodes.add(node16);
        nodes.add(node17);
        nodes.add(node18);
        nodes.add(node19);
        nodes.add(node20);
        nodes.add(node21);
        nodes.add(node22);

        return nodes;
    }

    /**
     * 构建一颗有序树
     *
     * @param nodes
     * @return
     */
    public static SofaRouteTreeNode buildTree(List<SofaRouteTreeNode> nodes) {

        // 排序
        Collections.sort(nodes);
        int depth = nodes.get(nodes.size() - 1).getRpcId().split("\\.").length;// 深度

        SofaRouteTreeNode root = nodes.get(0);
        root.setNodes(new LinkedList<SofaRouteTreeNode>());
        for (SofaRouteTreeNode node : nodes) {
            // 0.4.1.2.1
            System.out.println("deal with:" + node.getRpcId());
            if (node.getDepth() == 1) {
                continue;
            }

            // rpc id转换成integer
            String[] rpcs = node.getRpcId().split("\\.");
            List<Integer> rpcNode = new LinkedList<Integer>();
            for (String rpc : rpcs) {
                rpcNode.add(Integer.valueOf(rpc));
            }

            List<SofaRouteTreeNode> next = root.getNodes();
            System.out.println(JSON.toJSONString(next));
            for (int i = 1; i < rpcs.length; i++) {
                // size到rpcNode.get(i)都没有节点，需要预处理下，否则会抛outofindexbound
                for (int j = next.size(); j < rpcNode.get(i); j++) {
                    System.out.println("add null at pos " + j);
                    next.add(j, null);
                }

                if (next.get(rpcNode.get(i) - 1) == null) {
                    // 没有该节点
                    if (i == (rpcs.length - 1)) {
                        //填充该节点数据
                        SofaRouteTreeNode thisNode = new SofaRouteTreeNode();
                        thisNode.setRpcId(node.getRpcId());
                        next.set(rpcNode.get(i) - 1, thisNode);
                    } else {
                        //没有的中间节点，需要补一个假的节点进去
                        SofaRouteTreeNode thisNode = new SofaRouteTreeNode();
                        thisNode.setRpcId("-1");
                        thisNode.setNodes(new LinkedList<SofaRouteTreeNode>());
                        next.set(rpcNode.get(i) - 1, thisNode);
                        next = next.get(rpcNode.get(i) - 1).getNodes();
                    }
                } else {
                    // 顺藤摸瓜
                    if (next.get(rpcNode.get(i) - 1).getNodes() == null) {
                        next.get(rpcNode.get(i) - 1).setNodes(new LinkedList<SofaRouteTreeNode>());
                    }
                    next = next.get(rpcNode.get(i) - 1).getNodes();
                }
            }
        }

        return root;
    }

    /**
     * clean null 节点
     *
     * @param root
     * @return
     */
    public static SofaRouteTreeNode clean(SofaRouteTreeNode root) {

        List<SofaRouteTreeNode> nodes = new LinkedList<SofaRouteTreeNode>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            List<SofaRouteTreeNode> node2 = new LinkedList<SofaRouteTreeNode>();
            for (SofaRouteTreeNode tmp : nodes) {
                node2.add(tmp);
            }
            nodes = new LinkedList<SofaRouteTreeNode>();
            for (SofaRouteTreeNode node : node2) {
                if (node.getNodes() == null) {
                    continue;
                } else {
                    Iterator<SofaRouteTreeNode> it = node.getNodes().iterator();
                    while (it.hasNext()) {
                        SofaRouteTreeNode next = it.next();
                        if (next == null) {
                            it.remove();
                        } else {
                            nodes.add(next);
                        }
                    }
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        List<SofaRouteTreeNode> nodelist = make();
        //System.out.println(JSON.toJSONString(nodelist));
        //Collections.sort(nodelist);
        //System.out.println(JSON.toJSONString(nodelist));
        SofaRouteTreeNode root = buildTree(nodelist);
        System.out.println();
        System.out.println(JSON.toJSONString(root));
        root = clean(root);
        System.out.println(JSON.toJSONString(root));
    }

}
