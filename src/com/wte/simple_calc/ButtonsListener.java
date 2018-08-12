package com.wte.simple_calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.wte.simple_calc.CalculatorEngine.*;
import static com.wte.simple_calc.Signs.*;

public class ButtonsListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        Signs symbol = ((MyButton) event.getSource()).getSign();

        CalculatorEngine.setTextField(CalculatorGui.getDisplay());

        switch (symbol) {
            case ADDITION:
                arithmeticalAction(ADDITION);
                break;
            case SUBTRACTION:
                arithmeticalAction(SUBTRACTION);
                break;
            case DIVISION:
                arithmeticalAction(DIVISION);
                break;
            case MULTIPLICATION:
                arithmeticalAction(MULTIPLICATION);
                break;
            case SQRT:
                sqrtAction();
                break;
            case PERCENT:
                percentAction();
                break;
            case MOD_ONE:
                modOneAction();
                break;
            case MOD_TWO:
                modTwoAction();
                break;
            case DECIMAL_POINT:
                decimalPointAction();
                break;
            case CHANGE_SIGN:
                changeSignAction();
                break;
            case RESULT:
                resultAction();
                break;
            case NUMERIC:
                numericAction(event);
                break;
            case MEMORY_READ:
                memoryAction(MEMORY_READ);
                break;
            case MEMORY_CLEAR:
                memoryAction(MEMORY_CLEAR);
                break;
            case MEMORY_PLUS:
                memoryAction(MEMORY_PLUS);
                break;
            case MEMORY_MINUS:
                memoryAction(MEMORY_MINUS);
                break;
            case CLEAR_ALL:
                clearAllAction();
                break;
            case CLEAR_ENTRY:
                clearEntryAction();
                break;
            case REMOVE:
                removeAction();
                break;
        }
    }
}
