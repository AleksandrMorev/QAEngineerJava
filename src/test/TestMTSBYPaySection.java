import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class TestMTSBYPaySection {

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

    @ParameterizedTest
    @DisplayName("Проверка надписей в незаполненных полях формы оплаты")
    @CsvSource({"connection-phone, Номер телефона",
            "connection-sum, Сумма",
            "connection-email, E-mail для отправки чека",
            "internet-phone, Номер абонента",
            "internet-sum, Сумма",
            "internet-email, E-mail для отправки чека",
            "score-instalment,Номер счета на 44",
            "instalment-sum, Сумма",
            "instalment-email, E-mail для отправки чека",
            "score-arrears,Номер счета на 2073",
            "arrears-sum, Сумма",
            "arrears-email, E-mail для отправки чека",
    })
    void testPayPlaceholdersDisplayed(String fieldId, String placeholderText) {
        assertEquals(placeholderText, driver.findElement(By.id(fieldId)).getAttribute("placeholder"));
    }

    @ParameterizedTest
    @DisplayName("Проверка надписей и иконок в окне оплаты при попытке оплаты 100.00 рублей на номер 297777777")
    @CsvSource({"297777777, 100.00"})
    void testPayServiceCardInputFields(String payPhoneNumber, String payAmount) {
        WebElement payPhoneInputField = driver.findElement(By.id("connection-phone"));
        payPhoneInputField.click();
        payPhoneInputField.sendKeys(payPhoneNumber);
        WebElement paySumInputField = driver.findElement(By.id("connection-sum"));
        paySumInputField.click();
        paySumInputField.sendKeys(payAmount);
        driver.findElement(By.xpath("//section[@class=\"pay\"]//button[@type=\"submit\"]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.className("pay-description__cost")));
        assertAll(
                () -> assertEquals(payAmount + " BYN", driver.findElement(By.className("pay-description__cost")).getText()),
                () -> assertTrue(driver.findElement(By.className("pay-description__text")).getText().contains("375" + payPhoneNumber)),
                () -> assertEquals("Оплатить " + payAmount + " BYN", driver.findElement(By.xpath("//button[@type=\"submit\"]")).getText()),
                () -> assertTrue(driver.findElement(By.xpath("//img[@src=\"assets/images/payment-icons/card-types/mastercard-system.svg\"]")).isDisplayed()),
                () -> assertTrue(driver.findElement(By.xpath("//img[@src=\"assets/images/payment-icons/card-types/visa-system.svg\"]")).isDisplayed()),
                () -> assertTrue(driver.findElement(By.xpath("//img[@src=\"assets/images/payment-icons/card-types/belkart-system.svg\"]")).isDisplayed()),
                () -> assertTrue(driver.findElement(By.xpath("//img[@src=\"assets/images/payment-icons/card-types/belkart-system.svg\"]/following::div/img[1]")).isDisplayed() | driver.findElement(By.xpath("//img[@src=\"assets/images/payment-icons/card-types/belkart-system.svg\"]/following::div/img[2]")).isDisplayed()),
                () -> assertEquals("Номер карты", driver.findElement(By.xpath("//input[@formcontrolname = \"creditCard\"]/following::label")).getText()),
                () -> assertEquals("Срок действия", driver.findElement(By.xpath("//input[@formcontrolname = \"expirationDate\"]/following::label")).getText()),
                () -> assertEquals("CVC", driver.findElement(By.xpath("//input[@formcontrolname = \"cvc\"]/following::label")).getText()),
                () -> assertEquals("Имя держателя (как на карте)", driver.findElement(By.xpath("//input[@formcontrolname = \"holder\"]/following::label")).getText())
        );
    }
}
