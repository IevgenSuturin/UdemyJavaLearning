package com.yevhensuturin;

public class LinkedItemList {
    private ListItem head = null;

    public void addItem(ListItem node){
        if (head == null){
            head = node;
            return;
        }

        ListItem tmp = head;
        ListItem prev = null;
        while (tmp != null && tmp.compareTo(node.getItem())<0){
            if(tmp.compareTo(node.getItem())==0) return;
            prev = tmp;
            tmp = tmp.getNextNode();
        }

        if(tmp != null){
            tmp.setPrevNode(node);
            node.setNextNode(tmp);
            if(prev != null) {
                prev.setNextNode(node);
                node.setPrevNode(prev);
            } else {
                head = node;
            }
        } else {
            //insert at the end of the list
            prev.setNextNode(node);
            node.setPrevNode(prev);
        }
    }

    public void printList(){
        ListItem tmp = head;

        while (tmp != null){
            System.out.println(tmp.getItem().toString());
            tmp = tmp.getNextNode();
        }
    }
}
