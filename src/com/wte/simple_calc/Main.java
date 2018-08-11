package com.wte.simple_calc;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorGui().setVisible(true);

            }
        });

    }
}
