package com.wte.simple_calc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcAlgo implements ActionListener {
    private char equ, flag;
    private JTextField textNum;
    private static double first, second;
    private boolean counter = true, valCount = true;


    public void setTextField(JTextField tf) {
        this.textNum = tf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (((CalcButton) e.getSource()).getInd() == '+') {
            equ = '+';
            flag = '1';
            first = Double.parseDouble(textNum.getText());
        } else if (((CalcButton) e.getSource()).getInd() == '-') {
            equ = '-';
            flag = '1';
            first = Double.parseDouble(textNum.getText());
        } else if (((CalcButton) e.getSource()).getInd() == '*') {
            equ = '*';
            flag = '1';
            first = Double.parseDouble(textNum.getText());
        } else if (((CalcButton) e.getSource()).getInd() == '/') {
            equ = '/';
            flag = '1';
            first = Double.parseDouble(textNum.getText());
        }
//         блок для кнопки равно
        else if (((CalcButton) e.getSource()).getText().equals("=")) {
            if (counter) {
                second = Double.parseDouble(textNum.getText());
                CalcAlgo.equation(textNum, equ, first, second);
                flag = '2';
            } else {
                first = Double.parseDouble(textNum.getText());
                CalcAlgo.equation(textNum, equ, first, second);
                flag = '2';
            }
        }
//        блок для цифровых кнопок
        else if (((CalcButton) e.getSource()).getInd() == 'N') {
            CalcButton b = (CalcButton) e.getSource();
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


    public static void equation(JTextField tf, char i, double first, double second) {
        if (i == '+') {
            tf.setText(Double.toString(first + second));
        } else if (i == '-') {
            tf.setText(Double.toString(first - second));
        } else if (i == '*') {
            tf.setText(Double.toString(first * second));
        } else if (i == '/') {
            tf.setText(Double.toString(first / second));
        }
    }
}
