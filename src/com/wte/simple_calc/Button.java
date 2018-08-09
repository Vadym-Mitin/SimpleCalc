package com.wte.simple_calc;

import javax.swing.*;

public
class Button extends JButton {
    private int val;
    private String ind;

    public Button(String text) {
        super(text);
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    public String getInd() {
        return ind;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

}