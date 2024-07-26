package com.kuka.krv.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "time_nodes")
public class TimeNode implements Comparable<TimeNode>{
    @Id
    @Column(name = "node_id")
    private long nodeId;

    @Column(name = "sub_id")
    private long subId;

    @Column(name = "node")
    private String nodeName;

    @Column(name = "state")
    private int state;

    @Column(name = "node_order")
    private int nodeOrder;


    public TimeNode() {

    }

    public long getNodeId() {
        return nodeId;
    }

    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }

    public long getSubId() {
        return subId;
    }

    public void setSubId(long subId) {
        this.subId = subId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getNodeOrder() {
        return nodeOrder;
    }

    public void setNodeOrder(int order) {
        this.nodeOrder = order;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column(name = "finish_date")
    private java.sql.Date finishDate;

    @Column(name = "comments")
    private String comments;


    public boolean equals(TimeNode timeNode){
        return (this.nodeOrder==timeNode.nodeOrder&& this.subId==timeNode.subId);
    }

    @Override
    public int compareTo(TimeNode t){
        return Integer.compare(this.nodeOrder, t.nodeOrder);
    }

}
