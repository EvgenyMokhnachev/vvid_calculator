package ru.sfedu.mohnachev.vvid.part2.calculator;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputCaretListener implements CaretListener {
    private int newPosition = 0;
    private JTextField field;

    public InputCaretListener(JTextField field) {
        this.field = field;
    }

    @Override
    public void caretUpdate(CaretEvent caretEvent) {
        if (newPosition != caretEvent.getMark()) {
            newPosition = field.getText().length();
            field.setCaretPosition(newPosition);
        }
    }
}
