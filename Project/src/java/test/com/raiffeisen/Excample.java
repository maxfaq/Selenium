package com.raiffeisen;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("test 2")
public class Excample {

    private Comparator comparator;
    private GameProcessor game;

    @BeforeAll
        //перед всеми классами выполнится
    void intObjects(){
        comparator=new Comparator();
        game = new GameProcessor();
    }

    @Nested //наследование
    @DisplayName("2")
    public class ChildTest{ //класс внутри класса, используют те же переменные, наследует, если другой ход действий

        @ParameterizedTest
        @ValueSource(ints = {1234, 6274, 5639})//параметры используемые в тесте, тест повторится для каждого значения
        void testCows2(int testAttempt){
            comparator.setTestAttemptValue(testAttempt);
            game.isWin(comparator.sAttemptValue, "4526", comparator);
            Assertions.assertTrue(GameProcessor.cows.contains("2"));
        }
    }
}
