package com.globant.counter.android.mvp.model;

import com.globant.counter.android.mvp.constants.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CountModel {

    public double execute(String formula) {
        float value = 0;
        if (formula == null || !formula.endsWith("=")) {
            return value;
        }
        formula = formula.replaceAll("=", "");
        String action = getAction(formula);
        List<String> list = Arrays.asList(formula.split("[+-/*]"));
        value = Float.parseFloat(list.get(0));
        for(int i=1; i<list.size(); i++){
            String number = list.get(i);
            switch (action){
                case Constants.PLUS:
                    value = value + Float.parseFloat(number);
                    break;
                case Constants.TIMES:
                    value = value * Float.parseFloat(number);
                    break;
                case Constants.DIVIDED:
                    value = value / Float.parseFloat(number);
                    break;
                case Constants.MINUS:
                    value = value - Float.parseFloat(number);
                    break;
            }
        }
        return value;
    }

    private String getAction(String string) {
        int index = string.indexOf(Constants.PLUS);
        if (index != -1) {
            return Constants.PLUS;
        }
        index = string.indexOf(Constants.MINUS);
        if (index != -1) {
            return Constants.MINUS;
        }
        index = string.indexOf(Constants.TIMES);
        if (index != -1) {
            return Constants.TIMES;
        }
        index = string.indexOf(Constants.DIVIDED);
        if (index != -1) {
            return Constants.DIVIDED;
        }
        return "";
    }
}
