package com.tdd.comprehensive;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Matchers.startsWith;
import static org.mockito.Mockito.*;

public class GameConsoleAppTest {
    private PrintStream mockPrintStream;

    @Test
    public void should_output_guess_start_message_when_start_game_given_console_input_output() throws IOException {
        //given
        GameConsoleApp gameConsoleApp = buildGameConsoleApp("1235");

        //when
        gameConsoleApp.start();

        //then
        verify(mockPrintStream).println(startsWith("Please guess number:"));
    }

    @Test
    public void should_output_guess_result_message_when_start_game_and_guess_number_given_console_input_output() throws IOException {
        //given
        GameConsoleApp gameConsoleApp = buildGameConsoleApp("1235");

        //when
        gameConsoleApp.start();

        //then
        verify(mockPrintStream, times(6)).println(contains("guess result:"));
    }

    @Test
    public void should_output_success_message_when_start_game_and_guess_number_correct_given_console_input_output() throws IOException {
        //given
        GameConsoleApp gameConsoleApp = buildGameConsoleApp("1234");

        //when
        gameConsoleApp.start();

        //then
        verify(mockPrintStream).println(contains("Congratulations, you succeed!"));
    }

    @Test
    public void should_output_failed_message_when_start_game_and_guess_number_wrong_6_times_given_console_input_output() throws IOException {
        //given
        GameConsoleApp gameConsoleApp = buildGameConsoleApp("1235");

        //when
        gameConsoleApp.start();

        //then
        verify(mockPrintStream).println(contains("Sorry, you failed!"));
    }

    private GameConsoleApp buildGameConsoleApp(String userAnswer) throws IOException {
        String gameAnswer = "1234";
        mockPrintStream = mock(PrintStream.class);
        AnswerGenerator mockAnswerGenerator = mock(AnswerGenerator.class);
        BufferedReader mockBufferedReader = mock(BufferedReader.class);

        BDDMockito.given(mockAnswerGenerator.generate()).willReturn(gameAnswer);
        BDDMockito.given(mockBufferedReader.readLine()).willReturn(userAnswer);

        return new GameConsoleApp(mockBufferedReader, mockPrintStream, mockAnswerGenerator);
    }
}
