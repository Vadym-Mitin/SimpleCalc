package com.wte.simple_calc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.wte.simple_calc.Calculator.calculate;

public class ButtonsListener implements ActionListener {


    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";
    private static final String EQUATION = "=";

    private char equationSymbol;
    private char flag;
    private JTextField textNum;
    private static double firstVariable;
    private static double secondVariable;
    private boolean counter = true;
    private boolean valCount = true;

    @Override
    public void actionPerformed(ActionEvent e) {

        String buttonSymbol = ((Button) e.getSource()).getInd();

        if (Signs.PLUS == buttonSymbol) {
            calculate(PLUS);
        } else if (MINUS.equals(buttonSymbol)) {
            calculate(MINUS);
        } else if (MULTIPLICATION.equals(buttonSymbol)) {
            calculate(MULTIPLICATION);
        } else if (DIVISION.equals(buttonSymbol)) {
            calculate(DIVISION);
        }
//         блок для кнопки равно
        else if (EQUATION.equals(buttonSymbol)) {
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
        else if (buttonSymbol == 'N') {
            Button b = (Button) e.getSource();
            if (textNum.getText().equals("0")) {
                textNum.setText(b.toString());
            } else {
                if (counter && valCount) {
                    textNum.setText("");
                    textNum.setText(textNum.getText() + b.toString());
                    valCount = false;
                }
                if ((!counter) && (!valCount)) {
                    textNum.setText("");
                    textNum.setText(textNum.getText() + b.toString());
                    valCount = false;
                } else {
                    textNum.setText(textNum.getText() + b.toString());
                }
            }
        }
    }

    private double getVariableFromTextField() {
        return Double.parseDouble(textNum.getText());
    }

    private static void equation(JTextField textField, char equationSymbol, double firstValue, double secondValue) {
        if (equationSymbol == PLUS) {
            setResult(textField, firstValue + secondValue);
        } else if (equationSymbol == MINUS) {
            setResult(textField, firstValue - secondValue);
        } else if (equationSymbol == MULTIPLICATION) {
            setResult(textField, firstValue * secondValue);
        } else if (equationSymbol == DIVISION) {
            setResult(textField, firstValue / secondValue);
        }
    }

    private static void setResult(JTextField textField, double equation) {
        textField.setText(Double.toString(equation));
    }


}
