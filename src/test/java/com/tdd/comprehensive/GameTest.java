package com.tdd.comprehensive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    private Game game;

    @BeforeEach
    public void setUp() {
        //given
        AnswerGenerator mockAnswerGenerator = Mockito.mock(AnswerGenerator.class);
        BDDMockito.given(mockAnswerGenerator.generate()).willReturn("1234");
        game = new Game(mockAnswerGenerator);
    }

    @Test
    public void should_return_xAxB_when_guess_given_user_answer() {
        //when
        String actualResult = game.guess("1234");

        //then
        assertEquals("4A0B", actualResult);
    }

    @Test
    public void should_return_succeed_when_get_status_after_input_1234_given_game_with_answer_1234() {
        //when
        game.guess("1234");
        GameStatus gameStatus = game.getStatus();

        //then
        assertEquals(GameStatus.SUCCEED, gameStatus);
    }

    @Test
    public void should_return_continued_when_get_status_after_input_1256_given_game_with_answer_1234() {
        //when
        game.guess("1 2 5 6");

        GameStatus gameStatus = game.getStatus();

        //then
        assertEquals(GameStatus.CONTINUED, gameStatus);
    }

    @Test
    public void should_return_failed_when_get_status_after_input_1256_6_times_given_game_with_answer_1234() {
        //when
        game.guess("1 2 5 6");
        game.guess("1 2 5 6");
        game.guess("1 2 5 6");
        game.guess("1 2 5 6");
        game.guess("1 2 5 6");
        game.guess("1 2 5 6");

        GameStatus gameStatus = game.getStatus();

        //then
        assertEquals(GameStatus.FAILED, gameStatus);
    }
}
