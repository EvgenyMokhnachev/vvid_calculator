package ru.sfedu.mohnachev.vvid.part2.calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeypadActionListener implements ActionListener {
    private JTextField field;
    private String key;

    public KeypadActionListener(JTextField field, String key) {
        this.key = key;
        this.field = field;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.field.setText(this.field.getText() + key);
    }

}
