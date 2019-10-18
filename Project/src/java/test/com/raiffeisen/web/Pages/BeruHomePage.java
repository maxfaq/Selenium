package com.raiffeisen.web.Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/*
//чтобы подрубить сюда настройки драйвера, можно наследовать класс где лежит инициализация веб драйвера
public class BeruHomePage extends com.raiffeisen.web.driver {
    private WebElement searchField = driver.findElements(By.name("text")).get(1);
    private WebElement findButton =  driver.findElement(By.xpath("//button/span[text()='Найти']"));

    public void checkPageOpen(){
        Assertions.assertTrue(searchField.isDisplayed());
        Assertions.assertTrue(findButton.isDisplayed());
    }

    public void searchFor (String text){
        searchField.sendKeys(text);
        findButton.click();
    }
}*/

//чтобы подрубить сюда настройки драйвера, можно использовать контруктор
public class BeruHomePage {
    WebDriver webDriver;

    public BeruHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    //вариант написания путей
    //private WebElement searchField = driver.findElements(By.name("text")).get(1);
    //By searchField = By.name("text");//ообъект типа by
    @FindBy(name = "text")
    private List<WebElement> searchField;

   // private WebElement findButton =  driver.findElement(By.xpath("//button/span[text()='Найти']"));
    @FindBy(xpath = "//button/span[text()='Найти']")
    private WebElement findButton;

    @FindAll() //ищет элементы по 2 условиям через И

    public void checkPageOpen(){
        Assertions.assertTrue(searchField.get(1).isDisplayed());
        Assertions.assertTrue(findButton.isDisplayed());
    }

    public void searchFor (String text){
        searchField.sendKeys(text);
        findButton.click();
    }


}
