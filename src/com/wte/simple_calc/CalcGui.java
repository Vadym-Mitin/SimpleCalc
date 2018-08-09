package com.wte.simple_calc;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class CalcGui extends JFrame {


    public CalcGui() {
        ButtonListener listener = new ButtonListener();
        ArrayList<Button> numericalButtons = new ArrayList<>();
        Font f = new Font("Serif", Font.BOLD, 20);
        UIManager.put("Button.font", f);
        UIManager.put("TextField.font", f);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 500);
        JPanel pane = new JPanel();
        add(pane);
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        JPanel textPane = new JPanel();
        JPanel buttonPane = new JPanel(new GridLayout(1, 2));
        JPanel numButtonsPane = new JPanel(new GridLayout(4, 3, 5, 5));
        JPanel opButPane = new JPanel(new GridLayout(5, 1, 5, 5));

        // Добавляю панели текстовую и для кнопок (для кнопок будет
        // 2 панели одна для чисел в грид и одна для операторов в боксе
        pane.add(textPane);
        pane.add(buttonPane);
        buttonPane.add(numButtonsPane);
        buttonPane.add(opButPane);

        addOpButton(opButPane, listener);
        addNumButtons(numButtonsPane, numericalButtons, listener);

        JTextField textNum = new JTextField(20);
        listener.setTextField(textNum);
        textNum.setText("0");
        textNum.setHorizontalAlignment(JTextField.RIGHT);
        textPane.add(textNum);

        pack();

    }

    private void addOpButton(Container c, ButtonListener a) {

        Button plusButton = new Button("+");
        plusButton.setInd('+');
        plusButton.setSize(new Dimension(15, 15));

        Button minusButton = new Button("-");
        minusButton.setInd('-');
        minusButton.setSize(new Dimension(15, 15));

        Button multiplyButton = new Button("*");
        multiplyButton.setInd('*');
        multiplyButton.setSize(new Dimension(15, 15));

        Button divisionButton = new Button("/");
        divisionButton.setInd('/');
        divisionButton.setSize(new Dimension(15, 15));

        Button button = new Button("=");
        button.setInd('=');
        button.setSize(new Dimension(15, 15));


        plusButton.addActionListener(a);
        minusButton.addActionListener(a);
        multiplyButton.addActionListener(a);
        divisionButton.addActionListener(a);
        button.addActionListener(a);


        c.add(plusButton);
        c.add(minusButton);
        c.add(multiplyButton);
        c.add(divisionButton);
        c.add(button);

    }


    private void addNumButtons(Container c, ArrayList a, ButtonListener al) {

        ArrayList<Button> list = a;
        int count;

        for (int i = 0; i <10 ; i++) {
            list.add(i, new Button(Integer.toString(i)));
            list.get(i).setVal(i);
            list.get(i).setInd('N');
            list.get(i).setSize(new Dimension(15, 15));
            list.get(i).addActionListener(al);
        }

        for (int i = 3; i >= 1; i--) {
            for (int j = 2; j >= 0; j--) {
                count = i * 3 - j;
                c.add(list.get(count));
            }
        }
        c.add(list.get(0));
    }


}

