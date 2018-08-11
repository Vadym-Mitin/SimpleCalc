package com.wte.simple_calc;

import javax.swing.*;

public
class MyButton extends JButton {
    private int value;
    private String indicator;
    private Signs sign;

    public MyButton(String text) {
        super(text);
    }
    public MyButton(Signs sign) {
        this(sign.getSign());
        this.sign = sign;

    }
    public MyButton(Signs sign, int value) {
        this(Integer.toString(value));
        this.sign = sign;
        this.value = value;
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

    public Signs getSign() {
        return sign;
    }
}