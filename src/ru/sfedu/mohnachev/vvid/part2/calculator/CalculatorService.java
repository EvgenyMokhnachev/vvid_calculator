package ru.sfedu.mohnachev.vvid.part2.calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {
    private final StringBuilder resultText = new StringBuilder("");
    private final List<CalculatorChangeResultListener> changeResultListeners = new ArrayList<>();

    public void onChangeResultText(CalculatorChangeResultListener listener) {
        changeResultListeners.add(listener);
    }

    private void doChangeResultListeners() {
        for (CalculatorChangeResultListener listener : changeResultListeners) {
            listener.change(resultText.toString());
        }
    }

    public void typeValue(String value) {
        if (validateTypedValue(value)) {
            resultText.append(value);
        }
        doChangeResultListeners();
    }

    private String[] typeChars = new String[]{
            "7", "8", "9",
            "4", "5", "6",
            "1", "2", "3",
            ",", "0", "."
    };
    private String[] systemChars = new String[]{
            "/", "*", "-", "=", "+", "C", "c", ""
    };

    private boolean validateTypedValue(String value) {
        for (String allowedChar : typeChars) {
            if (allowedChar.equals(value)) {
                return true;
            }
        }
        for (String allowedChar : systemChars) {
            if (allowedChar.equals(value)) {
                return true;
            }
        }
        return false;
    }

}
