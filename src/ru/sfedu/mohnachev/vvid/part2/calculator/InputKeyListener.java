package ru.sfedu.mohnachev.vvid.part2.calculator;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputKeyListener implements KeyListener {
    private JTextField field;

    public InputKeyListener(JTextField field) {
        this.field = field;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        keyEvent.getKeyChar();
        keyEvent.consume();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {}

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        Long i = 0l;
    }
}
