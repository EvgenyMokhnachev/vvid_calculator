package ru.sfedu.mohnachev.vvid.part2.calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {

    private static final String TITLE = "Калькулятор. КТбз3-4. Мохначев Е.С. Таганрог 2022 г.";

    public CalculatorFrame() throws HeadlessException {
        setTitle(TITLE);
        setBounds(300, 90, 450, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void open() {
        setVisible(Boolean.TRUE);
    }

}
