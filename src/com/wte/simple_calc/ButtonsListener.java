package com.wte.simple_calc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.wte.simple_calc.Calculator.calculate;
import static com.wte.simple_calc.Signs.*;

public class ButtonsListener implements ActionListener {

    private String equationSymbol;
    private char flag;
    private JTextField textNum;
    private static double firstVariable;
    private static double secondVariable;
    private boolean counter = false;
    private boolean valCount = true;

    @Override
    public void actionPerformed(ActionEvent event) {

        String buttonSymbol = ((MyButton) event.getSource()).getIndicator();
        

        if (PLUS.getSign().equals(buttonSymbol)) {
            calculate(PLUS.getSign());
        } else if (MINUS.getSign().equals(buttonSymbol)) {
            calculate(MINUS.getSign());
        } else if (MULTIPLICATION.getSign().equals(buttonSymbol)) {
            calculate(MULTIPLICATION.getSign());
        } else if (DIVISION.getSign().equals(buttonSymbol)) {
            calculate(DIVISION.getSign());
        }
//         блок для кнопки равно
        else if (EQUATION.getSign().equals(buttonSymbol)) {
            if (counter) {
                secondVariable = getVariableFromTextField();
                ButtonsListener.equation(textNum, equationSymbol, firstVariable, secondVariable);
                flag = '2';
            } else {
                firstVariable = getVariableFromTextField();
                ButtonsListener.equation(textNum, equationSymbol, firstVariable, secondVariable);
                flag = '2';
            }
        }
//        блок для цифровых кнопок
        else if (buttonSymbol.equals("N")) {
            MyButton button = (MyButton) event.getSource();
            if (textNum.getText().equals("0")) {
                textNum.setText(Integer.toString(button.getValue()));
            } else {
                if (counter && valCount) {
                    textNum.setText("");
                    textNum.setText(textNum.getText() + button.getIndicator());
                    valCount = false;
                }
                if ((!counter) && (!valCount)) {
                    textNum.setText("");
                    textNum.setText(textNum.getText() + button.getIndicator());
                    valCount = false;
                } else {
                    textNum.setText(textNum.getText() + button.getIndicator());
                }
            }
        }
    }

    private double getVariableFromTextField() {
        return Double.parseDouble(textNum.getText());
    }

    private static void equation(JTextField textField, String symbol, double firstValue, double secondValue) {
        if (PLUS.getSign().equals(symbol)) {
            setResult(textField, firstValue + secondValue);
        } else if (MINUS.getSign().equals(symbol)) {
            setResult(textField, firstValue - secondValue);
        } else if (MULTIPLICATION.getSign().equals(symbol)) {
            setResult(textField, firstValue * secondValue);
        } else if (DIVISION.getSign().equals(symbol)) {
            setResult(textField, firstValue / secondValue);
        }
    }

    private static void setResult(JTextField textField, double equation) {
        textField.setText(Double.toString(equation));
    }
}
