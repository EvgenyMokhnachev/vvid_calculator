package ru.sfedu.mohnachev.vvid.part2.calculator;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class InputFocusListener implements FocusListener {
    private JTextField field;

    public InputFocusListener(JTextField field) {
        this.field = field;
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {

    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        field.requestFocus();
    }
}
