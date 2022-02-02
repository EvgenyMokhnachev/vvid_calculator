package ru.sfedu.mohnachev.vvid.part2.calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {
    private final StringBuilder resultText = new StringBuilder("");
    private final List<CalculatorChangeResultListener> changeResultListeners = new ArrayList<>();

    public void typeValue(String value) {
        resultText.append(value);
        doChangeResultListeners();
    }

    public void onChangeResultText(CalculatorChangeResultListener listener) {
        changeResultListeners.add(listener);
    }

    private void doChangeResultListeners() {
        for (CalculatorChangeResultListener listener : changeResultListeners) {
            listener.change(resultText.toString());
        }
    }

}
