package com.wte.simple_calc;

import com.wte.simple_calc.MyButton;
import com.wte.simple_calc.ButtonsListener;
import com.wte.simple_calc.Calculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static com.wte.simple_calc.Signs.*;


public class CalcGui extends JFrame {

    public CalcGui() {
        ButtonsListener buttonsListener = new ButtonsListener();
        ArrayList<MyButton> numericButtons = new ArrayList<>();
        Font f = new Font("Serif", Font.BOLD, 20);
        UIManager.put("MyButton.font", f);
        UIManager.put("TextField.font", f);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 500);
        JPanel pane = new JPanel();
        add(pane);
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        JPanel textPane = new JPanel();
        JPanel buttonPane = new JPanel(new GridLayout(1, 2));
        JPanel numericButtonsPane = new JPanel(new GridLayout(4, 3, 5, 5));
        JPanel operationButtonsPane = new JPanel(new GridLayout(5, 1, 5, 5));

        // Добавляю панели текстовую и для кнопок (для кнопок будет
        // 2 панели одна для чисел в грид и одна для операторов в боксе
        pane.add(textPane);
        pane.add(buttonPane);
        buttonPane.add(numericButtonsPane);
        buttonPane.add(operationButtonsPane);

        addOpButton(operationButtonsPane, buttonsListener);
        addNumButtons(numericButtonsPane, numericButtons, buttonsListener);

        JTextField textField = new JTextField(20);
        Calculator.setTextField(textField);
        textField.setText("");
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textPane.add(textField);
        pack();
    }

    private void addOpButton(Container container, ButtonsListener buttonsListener) {

        MyButton plusButton = new MyButton(PLUS.getSign());
        plusButton.setIndicator(PLUS.getSign());
        plusButton.setValue(0);
        plusButton.setSize(new Dimension(15, 15));

        MyButton minusButton = new MyButton(MINUS.getSign());
        minusButton.setIndicator(MINUS.getSign());
        minusButton.setValue(0);
        minusButton.setSize(new Dimension(15, 15));

        MyButton multiplyButton = new MyButton(MULTIPLICATION.getSign());
        multiplyButton.setIndicator(MULTIPLICATION.getSign());
        multiplyButton.setValue(0);
        multiplyButton.setSize(new Dimension(15, 15));

        MyButton divisionButton = new MyButton(DIVISION.getSign());
        divisionButton.setIndicator(DIVISION.getSign());
        divisionButton.setValue(0);
        divisionButton.setSize(new Dimension(15, 15));

        MyButton equationButton = new MyButton(EQUATION.getSign());
        equationButton.setIndicator(EQUATION.getSign());
        equationButton.setValue(0);
        equationButton.setSize(new Dimension(15, 15));

        plusButton.addActionListener(buttonsListener);
        minusButton.addActionListener(buttonsListener);
        multiplyButton.addActionListener(buttonsListener);
        divisionButton.addActionListener(buttonsListener);
        equationButton.addActionListener(buttonsListener);

        container.add(plusButton);
        container.add(minusButton);
        container.add(multiplyButton);
        container.add(divisionButton);
        container.add(equationButton);
    }

    private void addNumButtons(Container c, ArrayList<MyButton> buttons, ButtonsListener listener) {

        int count;

        for (int i = 0; i < 10; i++) {
            buttons.add(i, new MyButton(Integer.toString(i)));
            buttons.get(i).setValue(i);
            buttons.get(i).setIndicator("N");
            buttons.get(i).setSize(new Dimension(15, 15));
            buttons.get(i).addActionListener(listener);
        }

        for (int i = 3; i >= 1; i--) {
            for (int j = 2; j >= 0; j--) {
                count = i * 3 - j;
                c.add(buttons.get(count));
            }
        }
        c.add(buttons.get(0));
    }


}

