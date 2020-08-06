package com.tdd.comprehensive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnswerGeneratorTest {
    private String result;
    private int ANSWER_LENGTH = 4;

    @BeforeEach
    void setUp() {
        //given
        AnswerGenerator answerGenerator = new AnswerGenerator();

        //when
        result = answerGenerator.generate();
    }

    @Test
    public void should_generate_answer_with_size_4() {
        //then
        assertEquals(ANSWER_LENGTH, result.length());
    }

    @Test
    public void should_generate_answer_with_4_digits() {
        //then
        assertTrue(areDigits(result));
    }

    @Test
    public void should_generate_answer_with_4_different_digits() {
        //then
        assertTrue(hasNoRepeatDigits(result));
    }

    private boolean hasNoRepeatDigits(String result) {
        List<String> splitResult = Arrays.asList(result.split(""));
        Set<String> setResult = new HashSet<>(splitResult);

        return setResult.size() == ANSWER_LENGTH;
    }

    private boolean areDigits(String result) {
        String digitRegex = "[0-9]+";
        return result.matches(digitRegex);
    }
}
