package com.wte.simple_calc;

import javax.swing.*;

public class Calculator {
    private static String equationSymbol;
    private static char flag;
    private static Double firstVariable;
    private static Double secondVariable;
    private static JTextField textField;

    public static void setTextField(JTextField textField) {
        Calculator.textField = textField;
    }

    public static void calculate(String sign) {
        equationSymbol = sign;
        flag = '1';
        firstVariable = Double.parseDouble(textField.getText());

    }

}
