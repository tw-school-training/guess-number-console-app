package com.tdd.comprehensive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class AnswerGenerator {
    private int ANSWER_LENGTH = 4;

    String generate() {
        List<String> result = new ArrayList<>(ANSWER_LENGTH);
        List<Integer> digitsList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        Collections.shuffle(digitsList);

        for (int index = 0; index < ANSWER_LENGTH; index++) {
            result.add(digitsList.get(index).toString());
        }

        return format(result);
    }

    private String format(List<String> result) {
        return String.join("", result);
    }
}
