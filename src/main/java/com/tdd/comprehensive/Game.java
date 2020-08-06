package com.tdd.comprehensive;

class Game {
    private static final String RESULT_CORRECT = "4A0B";
    private static final int MAX_TRY_TIMES = 6;
    private final String gameAnswer;
    private final Comparator comparator;
    private GameStatus gameStatus = GameStatus.CONTINUED;
    private int leftTryTimes = MAX_TRY_TIMES;

    Game(AnswerGenerator answerGenerator) {
        this.gameAnswer = answerGenerator.generate();
        comparator = new Comparator();
    }

    String guess(String userAnswer) {
        String compareResult = comparator.compare(gameAnswer, userAnswer);
        decreaseTryTimes();
        modifyStatus(compareResult);
        return compareResult;
    }

    private void decreaseTryTimes() {
        leftTryTimes --;
    }

    private void modifyStatus(String compareResult) {
        if (compareResult.equals(RESULT_CORRECT)) {
            gameStatus = GameStatus.SUCCEED;
        } else if (leftTryTimes == 0) {
            gameStatus = GameStatus.FAILED;
        }
    }

    GameStatus getStatus() {
        return gameStatus;
    }
}
