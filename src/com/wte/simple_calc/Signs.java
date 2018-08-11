package com.wte.simple_calc;

public enum Signs {
    ADDITION("+"),
    SUBTRACTION("-"),
    DIVISION("/"),
    MULTIPLICATION("*"),
    RESULT("="),
    NUMERIC("N"),
    MEMORY_READ("MR"),
    MEMORY_CLEAR("MC"),
    MEMORY_PLUS("M+"),
    MEMORY_MINUS("M-"),
    DECIMAL_POINT("."),
    PERCENT("%"),
    CLEAR_ALL("C"),
    CLEAR_ENTRY("CE"),
    REMOVE("<="),
    CHANGE_SIGN("\u00B1"),
    SQUARE("SQ"),
    EMPTY("");


    private final String sign;

    Signs(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }
}
