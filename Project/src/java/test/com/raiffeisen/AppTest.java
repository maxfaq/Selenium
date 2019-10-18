package com.raiffeisen;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static com.raiffeisen.HasInside.hasCowInside;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

@TestInstance(TestInstance.Lifecycle.PER_METHOD) //PER_CLASS - экземпляр тестового класа создается один раз, PER_METHOD - для каждого класса создатся новый, после выполнения отчистится память.
// чтобы не использовать случайно переменные с предыдущего теста
public class AppTest {

    private String testString;
    static private Comparator comparator;
    static private GameProcessor game;

    @BeforeAll //перед всеми классами выполнится один раз
    //@BeforeEach// перед каждым тестом выполнится
    static void intObjects(){
        comparator=new Comparator();
        game = new GameProcessor();
    }

    @Test //просто запуск
    @RepeatedTest(2) //задает количество повторов теста, удобно когда на рандомных данных
    public void myFirstTest (){
        testString="bulls and cows";
        Assertions.assertTrue (testString.contains(" "),"пояснение, что проверяем, не обязательное");
    }

    //unit test
    @Test
    @DisplayName("Понятное название теста") //задает название теста
    @Disabled //не запускается тест
    void test4digits(){
        Assertions.assertEquals(new Hider().generator().length(), 4);
    }

    @Test
    void testCows(){
        comparator.setTestAttemptValue(1234);
        game.isWin(comparator.sAttemptValue, "4526", comparator);
        Assertions.assertTrue(GameProcessor.cows.contains("2"));
    }

    @ParameterizedTest
    @ValueSource(ints = {1234, 6274, 5639})//параметры используемые в тесте, тест повторится для каждого значения
    void testCows2(int testAttempt){
        comparator.setTestAttemptValue(testAttempt);
        game.isWin(comparator.sAttemptValue, "4526", comparator);
        Assertions.assertTrue(GameProcessor.cows.contains("2"));
    }

    @ParameterizedTest
    @CsvSource(value = {"1234,4526,2", "5639,4526,2", "6274,2639,2"}, delimiter = ',')//принимает значения и разделитель. массив строковых значений. тест повторится для каждой пары значений
    void testCows3(int testAttempt, String hidden, String expected){
        comparator.setTestAttemptValue(testAttempt);
        game.isWin(comparator.sAttemptValue, hidden, comparator);
        Assertions.assertTrue(GameProcessor.cows.contains(expected));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", delimiter = ';', numLinesToSkip = 2)//принимает файл с значениями, разделитель, строку с которой читать. тест повторится для каждой пары значений
    void testCows4(int testAttempt, String hidden, String expected){
        comparator.setTestAttemptValue(testAttempt);
        game.isWin(comparator.sAttemptValue, hidden, comparator);
        Assertions.assertTrue(GameProcessor.cows.contains(expected));
    }

    @ParameterizedTest
    @EnumSource(value = EData.class, names = {"data1", "data2"}) //передаем класс с енамом и параметры какие нужны, можно не все
    void testCows5(EData dt){
        comparator.setTestAttemptValue(dt.getAtt());
        game.isWin(comparator.sAttemptValue, dt.getHid(), comparator);
        Assertions.assertTrue(GameProcessor.cows.contains(dt.getExp()));
        //такое же как и ассерт тру, мсодержит много матчеров, читаемо
        assertThat(GameProcessor.cows, containsString("2")); //утверждение, матчер гуглим hamcrest Matcher (пример equalTo
        assertThat(game.cows, hasCowInside()); ///можно написать свой метод сравнения, смотри класс HasInside
    }

    @ParameterizedTest
    @EnumSource(value = EDataTest.class, names = {"data1", "data2", "data3"})
    void test(EDataTest edt){
        System.out.println(edt.getAtt());
        System.out.println(edt.getHid());
        Assertions.assertTrue(GameProcessor.isWin(edt.getAtt(),edt.getHid(), comparator));
    }

    @Test
    void testCows7(){
        comparator.setTestAttemptValue(1234);
        game.isWin(comparator.sAttemptValue, "4526", comparator);
        Assertions.assertAll(
                ()->Assertions.assertTrue(GameProcessor.cows.contains("2")), //множественные сравнения
                ()->Assertions.assertTrue("1234".contains("44"), "сообщение в лог если не assert")
        );

    }


    @ParameterizedTest
    @EnumSource(value = EData.class, names = {"data1", "data2"}) //передаем класс с енамом и параметры какие нужны, можно не все
    void testCows9(EData dt){
        Assumptions.assumeTrue("Windows 10".contains("windows")); //не сработал если, то дальше не идем, не запускаем вообще дальше тесты
        comparator.setTestAttemptValue(dt.getAtt());
        game.isWin(comparator.sAttemptValue, dt.getHid(), comparator);
        Assertions.assertTrue(GameProcessor.cows.contains(dt.getExp()));
    }

    //динамические тесты,
   /* @TestFactory
    Iterable<DinamicTest>  dinamicTestIterable(){
        return Arrays.asList(
                dinamicTestIterable("1 dinam test", ()-> assertThat("Bulshit")) // assertThat -
        );
    }*/
}
