package com.wte.simple_calc;

import javax.swing.*;

import java.awt.event.ActionEvent;

import static com.wte.simple_calc.Signs.*;

public class CalculatorEngine {

    private static Signs equationSign;
    private static double firstValue;
    private static double secondValue;
    private static JTextField display;
    private static boolean repeatedResult;
    private static boolean repeatedNumeric;
    private static double memory;

    static {
        equationSign = EMPTY;
        firstValue = 0;
        secondValue = 0;
        repeatedNumeric = false;
        repeatedResult = false;
        memory = 0;
    }

    public static void setTextField(JTextField textField) {
        display = textField;
    }

    private static void setResultToDisplay(JTextField textField, double equation) {
        textField.setText(Double.toString(equation));
    }

    private static double getVariableFromDisplay() {
        return Double.parseDouble(display.getText());
    }

    public static void arithmeticalAction(Signs sign) {
        equationSign = sign;
        firstValue = getVariableFromDisplay();
        repeatedResult = false;
        repeatedNumeric = false;
    }

    public static void resultAction() {
        if (repeatedResult) {
            firstValue = getVariableFromDisplay();
            calculation(equationSign);
            repeatedResult = true;
            repeatedNumeric = false;
        } else {
            secondValue = getVariableFromDisplay();
            calculation(equationSign);
            repeatedResult = true;
            repeatedNumeric = false;
        }
    }

    private static void calculation(Signs buttonSign) {
        switch (buttonSign) {
            case ADDITION:
                setResultToDisplay(display, firstValue + secondValue);
                break;
            case SUBTRACTION:
                setResultToDisplay(display, firstValue - secondValue);
                break;
            case MULTIPLICATION:
                setResultToDisplay(display, firstValue * secondValue);
                break;
            case DIVISION:
                setResultToDisplay(display, firstValue / secondValue);
                break;
        }
    }

    public static void numericAction(ActionEvent event) {
        MyButton button = (MyButton) event.getSource();
        int value = button.getValue();
        String stringValue = Integer.toString(value);
        String text = display.getText();

        if (text.equals("0")) {
            if (value == 0) {
//                display.setText(Integer.toString(value));
                repeatedResult = false;
                repeatedNumeric = false;
            } else {
                display.setText(Integer.toString(value));
                repeatedResult = false;
                repeatedNumeric = true;
            }
        } else {
            if (repeatedNumeric) {
                display.setText(text + stringValue);
                repeatedResult = false;
                repeatedNumeric = true;
            } else {
                display.setText(stringValue);
                repeatedResult = false;
                repeatedNumeric = true;
            }
        }
    }


    public static void memoryAction(Signs sign) {
        repeatedResult = false;
        repeatedNumeric = false;

        switch (sign) {
            case MEMORY_CLEAR:
                memory = 0;
                break;
            case MEMORY_READ:
                display.setText(Double.toString(memory));
                break;
            case MEMORY_PLUS:
                memory += getVariableFromDisplay();
                break;
            case MEMORY_MINUS:
                memory -= getVariableFromDisplay();
                break;
        }
    }

    public static void decimalPointAction() {
        String text = display.getText();
        if (!text.contains(".")) {
            display.setText(text + ".");
        }
        repeatedResult = false;
        repeatedNumeric = true;
    }

    public static void removeAction() {
        String text = display.getText();
        if (!text.equals("0") && text.length() > 1) {
            display.setText(text.substring(0, text.length() - 1));
        } else {
            display.setText("0");
        }
        repeatedNumeric = false;
        repeatedResult = false;
    }

    public static void clearAllAction() {
        display.setText("0");
        firstValue = 0;
        secondValue = 0;
        equationSign = EMPTY;
        repeatedNumeric = false;
        repeatedResult = false;
    }

    public static void clearEntryAction() {
        display.setText("0");
        repeatedNumeric = false;
        repeatedResult = false;
    }

    public static void changeSignAction() {
        String value = display.getText();
        if (!value.equals("0")) {
            if (value.charAt(0) == '-') {
                display.setText(value.substring(1));
            } else {
                display.setText("-" + value);
            }
        }
    }
}
