package com.raiffeisen.web;

import com.raiffeisen.web.Pages.BeruHomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

import static org.hamcrest.MatcherAssert.assertThat;

public class FirstWebTest {

    //static WebDriver driver;

    @BeforeAll
    static void beforeAll(){
        driver.createDriver();
        //вынесли в отдельный класс

        /*System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe"); //указали где лежит драйвер
        driver = new ChromeDriver();
        driver.get("https://beru.ru/"); //переход на нужный урл*/
    }

    @Test
    void checkPageOpened(){
        //driver.navigate().to(); //или так переход на нужный урл
        WebElement searchField = driver.driver.findElements(By.name("text")).get(1);
        //WebElement searchField = driver.findElement(By.name("text")).get(1).sendKey("заполняет нужный текст в поле"); //принимает экземпляр класса By - который оперделяет локатор. Самый удобный локатор это id, но бывают генеренные. далее тогда лучше By.name, если он уникален
        //ClassName если уникален. Проверять один он или нет в консоле брайзера inspect($".имя класса"). Или контрл F
        //By.tagName -по имени тега
        //driver.findElement(By.tagName("").findElement(By.name("aa")));//вложеный
        //driver.findElement(By.linkText(""));//ищет по тексту на браузере, например "Я хочу купить ..."
        //https://jazzteam.org/ru/profitable/xpath-manual/
        WebElement findButton =  driver.driver.findElement(By.xpath("//button/span[text()='Найти']")); //возвращает веб элемент
        Assertions.assertTrue(searchField.isDisplayed());//вернул 2 элемента, нам нужен 1 используем  get(1), но для этого вызываем findElements - типо множество , sendKey("заполняет нужный текст в поле");
        // driver.findElements(By.name("text")).get(1).sendKey("заполняет нужный текст в поле");
        Assertions.assertTrue(findButton.isDisplayed());
    }




    BeruHomePage beruHomePage = new BeruHomePage(); //можно в before унести


    @Test //тест по ооп вынесли все в BeruHomePage
    void checkPageOpened2(){
        beruHomePage.checkPageOpen();
        beruHomePage.searchFor("text in field");
    }

    @AfterAll
    static void afterAll(){
        //вынесли в отдельный класс
        driver.closeDriver();
        //driver.close(); //закрывает вкладку последнюю
    }
}
