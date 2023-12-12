package main.java.ru.gb.examples.Example_5.Seminar;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumTest {
    /**
     * 5.4. Напишите автоматизированный тест, который выполнит следующие шаги:
     * 1. Открывает главную страницу Google.
     * 2. Вводит "Selenium" в поисковую строку и нажимает кнопку "Поиск в Google".
     * 3. В результатах поиска ищет ссылку на официальный сайт Selenium (https://www.selenium.dev) и проверяет,
     * что ссылка действительно присутствует среди результатов поиска.
     */
    @Test
    void testOpenSeleniumSite() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://www.google.com/");
        WebElement webElement = webDriver.findElement(By.name("q"));
        webElement.sendKeys("Selenium");
        webElement.submit();
        webElement = webDriver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/div/div/div/cite"));
        assertThat(webElement.getText()).isEqualTo("https://www.selenium.dev");
        webDriver.quit();
    }

    /**
     * 5.5. Нужно написать сквозной тест с использованием Selenium,
     * который авторизует пользователя на сайте https://www.saucedemo.com/.
     * Данные для входа - логин: "standard_user", пароль: "secret_sauce".
     * Проверить, что авторизация прошла успешно и отображаются товары.
     * Вам необходимо использовать WebDriver для открытия страницы и методы sendKeys() для ввода
     * данных в поля формы, и submit() для отправки формы. После этого, проверьте, что на странице
     * отображаются продукты (productsLabel.getText() = "Products").
     */
    @Test
    void endToEndTest() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com/");
        WebElement webElementLogin = webDriver.findElement(By.id("user-name"));
        webElementLogin.sendKeys("standard_user");
        WebElement webElementPassword = webDriver.findElement(By.id("password"));
        webElementPassword.sendKeys("secret_sauce");
        webElementPassword.submit();
        WebElement webElementProducts = webDriver.findElement(By.className("title"));
        assertThat(webElementProducts.getText()).isEqualTo("Products");
        Thread.sleep(5000);
        webDriver.quit();
    }
}
