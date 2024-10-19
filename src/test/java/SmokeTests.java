import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmokeTests {

    WebDriver driver;

    private static final String HOME_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeEach
    void start() throws InterruptedException {
        //arrange
        driver = new ChromeDriver();
        driver.get(HOME_URL);
        Thread.sleep(1000);
    }

    @AfterEach
    void tearDown() {
        //post operations
        driver.quit();
    }

    @Test
    void openSiteTest() throws InterruptedException {
        //Assert
        Assertions.assertEquals(HOME_URL, driver.getCurrentUrl());
    }

    @Test
    void openWebFormTest() throws InterruptedException {
        WebElement webform = driver.findElement(By.xpath("//a[@href='web-form.html']"));
        webform.click();
        Thread.sleep(1000);

        Assertions.assertEquals(HOME_URL + "web-form.html", driver.getCurrentUrl());
    }
}
