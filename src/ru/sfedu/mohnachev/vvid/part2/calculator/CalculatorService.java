package ru.sfedu.mohnachev.vvid.part2.calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {
    private final StringBuilder resultText = new StringBuilder("");
    private final List<CalculatorChangeResultListener> changeResultListeners = new ArrayList<>();
    private final List<CalculatorOperationChangeListener> changeOperationListeners = new ArrayList<>();

    private Double previousValue = null;
    private String previousOperation = null;
    private Boolean cleanOnType = false;

    private String[] typeChars = new String[]{
            "7", "8", "9",
            "4", "5", "6",
            "1", "2", "3",
            ",", "0", "."
    };

    private String[] systemChars = new String[]{
            "/", "*", "-", "=", "+",
            "C", "c", ""
    };

    public void onChangeResultText(CalculatorChangeResultListener listener) {
        changeResultListeners.add(listener);
    }

    public void onChangeOperation(CalculatorOperationChangeListener listener) {
        changeOperationListeners.add(listener);
    }

    private void doChangeResultListeners() {
        for (CalculatorChangeResultListener listener : changeResultListeners) {
            listener.change(resultText.toString());
        }
    }

    private void doChangeOperationListeners() {
        for (CalculatorOperationChangeListener listener : changeOperationListeners) {
            listener.change(previousOperation);
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
        if (cleanOnType) {
            cleanTypedValue();
            cleanOnType = false;
        }

        if (value.equals(",")) {
            value = ".";
        }

        if (value.equals(".")) {
            if (resultText.length() == 0) {
                resultText.append("0");
            }

            if (resultText.toString().contains(".")) {
                return;
            }
        }

        resultText.append(value);

        if (resultText.toString().equals("0")) {
            resultText.append(".");
        }
    }

    private void processManageValue(String value) {
        switch (value) {
            case "c":;
            case "C": clean(); break;
            case "": cleanLastValue(); break;
            case "/":
            case "*":
            case "-":
            case "=":
            case "+": processMathOperation(value); break;
        }
    }

    private void clean() {
        cleanTypedValue();
        this.previousValue = null;
        this.previousOperation = null;
        doChangeOperationListeners();
    }

    private void cleanLastValue() {
        if (resultText.length() > 0) {
            resultText.delete(resultText.length() - 1, resultText.length());
        }
    }

    private void cleanTypedValue() {
        if (resultText.length() > 0) {
            resultText.delete(0, resultText.length());
        }
    }

    private void cleanOnType() {
        cleanOnType = true;
    }

    private void drawResult(Double result) {
        String resultString = String.valueOf(result.floatValue());
        if (resultString.length() > 2 && resultString.substring(resultString.length() - 2).equals(".0")) {
            resultString = resultString.substring(0, resultString.length() - 2);
        }
        cleanTypedValue();
        resultText.append(resultString);
    }

    private Double calculateMathOperation(Double first, Double second, String operation) {
        switch (operation) {
            case "/": return first / second;
            case "*": return first * second;
            case "-": return first - second;
            case "+": return first + second;
        }
        return null;
    }

    private Double getTypedValue() {
        try {
            return Double.valueOf(String.valueOf(resultText));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void processMathOperation(String currentOperation) {
        Double currentValue = getTypedValue();

        if (currentOperation.equals("=") && previousValue != null && previousOperation != null) {
            Double resultValue = calculateMathOperation(previousValue, currentValue, previousOperation);
            clean();
            drawResult(resultValue);
            cleanOnType();
            return;
        }

        previousValue = currentValue;
        if (!currentOperation.equals("=")) {
            previousOperation = currentOperation;
            doChangeOperationListeners();
        } else {
            previousOperation = null;
            doChangeOperationListeners();
        }
        cleanOnType();
    }

}
