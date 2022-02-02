package ru.sfedu.mohnachev.vvid.part2.calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {

    private static final String TITLE = "Калькулятор. КТбз3-4. Мохначев Е.С. Таганрог 2022 г.";

    private static final int FRAME_X_POS = 300;
    private static final int FRAME_Y_POS = 90;
    private static final int FRAME_WIDTH = 450;
    private static final int FRAME_HEIGHT = 600;

    private static final String FONT = "Calibri";

    private static final int RESULT_HEIGHT = 100;
    private static final float RESULT_FONT_SIZE_SCALE = 0.75f;

    private static final float KEYPAD_FONT_SIZE_SCALE = 0.50f;

    private Container container;
    private JTextField resultField;

    public CalculatorFrame() throws HeadlessException {
        initFrame();
        initLayout();
        initHeader();
        initKeypad();
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

    private void initHeader() {
        int btnWidth = (FRAME_WIDTH/4);

        resultField = new JTextField();
        resultField.setFont(new Font(FONT, Font.PLAIN, Math.round(RESULT_HEIGHT*RESULT_FONT_SIZE_SCALE)));
        resultField.setHorizontalAlignment(SwingConstants.RIGHT);
        resultField.setSize(FRAME_WIDTH - btnWidth, RESULT_HEIGHT);
        resultField.setLocation(0, 0);
        resultField.addActionListener(new KeypadActionListener(resultField, "="));
        resultField.addKeyListener(new InputKeyListener(resultField));
        container.add(resultField);

        JButton keyBtn = new JButton("C");
        keyBtn.setFont(new Font(FONT, Font.PLAIN, Math.round(btnWidth * KEYPAD_FONT_SIZE_SCALE)));
        keyBtn.setHorizontalAlignment(SwingConstants.CENTER);
        keyBtn.setSize(btnWidth, RESULT_HEIGHT);
        keyBtn.setLocation(FRAME_WIDTH - btnWidth, 0);
        keyBtn.addActionListener(new KeypadActionListener(resultField, "C"));
        container.add(keyBtn);


    }

    private void initKeypad() {
        String[] keypad = new String[]{
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                ",", "0", "=", "+"
        };

        int btnXPos = 0;
        int btnYPos = RESULT_HEIGHT;
        int btnWidth = (FRAME_WIDTH/4);
        int btnHeight = ((FRAME_HEIGHT-RESULT_HEIGHT)/4) - 7;

        for (String key : keypad) {
            JButton keyBtn = new JButton(key);
            keyBtn.setFont(new Font(FONT, Font.PLAIN, Math.round(btnWidth * KEYPAD_FONT_SIZE_SCALE)));
            keyBtn.setHorizontalAlignment(SwingConstants.CENTER);
            keyBtn.setSize(btnWidth, btnHeight);
            keyBtn.setLocation(btnXPos, btnYPos);
            keyBtn.addActionListener(new KeypadActionListener(resultField, key));
            container.add(keyBtn);

            btnXPos += btnWidth;
            if (FRAME_WIDTH - btnXPos < btnWidth) {
                btnXPos = 0;
                btnYPos += btnHeight;
            }
        }
    }

    public void open() {
        setVisible(Boolean.TRUE);
    }

}
