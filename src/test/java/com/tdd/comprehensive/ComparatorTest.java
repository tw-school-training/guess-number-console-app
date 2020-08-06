package com.tdd.comprehensive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparatorTest {
    @Test
    public void should_return_4A0B_given_two_same_numbers() {
        verifyCompareResult("1234", "1234", "4A0B");
    }

    @Test
    public void should_return_2A2B_given_two_numbers_with_all_number_correct_and_partial_position_correct() {
        verifyCompareResult("1234", "1243", "2A2B");
    }

    @Test
    public void should_return_1A1B_given_two_numbers_with_partial_number_correct_and_partial_position_correct() {
        verifyCompareResult("1234", "1563", "1A1B");
    }

    @Test
    public void should_return_0A4B_given_two_numbers_with_all_number_correct_and_no_position_correct() {
        verifyCompareResult("1234", "4321", "0A4B");
    }

    @Test
    public void should_return_0A2B_given_two_numbers_with_partial_number_correct_and_no_position_correct() {
        verifyCompareResult("1234", "3456", "0A2B");
    }

    @Test
    public void should_return_0A0B_given_two_numbers_with_no_number_correct_and_no_position_correct() {
        verifyCompareResult("1234", "5678", "0A0B");
    }

    private void verifyCompareResult(String gameAnswer, String userAnswer, String compareResult) {
        //given
        Comparator comparator = new Comparator();

        //when
        String result = comparator.compare(gameAnswer, userAnswer);

        //then
        assertEquals(compareResult, result);
    }
}
