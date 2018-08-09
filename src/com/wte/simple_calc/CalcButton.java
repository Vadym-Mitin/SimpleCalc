package com.wte.simple_calc;

import javax.swing.*;

public
class CalcButton extends JButton {
    private int val;
    private char ind;

    public CalcButton(String text) {
        super(text);
    }

    public void setInd(char ind) {
        this.ind = ind;
    }

    public char getInd() {
        return ind;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

}