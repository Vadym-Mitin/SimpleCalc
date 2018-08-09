package com.wte.simple_calc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {


    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private char equationSymbol;
    private char flag;
    private JTextField textNum;
    private static double firstVariable;
    private static double secondVariable;
    private boolean counter = true;
    private boolean valCount = true;

    @Override
    public void actionPerformed(ActionEvent e) {

        char buttonSymbol = ((Button) e.getSource()).getInd();

        if (buttonSymbol == PLUS) {
            equationSymbol = PLUS;
            flag = '1';
            firstVariable = getVariableFromTextField();
        } else if (buttonSymbol == MINUS) {
            equationSymbol = MINUS;
            flag = '1';
            firstVariable = getVariableFromTextField();
        } else if (buttonSymbol == MULTIPLICATION) {
            equationSymbol = MULTIPLICATION;
            flag = '1';
            firstVariable = getVariableFromTextField();
        } else if (buttonSymbol == DIVISION) {
            equationSymbol = DIVISION;
            flag = '1';
            firstVariable = getVariableFromTextField();
        }
//         блок для кнопки равно
        else if (buttonSymbol == '=') {
            if (counter) {
                secondVariable = getVariableFromTextField();
                ButtonListener.equation(textNum, equationSymbol, firstVariable, secondVariable);
                flag = '2';
            } else {
                firstVariable = getVariableFromTextField();
                ButtonListener.equation(textNum, equationSymbol, firstVariable, secondVariable);
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

    private double getVariableFromTextField() {
        return Double.parseDouble(textNum.getText());
    }

    public void setTextField(JTextField textField) {
        this.textNum = textField;
    }
}
