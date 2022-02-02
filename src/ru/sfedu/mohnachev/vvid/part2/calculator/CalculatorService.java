package ru.sfedu.mohnachev.vvid.part2.calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {
    private final StringBuilder resultText = new StringBuilder("");
    private final List<CalculatorChangeResultListener> changeResultListeners = new ArrayList<>();

    private String[] typeChars = new String[]{
            "7", "8", "9",
            "4", "5", "6",
            "1", "2", "3",
            ",", "0", "."
    };

    private String[] systemChars = new String[]{
            "/", "*", "-", "=", "+", "C", "c", ""
    };

    public void onChangeResultText(CalculatorChangeResultListener listener) {
        changeResultListeners.add(listener);
    }

    private void doChangeResultListeners() {
        for (CalculatorChangeResultListener listener : changeResultListeners) {
            listener.change(resultText.toString());
        }
    }

    public void typeValue(String value) {
        for (String allowedChar : typeChars) {
            if (allowedChar.equals(value)) {
                processTypeValue(value);
            }
        }

        for (String allowedChar : systemChars) {
            if (allowedChar.equals(value)) {
                processManageValue(value);
            }
        }
        doChangeResultListeners();
    }

    private void processTypeValue(String value) {
        if (value.equals(".")) value = ",";
        if (value.equals(",")) {
            if (resultText.length() == 0) {
                resultText.append("0");
            }
            if (resultText.toString().contains(",")) {
                return;
            }
        }

        resultText.append(value);

        if (resultText.toString().equals("0")) {
            resultText.append(",");
        }
    }

    private void processManageValue(String value) {
        switch (value) {
            case "c":;
            case "C": clean(); break;
            case "": cleanLastValue(); break;
        }
    }

    private void clean() {
        if (resultText.length() > 0) {
            resultText.delete(0, resultText.length());
        }
    }

    private void cleanLastValue() {
        if (resultText.length() > 0) {
            resultText.delete(resultText.length() - 1, resultText.length());
        }
    }

}
