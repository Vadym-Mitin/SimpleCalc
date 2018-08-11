package com.wte.simple_calc;

import javax.swing.*;

public
class MyButton extends JButton {
    private int value;
    private String indicator;

    public MyButton(String text) {
        super(text);
    }

    public void setIndicator(String ind) {
        this.indicator = ind;

    }

    public String getIndicator() {
        return indicator;
    }

    public void setValue(int value) {
        this.value = value;

    }

    public int getValue() {
        return value;
    }
}