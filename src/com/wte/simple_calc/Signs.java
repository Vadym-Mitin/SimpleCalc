package com.wte.simple_calc;

public enum Signs {
    ADDITION("+"),
    SUBTRACTION("-"),
    DIVISION("\u00F7"),
    MULTIPLICATION("\u2715"),
    RESULT("="),
    NUMERIC("N"),
    MEMORY_READ("MR"),
    MEMORY_CLEAR("MC"),
    MEMORY_PLUS("M+"),
    MEMORY_MINUS("M-"),
    DECIMAL_POINT("."),
    PERCENT("%"),
    MOD_ONE("1/x"),
    MOD_TWO("x\u00B2"),
    CLEAR_ALL("C"),
    CLEAR_ENTRY("CE"),
    REMOVE("<="),
    CHANGE_SIGN("\u00B1"),
    SQRT("\u221A"),
    EMPTY("");


    private final String sign;

    Signs(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }
}
