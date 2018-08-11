package com.wte.simple_calc;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static com.wte.simple_calc.Signs.*;

public class CalculatorGui extends JFrame {
    private static JTextField display;

    public CalculatorGui() {
        ButtonsListener buttonsListener = new ButtonsListener();
        ArrayList<MyButton> numericButtons = new ArrayList<>();
        Font f = new Font("Serif", Font.BOLD, 30);
        UIManager.put("MyButton.font", f);
        UIManager.put("TextField.font", f);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 500);
        JPanel pane = new JPanel();
        add(pane);
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        JPanel textPane = new JPanel(new GridLayout(3, 1));
        JPanel buttonPane = new JPanel(new GridLayout(1, 2));
        JPanel numericButtonsPane = new JPanel(new GridLayout(4, 3, 5, 5));
        JPanel operationButtonsPane = new JPanel(new GridLayout(5, 1, 5, 5));

        JPanel memoryPane = new JPanel(new GridLayout(1, 4));
        JPanel actionPane = new JPanel(new GridLayout(1, 3));

        pane.add(textPane);
        pane.add(buttonPane);

        buttonPane.add(numericButtonsPane);
        buttonPane.add(operationButtonsPane);

        addOperationalButtons(operationButtonsPane, buttonsListener);
        addNumericButtons(numericButtonsPane, numericButtons, buttonsListener);

        JTextField textField = new JTextField(20);
        display = textField;
        textField.setText("0");
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(f);
        textPane.add(textField);

        textPane.add(memoryPane);
        addMemoryButtons(memoryPane, buttonsListener);

        textPane.add(actionPane);
        addActionButtons(actionPane, buttonsListener);

        pack();
    }

    private void addButtonToContainer(Container container, ButtonsListener buttonsListener, Signs sign) {
        MyButton button = new MyButton(sign);
        button.setValue(0);
        button.setSize(new Dimension(15, 15));
        button.addActionListener(buttonsListener);
        container.add(button);
    }

    private void addActionButtons(Container container, ButtonsListener buttonsListener) {
        addButtonToContainer(container, buttonsListener, CLEAR_ENTRY);
        addButtonToContainer(container, buttonsListener, CLEAR_ALL);
        addButtonToContainer(container, buttonsListener, REMOVE);
    }

    private void addMemoryButtons(Container container, ButtonsListener buttonsListener) {
        addButtonToContainer(container, buttonsListener, MEMORY_READ);
        addButtonToContainer(container, buttonsListener, MEMORY_CLEAR);
        addButtonToContainer(container, buttonsListener, MEMORY_PLUS);
        addButtonToContainer(container, buttonsListener, MEMORY_MINUS);
    }

    private void addOperationalButtons(Container container, ButtonsListener buttonsListener) {
        addButtonToContainer(container, buttonsListener, ADDITION);
        addButtonToContainer(container, buttonsListener, SUBTRACTION);
        addButtonToContainer(container, buttonsListener, MULTIPLICATION);
        addButtonToContainer(container, buttonsListener, DIVISION);
        addButtonToContainer(container, buttonsListener, RESULT);
    }

    private void addNumericButtons(Container c, ArrayList<MyButton> buttons, ButtonsListener listener) {
        int count;

        for (int i = 0; i < 10; i++) {
            buttons.add(i, new MyButton(NUMERIC, i));
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
        MyButton pointButton = new MyButton(DECIMAL_POINT);
        pointButton.addActionListener(listener);
        c.add(pointButton);
        MyButton changeButton = new MyButton(CHANGE_SIGN);
        changeButton.addActionListener(listener);
        c.add(changeButton);
    }

    public static JTextField getDisplay() {
        return display;
    }
}

