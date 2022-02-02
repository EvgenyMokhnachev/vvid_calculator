package ru.sfedu.mohnachev.vvid.part2.calculator;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class InputCaretListener implements CaretListener {
    private int newPosition = 0;
    private JTextField field;

    public InputCaretListener(JTextField field) {
        this.field = field;
    }

    @Override
    public void caretUpdate(CaretEvent caretEvent) {
        if (newPosition != caretEvent.getMark()) {
            newPosition = 0;
            field.setCaretPosition(newPosition);
        }
    }
}
