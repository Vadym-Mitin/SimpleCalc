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

    private static void setResult(double equation) {
        String str = Double.toString(equation);
        str = str.replaceAll("()\\.0+$|(\\..+?)0+$", "$2");
        display.setText(str);
    }

    private static void setResult(int equation) {
        display.setText(Integer.toString(equation));
    }

    private static void setResult(String equation) {
        String str = equation;
        str = str.replaceAll("()\\.0+$|(\\..+?)0+$", "$2");
        display.setText(str);
    }

    private static String getStringVariable() {
        return display.getText();
    }

    private static double getDoubleVariable() {
        return Double.parseDouble(display.getText());
    }

    public static void arithmeticalAction(Signs sign) {
        equationSign = sign;
        firstValue = getDoubleVariable();
        repeatedResult = false;
        repeatedNumeric = false;
    }

    public static void resultAction() {
        if (repeatedResult) {
            firstValue = getDoubleVariable();
            calculation(equationSign);
            repeatedResult = true;
            repeatedNumeric = false;
        } else {
            secondValue = getDoubleVariable();
            calculation(equationSign);
            repeatedResult = true;
            repeatedNumeric = false;
        }
    }

    public static void percentAction() {
        repeatedResult = false;
        repeatedNumeric = false;
        double value = getDoubleVariable();
        double percent = (firstValue / 100) * value;
        setResult(percent);
    }

    public static void sqrtAction() {
        repeatedResult = false;
        repeatedNumeric = false;
        double value = getDoubleVariable();
        double sqrt = Math.sqrt(value);
        setResult(sqrt);
    }

    public static void powOneAction() {
        double value = getDoubleVariable();
        double powOne = Math.pow(value, (-1));
        repeatedResult = false;
        repeatedNumeric = false;
        setResult(powOne);
    }

    public static void powTwoAction() {
        double value = getDoubleVariable();
        double powTwo = Math.pow(value, (2));
        repeatedResult = false;
        repeatedNumeric = false;
        setResult(powTwo);
    }

    private static void calculation(Signs buttonSign) {
        switch (buttonSign) {
            case ADDITION:
                setResult(firstValue + secondValue);
                break;
            case SUBTRACTION:
                setResult(firstValue - secondValue);
                break;
            case MULTIPLICATION:
                setResult(firstValue * secondValue);
                break;
            case DIVISION:
                setResult(firstValue / secondValue);
                break;
        }
    }

    public static void numericAction(ActionEvent event) {
        MyButton button = (MyButton) event.getSource();
        int value = button.getValue();
        String stringValue = Integer.toString(value);
        String text = getStringVariable();

        if (text.equals("0")) {
            if (value == 0) {
                repeatedResult = false;
                repeatedNumeric = false;
            } else {
                setResult(value);
                repeatedResult = false;
                repeatedNumeric = true;
            }
        } else {
            if (repeatedNumeric) {
                setResult(text + stringValue);
                repeatedResult = false;
                repeatedNumeric = true;
            } else {
                setResult(stringValue);
                repeatedResult = false;
                repeatedNumeric = true;
            }
        }
    }


    public static void memoryAction(Signs sign) {
        repeatedNumeric = false;
        switch (sign) {
            case MEMORY_CLEAR:
                memory = 0;
                break;
            case MEMORY_READ:
                setResult(memory);
                break;
            case MEMORY_PLUS:
                memory += getDoubleVariable();
                break;
            case MEMORY_MINUS:
                memory -= getDoubleVariable();
                break;
        }
    }

    public static void decimalPointAction() {
        String text = getStringVariable();
        repeatedResult = false;
        repeatedNumeric = true;
        if (!text.contains(".")) {
            setResult(text + ".");
        }
    }

    public static void removeAction() {
        String text = getStringVariable();
        if (!repeatedResult) {
            if (!text.equals("0") && text.length() > 1) {
                setResult(text.substring(0, text.length() - 1));
            } else {
                setResult("0");
            }
            repeatedNumeric = true;
        } else repeatedNumeric = false;
    }

    public static void clearAllAction() {
        setResult("0");
        firstValue = 0;
        secondValue = 0;
        equationSign = EMPTY;
        repeatedNumeric = false;
        repeatedResult = false;
    }

    public static void clearEntryAction() {
        setResult("0");
        repeatedNumeric = false;
//        repeatedResult = false;
    }

    public static void changeSignAction() {
        String value = getStringVariable();
        if (!value.equals("0")) {
            if (value.charAt(0) == '-') {
                setResult(value.substring(1));
            } else {
                setResult("-" + value);
            }
        }
    }
}
