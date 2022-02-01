package ru.sfedu.mohnachev.vvid.part2.calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {

    private static final String TITLE = "Калькулятор. КТбз3-4. Мохначев Е.С. Таганрог 2022 г.";

    private static final int FRAME_X_POS = 300;
    private static final int FRAME_Y_POS = 90;
    private static final int FRAME_WIDTH = 450;
    private static final int FRAME_HEIGHT = 600;

    private Container container;

    public CalculatorFrame() throws HeadlessException {
        initFrame();
        initLayout();
        initElements();
    }

    private void initFrame() {
        setTitle(TITLE);
        setBounds(FRAME_X_POS, FRAME_Y_POS, FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initLayout() {
        this.container = getContentPane();
        this.setLayout(null);
    }

    private void initElements() {
        JTextField resultField = new JTextField();
        resultField.setFont(new Font("Calibri", Font.PLAIN, 25));
        resultField.setHorizontalAlignment(SwingConstants.RIGHT);
        resultField.setSize(FRAME_WIDTH, 30);
        resultField.setLocation(0, 0);
        container.add(resultField);
    }

    public void open() {
        setVisible(Boolean.TRUE);
    }

}
