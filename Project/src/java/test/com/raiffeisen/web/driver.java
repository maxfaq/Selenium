package com.raiffeisen.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class driver {

    public static WebDriver driver;

    static void createDriver(){
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe"); //указали где лежит драйвер
        driver = new ChromeDriver();
        driver.manage().window().maximize();//развернуть на весь экран
        //еще плюшки https://chromedriver.chromium.org/capabilities
        ChromeOptions options = new ChromeOptions();
        //ожидания
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS); //на каждую операцию
        //driver.wait(5000); //нужно бросить эксепшн
        //Thead.sleep(300); //нужно бросить эксепшн
        options.setHeadless(false); //скрывает браузер
        driver.get("https://beru.ru/"); //переход на нужный урл
    }

    static void closeDriver(){
        driver.close(); //закрывает вкладку последнюю
    }


}
