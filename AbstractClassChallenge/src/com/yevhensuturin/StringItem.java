package com.yevhensuturin;

public class StringItem extends ListItem{
    public StringItem(String item) {
        this.setItem(item);
    }

    @Override
    public int compareTo(Object item) {
        return  ((String)this.getItem()).compareTo((String)item);
    }
}
