package com.snakeLadder.model;

public class Snake {
    private int head;
    private int tail;

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }
}
