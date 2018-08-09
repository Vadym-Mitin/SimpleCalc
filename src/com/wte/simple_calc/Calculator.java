package com.wte.simple_calc;

import javax.swing.*;

public class Calculator {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static String equationSymbol;
    private static char flag;
    private static Object firstVariable;

    public static void setTextField(JTextField textField) {
        Calculator.textField = textField;
    }

    private static JTextField textField;

    public static void calculate(String plus ) {
        equationSymbol = plus;
        flag = '1';
        firstVariable = getVariableFromTextField();
    }
    private static double getVariableFromTextField() {
        return Double.parseDouble(textField.getText());
    }

}
