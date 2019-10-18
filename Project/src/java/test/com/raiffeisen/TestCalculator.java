package com.raiffeisen;


import com.raiffeisen.Calculator.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Calendar;

@TestInstance(TestInstance.Lifecycle.PER_METHOD) //PER_CLASS - экземпляр тестового класа создается один раз, PER_METHOD - для каждого класса создатся новый, после выполнения отчистится память.
// чтобы не использовать случайно переменные с предыдущего теста
public class TestCalculator {

    static private Calculator calculator;

    @BeforeAll //перед всеми классами выполнится
    static void before(){
        calculator =new Calculator();
    }

    @ParameterizedTest
    @CsvSource({"1,2,3", "75,90,165"})
    void testSum (int num1, int num2, int result){
        Assertions.assertEquals(calculator.sum(num1,num2),result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testNumber.csv")
    void testMinus(int num1, int num2, int result){
        Assertions.assertEquals(calculator.minus(num1,num2), result);
    }

    @ParameterizedTest
    @EnumSource(value = ENumber.class, names = {"data1", "data2"})
    void testDivide(ENumber en){
        Assertions.assertEquals(calculator.divide(en.num1, en.num2), en.result);
    }

    @ParameterizedTest
    @CsvSource({"6,2,12", "100,2,200"})
    void testMultiply(int num1, int num2, int result){
        Assertions.assertEquals(calculator.multiply(num1, num2), result);
    }

    @ParameterizedTest
    @CsvSource({"25,5", "1.2,1.0954451150103321"})
    void testSquareRoot(double num, double result){
        Assertions.assertEquals(calculator.squareRoot(num), result);
    }

}
