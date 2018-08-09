package com.wte.simple_calc;

import javax.swing.*;

public class CalcMain {

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalcGui().setVisible(true);

            }
        });

    }
}
