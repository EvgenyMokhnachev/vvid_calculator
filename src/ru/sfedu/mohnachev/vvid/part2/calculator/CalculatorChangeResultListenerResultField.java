package ru.sfedu.mohnachev.vvid.part2.calculator;

import javax.swing.*;

public class CalculatorChangeResultListenerResultField implements CalculatorChangeResultListener {
    private JTextField field;

    public CalculatorChangeResultListenerResultField(JTextField field) {
        this.field = field;
    }

    public void change(String text) {
        field.setText(text);
    }

}
