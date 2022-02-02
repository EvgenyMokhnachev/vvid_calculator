package ru.sfedu.mohnachev.vvid.part2.calculator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputKeyListener implements KeyListener {
    private CalculatorService calculatorService;

    public InputKeyListener(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        calculatorService.typeValue(String.valueOf(keyEvent.getKeyChar()));
        keyEvent.consume();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {}

    @Override
    public void keyReleased(KeyEvent keyEvent) {}

}
