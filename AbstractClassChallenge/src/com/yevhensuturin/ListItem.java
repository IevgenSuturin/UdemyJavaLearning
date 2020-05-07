package com.yevhensuturin;

public abstract class ListItem {
    private ListItem prevNode = null;
    private ListItem nextNode = null;
    private Object item;

    public ListItem getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(ListItem prevNode) {
        this.prevNode = prevNode;
    }

    public ListItem getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListItem nextNode) {
        this.nextNode = nextNode;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public abstract int compareTo(Object item);
}
