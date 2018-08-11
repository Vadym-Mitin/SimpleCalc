package com.wte.simple_calc;

public enum Signs {
    PLUS("+"),
    MINUS("-"),
    DIVISION("/"),
    MULTIPLICATION("*"),
    EQUATION("="),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGTH("8"),
    NINE("9"),
    ZERO("0"),
    Memory_Write("MW"),
    Memory_Read("MR"),
    Memory_Plus("M+"),
    Memory_Minus("M-"),
    Memory_Erase("ME");

    private final String sign;

    Signs(String sign) {
        this.sign = sign;
    }
    public String getSign(){
        return this.sign;
    }
}
