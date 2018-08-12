package com.wte.simple_calc;

import javax.swing.*;
import java.awt.*;

import static com.wte.simple_calc.Signs.*;

public class CalculatorGui extends JFrame {
    private static JTextField display;

    public CalculatorGui() {
        ButtonsListener buttonsListener = new ButtonsListener();
        Font f = new Font("Serif", Font.BOLD, 30);
        UIManager.put("MyButton.font", f);
        UIManager.put("TextField.font", f);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 500);
        JPanel pane = new JPanel();
        add(pane);
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        JPanel textPane = new JPanel(new GridLayout(1, 1));
        JPanel buttonPane = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        pane.add(textPane);
        pane.add(buttonPane);

        addAllButtons(buttonPane, constraints, buttonsListener);

        JTextField textField = new JTextField(20);
        display = textField;
        textField.setText("0");
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(f);
        textPane.add(textField);

        pack();
    }

    private void addButtonToContainer(Container container, GridBagConstraints c, ButtonsListener buttonsListener, Signs sign) {
        MyButton button = new MyButton(sign);
        button.setValue(0);
        button.setSize(new Dimension(15, 15));
        button.addActionListener(buttonsListener);
        container.add(button, c);
    }

    private void addButtonToContainer(Container container, GridBagConstraints c, ButtonsListener buttonsListener, Signs sign, int value) {
        MyButton button = new MyButton(sign, value);
        button.setValue(value);
        button.setSize(new Dimension(15, 15));
        button.addActionListener(buttonsListener);
        container.add(button, c);
    }


    private void addAllButtons(Container container, GridBagConstraints c, ButtonsListener buttonsListener) {
// add row n1
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        addButtonToContainer(container, c, buttonsListener, MEMORY_CLEAR);
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        addButtonToContainer(container, c, buttonsListener, MEMORY_READ);
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        addButtonToContainer(container, c, buttonsListener, MEMORY_PLUS);
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 0;
        addButtonToContainer(container, c, buttonsListener, MEMORY_MINUS);
// add row n2
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        addButtonToContainer(container, c, buttonsListener, PERCENT);
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        addButtonToContainer(container, c, buttonsListener, SQRT);
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 1;
        addButtonToContainer(container, c, buttonsListener, POW_TWO);
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 1;
        addButtonToContainer(container, c, buttonsListener, POW_ONE);
// add row n3
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        addButtonToContainer(container, c, buttonsListener, CLEAR_ENTRY);
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 2;
        addButtonToContainer(container, c, buttonsListener, CLEAR_ALL);
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 2;
        addButtonToContainer(container, c, buttonsListener, REMOVE);
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 2;
        addButtonToContainer(container, c, buttonsListener, DIVISION);
// add row n4
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 3;
        addButtonToContainer(container, c, buttonsListener, NUMERIC, 7);
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 3;
        addButtonToContainer(container, c, buttonsListener, NUMERIC, 8);
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 3;
        addButtonToContainer(container, c, buttonsListener, NUMERIC, 9);
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 3;
        addButtonToContainer(container, c, buttonsListener, MULTIPLICATION);
// add row n5
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 4;
        addButtonToContainer(container, c, buttonsListener, NUMERIC, 4);
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 4;
        addButtonToContainer(container, c, buttonsListener, NUMERIC, 5);
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 4;
        addButtonToContainer(container, c, buttonsListener, NUMERIC, 6);
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 4;
        addButtonToContainer(container, c, buttonsListener, SUBTRACTION);
// add row n6
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 5;
        addButtonToContainer(container, c, buttonsListener, NUMERIC, 1);
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 5;
        addButtonToContainer(container, c, buttonsListener, NUMERIC, 2);
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 5;
        addButtonToContainer(container, c, buttonsListener, NUMERIC, 3);
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 5;
        addButtonToContainer(container, c, buttonsListener, ADDITION);
// add row n7
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 6;
        addButtonToContainer(container, c, buttonsListener, CHANGE_SIGN);
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 6;
        addButtonToContainer(container, c, buttonsListener, NUMERIC, 0);
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 6;
        addButtonToContainer(container, c, buttonsListener, DOT_ADD);
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 6;
        addButtonToContainer(container, c, buttonsListener, RESULT);
    }

    public static JTextField getDisplay() {
        return display;
    }
}

