package com.wte.simple_calc;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class CalcGui extends JFrame {


    public CalcGui() {
        CalcAlgo listener = new CalcAlgo();
        ArrayList<CalcButton> numButtons = new ArrayList<>();
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

        // �������� ������ ��������� � ��� ������ (��� ������ �����
        // 2 ������ ���� ��� ����� � ���� � ���� ��� ���������� � �����
        pane.add(textPane);
        pane.add(buttonPane);
        buttonPane.add(numButtonsPane);
        buttonPane.add(opButPane);

        addOpButton(opButPane, listener);
        addNumButtons(numButtonsPane, numButtons, listener);

        JTextField textNum = new JTextField(20);
        listener.setTextField(textNum);
        textNum.setText("0");
        textNum.setHorizontalAlignment(JTextField.RIGHT);
        textPane.add(textNum);

        pack();

    }

    private void addOpButton(Container c, CalcAlgo a) {

        CalcButton plusButton = new CalcButton("+");
        plusButton.setInd('+');
        plusButton.setSize(new Dimension(15, 15));

        CalcButton minusButton = new CalcButton("-");
        minusButton.setInd('-');
        minusButton.setSize(new Dimension(15, 15));

        CalcButton multiplyButton = new CalcButton("*");
        multiplyButton.setInd('*');
        multiplyButton.setSize(new Dimension(15, 15));

        CalcButton divisionButton = new CalcButton("/");
        divisionButton.setInd('/');
        divisionButton.setSize(new Dimension(15, 15));

        CalcButton calcButton = new CalcButton("=");
        calcButton.setInd('=');
        calcButton.setSize(new Dimension(15, 15));


        plusButton.addActionListener(a);
        minusButton.addActionListener(a);
        multiplyButton.addActionListener(a);
        divisionButton.addActionListener(a);
        calcButton.addActionListener(a);


        c.add(plusButton);
        c.add(minusButton);
        c.add(multiplyButton);
        c.add(divisionButton);
        c.add(calcButton);

    }


    private void addNumButtons(Container c, ArrayList a,CalcAlgo al) {

        ArrayList<CalcButton> list = a;
        int count;

        for (int i = 0; i <10 ; i++) {
            list.add(i, new CalcButton(Integer.toString(i)));
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

