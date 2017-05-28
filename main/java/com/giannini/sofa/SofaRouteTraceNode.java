package com.giannini.sofa;

import java.util.LinkedList;
import java.util.List;

/**
 * 跟踪链路节点
 * Created by Fenglin on 2017/5/28.
 */
public class SofaRouteTraceNode {

    private int time;

    private List<SofaRouteTraceNode> traces;


    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<SofaRouteTraceNode> getTraces() {
        return traces;
    }

    public void setTraces(List<SofaRouteTraceNode> traces) {
        this.traces = traces;
    }

    public static SofaRouteTraceNode makeData() {
        SofaRouteTraceNode node2 = new SofaRouteTraceNode();
        node2.setTime(280);
        SofaRouteTraceNode node3 = new SofaRouteTraceNode();
        node3.setTime(150);
        List<SofaRouteTraceNode> list1 = new LinkedList<SofaRouteTraceNode>();
        list1.add(node2);
        list1.add(node3);
        SofaRouteTraceNode node1 = new SofaRouteTraceNode();
        node1.setTime(100);
        node1.setTraces(list1);

        SofaRouteTraceNode node5 = new SofaRouteTraceNode();
        node5.setTime(20);
        List<SofaRouteTraceNode> list2 = new LinkedList<SofaRouteTraceNode>();
        list2.add(node5);
        SofaRouteTraceNode node4 = new SofaRouteTraceNode();
        node4.setTime(300);
        node4.setTraces(list2);

        List<SofaRouteTraceNode> rootlist = new LinkedList<SofaRouteTraceNode>();
        rootlist.add(node1);
        rootlist.add(node5);
        SofaRouteTraceNode root = new SofaRouteTraceNode();
        root.setTime(200);
        root.setTraces(rootlist);

        return root;
    }

    public static int calculate(SofaRouteTraceNode node) {

        if (node.getTraces() == null || node.getTraces().isEmpty()) {
            return node.getTime();
        } else {
            int maxchildtime = 0;
            for (SofaRouteTraceNode child : node.getTraces()) {
                int childtime = calculate(child);
                if (childtime > maxchildtime) {
                    maxchildtime = childtime;
                }
            }
            return  maxchildtime + node.getTime();
        }

    }

    public static void main(String[] args) {
        SofaRouteTraceNode root = makeData();

        System.out.println(calculate(root));
    }
}



