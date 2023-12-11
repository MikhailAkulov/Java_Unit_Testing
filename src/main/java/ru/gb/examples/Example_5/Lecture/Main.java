package main.java.ru.gb.examples.Example_5.Lecture;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/Akuloff/Desktop/Geek_Brains/3_Extra_courses/005_Unit-tests/JavaUnitTesting/src/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("GeekBrains");
        searchBox.submit();
    }
}
