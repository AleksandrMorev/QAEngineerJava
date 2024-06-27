import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestMTSBY {

    WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
    }
    @BeforeEach
    void cookieBuster() throws InterruptedException {
        driver.get("https://mts.by");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
        driver.findElement(By.id("cookie-agree")).click();
    }
    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void testOnlinePaymentName() {
        // Your test logic here
    }


}
