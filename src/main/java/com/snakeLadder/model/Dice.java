package com.snakeLadder.model;

import org.apache.commons.lang3.RandomUtils;
public class Dice {
    private int minValue;
    private int maxValue;
    private int currentValue;

    public int roll() { return RandomUtils.nextInt(minValue , maxValue+1);}

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public Dice(int minValue, int maxValue, int currentValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.currentValue = currentValue;
    }
}
