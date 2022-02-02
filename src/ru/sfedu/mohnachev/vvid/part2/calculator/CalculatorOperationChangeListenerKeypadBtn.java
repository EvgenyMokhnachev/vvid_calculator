package ru.sfedu.mohnachev.vvid.part2.calculator;

import javax.swing.*;

public class CalculatorOperationChangeListenerKeypadBtn implements CalculatorOperationChangeListener {
    private final JButton button;
    private final String operation;

    public CalculatorOperationChangeListenerKeypadBtn(JButton button, String operation) {
        this.button = button;
        this.operation = operation;
    }

    public void change(String operation) {
        if (operation != null && operation.equals(this.operation)) {
            ButtonModel model = button.getModel();
            model.setEnabled(Boolean.FALSE);
        } else {
            ButtonModel model = button.getModel();
            model.setEnabled(Boolean.TRUE);
        }
    }

}
