package com.snakeLadder.model;


public class Board {
    private int size;
    private int start;
    private int end;

    public Board(int size) {
        this.size = size;
        this.start = 1;
        this.end = start + size -1;
    }

    public int getSize() {
        return size;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
