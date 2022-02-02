package ru.sfedu.mohnachev.vvid.part2.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeypadActionListener implements ActionListener {
    private CalculatorService calculatorService;
    private String key;

    public KeypadActionListener(CalculatorService calculatorService, String key) {
        this.key = key;
        this.calculatorService = calculatorService;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        calculatorService.typeValue(key);
    }

}
