package com.wte.simple_calc;

import javax.swing.*;

public
class MyButton extends JButton {
    private int value;
    private String indicator;

    public MyButton(String text) {
        super(text);
    }

    public MyButton setIndicator(String ind) {
        this.indicator = ind;
        return this;

    }

    public String getIndicator() {
        return indicator;
    }

    public MyButton setValue(int value) {
        this.value = value;
        return this;
    }

    public int getValue() {
        return value;
    }
}