package com.tdd.comprehensive;

import java.util.Arrays;
import java.util.List;

class Comparator {
    private int countOfNumberCorrectAndPositionCorrect;
    private int countOfNumberCorrectAndPositionIncorrect;

    String compare(String gameAnswer, String userAnswer) {
        countNumberCorrectAndPositionCorrect(gameAnswer, userAnswer);

        return formatResult();
    }

    private void countNumberCorrectAndPositionCorrect(String gameAnswer, String userAnswer) {
        List<String> splitGameAnswer = Arrays.asList(gameAnswer.split(""));
        List<String> splitUserAnswer = Arrays.asList(userAnswer.split(""));

        for (int index = 0; index < splitGameAnswer.size(); index++) {
            if (splitGameAnswer.get(index).equals(splitUserAnswer.get(index))) {
                countOfNumberCorrectAndPositionCorrect++;
            } else if (splitUserAnswer.contains(splitGameAnswer.get(index))) {
                countOfNumberCorrectAndPositionIncorrect++;
            }
        }
    }

    private String formatResult() {
        return String.format("%sA%sB", countOfNumberCorrectAndPositionCorrect, countOfNumberCorrectAndPositionIncorrect);
    }
}
