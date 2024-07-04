import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

@Test(description = "Тестирование формы оплаты на главной странице и окна оплаты")
public class TestMTSBYPayFrame extends Assert {

    WebDriver driver;

    @BeforeClass
    public void setupAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            driver.findElement(By.id("cookie-agree")).click();
        } catch (TimeoutException ignored) {
        }
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    @Test(dataProvider = "MainPagePaySectionPlaceholdersForIds",
            dataProviderClass = TestMTSBYPayFrameData.class,
            description = "Проверка надписей в незаполненных полях формы оплаты на главной странице",
            groups = "Pay_section")
    public void testPaySectionPlaceholdersDisplayed(String fieldId, String placeholderText) {
        assertEquals(placeholderText, driver.findElement(By.id(fieldId)).getAttribute("placeholder"));
    }

    @Test(dataProvider = "PhoneAndSumForPayFrameTextFieldsTest",
            dataProviderClass = TestMTSBYPayFrameData.class,
            description = "Проверка номера телефона и суммы в окне оплаты",
            groups = "Pay_frame",
            priority = 1)
    public void testPayFramePhoneAndSum(String payPhoneNumber, String paySum) {
        WebElement payPhoneInputField = driver.findElement(By.id("connection-phone"));
        payPhoneInputField.click();
        payPhoneInputField.sendKeys(payPhoneNumber);
        WebElement paySumInputField = driver.findElement(By.id("connection-sum"));
        paySumInputField.click();
        paySumInputField.sendKeys(paySum);
        driver.findElement(By.xpath("//section[@class=\"pay\"]//button[@type=\"submit\"]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("pay-description__cost")));
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(paySum + " BYN", driver.findElement(By.className("pay-description__cost")).getText());
        sa.assertTrue(driver.findElement(By.className("pay-description__text")).getText().contains("375" + payPhoneNumber));
        sa.assertEquals("Оплатить " + paySum + " BYN", driver.findElement(By.xpath("//button[@type=\"submit\"]")).getText());
        sa.assertAll();
    }
    @Test(dataProvider = "PayFramePaySystems",
            dataProviderClass = TestMTSBYPayFrameData.class,
            description = "Проверка наличия иконок платежных систем в окне оплаты",
            groups = "Pay_frame",
            dependsOnMethods = "testPayFramePhoneAndSum",
            priority = 2
    )
    public void testPayFramePaySystemIcons(String paySystem, String number) {
        if (number.equals("4"))
            assertTrue(driver.findElement(By.xpath("//img[@src=\"assets/images/payment-icons/card-types/belkart-system.svg\"]/following::div/img[1]")).isDisplayed() | driver.findElement(By.xpath("//img[@src=\"assets/images/payment-icons/card-types/belkart-system.svg\"]/following::div/img[2]")).isDisplayed());
        else
            assertTrue(driver.findElement(By.xpath("//img[@src=\"assets/images/payment-icons/card-types/" + paySystem + "-system.svg\"]")).isDisplayed());
    }
    @Test(dataProvider = "PayFrameLabelsForFormcontrolnames",
            dataProviderClass = TestMTSBYPayFrameData.class,
            description = "Проверка надписей в незаполненных полях данных карты в окне оплаты",
            groups = "Pay_frame",
            priority = 3,
            dependsOnMethods = "testPayFramePhoneAndSum"
    )
    public void testPayFrameLabels(String labelText, String Formcontrolname) {
        assertEquals(labelText, driver.findElement(By.xpath("//input[@formcontrolname = " + Formcontrolname + "]/following::label")).getText());
    }


}
