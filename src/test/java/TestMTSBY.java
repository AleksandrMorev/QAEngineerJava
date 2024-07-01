import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class TestMTSBY {

    WebDriver driver;

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://mts.by");
    }

    @BeforeEach
    public void cookieBuster() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            driver.findElement(By.id("cookie-agree")).click();
        } catch (TimeoutException ignored) {
        }
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка названия блока «Онлайн пополнение без комиссии»")
    void testOnlinePaymentSectionHeader() {
        assertEquals("Онлайн пополнение\nбез комиссии", driver.findElement(By.xpath("//section[@class=\"pay\"]//h2")).getText());
    }

    @Test
    @DisplayName("Проверка наличия логотипов платёжных систем")
    void testPaymentPartnerIconsDisplayed() {
        assertAll(
                () -> assertTrue(driver.findElement(By.xpath("//section[@class=\"pay\"]//img[@alt=\"Visa\"]")).isDisplayed()),
                () -> assertTrue(driver.findElement(By.xpath("//section[@class=\"pay\"]//img[@alt=\"Verified By Visa\"]")).isDisplayed()),
                () -> assertTrue(driver.findElement(By.xpath("//section[@class=\"pay\"]//img[@alt=\"MasterCard\"]")).isDisplayed()),
                () -> assertTrue(driver.findElement(By.xpath("//section[@class=\"pay\"]//img[@alt=\"MasterCard Secure Code\"]")).isDisplayed()),
                () -> assertTrue(driver.findElement(By.xpath("//section[@class=\"pay\"]//img[@alt=\"Белкарт\"]")).isDisplayed())
        );
    }

    @Test
    @DisplayName("Проверка работы ссылки «Подробнее о сервисе»")
    void testPayServiceDetailsLink() {
        String payServiceDetailsLinkText = driver.findElement(By.xpath("//section[@class=\"pay\"]//a[text()=\"Подробнее о сервисе\"]")).getAttribute("href");
        try {
            HttpURLConnection con = (HttpURLConnection) (new URL(payServiceDetailsLinkText).openConnection());
            con.setRequestMethod("GET");
            con.connect();
            assertTrue(payServiceDetailsLinkText.equals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/") & con.getResponseCode() < 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @ParameterizedTest
    @DisplayName("Проверка работы кнопки «Продолжить»")
    @CsvSource({"297777777,100.00"})
    void testPayServiceContinueButton(String payPhone, String paySum) {
        WebElement payPhoneInputField = driver.findElement(By.id("connection-phone"));
        payPhoneInputField.click();
        payPhoneInputField.sendKeys(payPhone);
        WebElement paySumInputField = driver.findElement(By.id("connection-sum"));
        paySumInputField.click();
        paySumInputField.sendKeys(paySum);
        driver.findElement(By.xpath("//section[@class=\"pay\"]//button[@type=\"submit\"]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.className("pay-description__cost")));
        assertTrue(driver.findElement(By.className("pay-description__cost")).getText().equals(paySum + " BYN") &
                driver.findElement(By.className("pay-description__text")).getText().contains("375" + payPhone));
    }

}
