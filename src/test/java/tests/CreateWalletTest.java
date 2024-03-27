package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import utils.DriverUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateWalletTest {

    private AndroidDriver driver;

    public CreateWalletTest() {
    }

    @BeforeMethod
    public void setUp() {DriverUtils.initializeDriver();}

    @Test(description="Create new wallet")
    public void CreateNewWallet() {

        // Click "Create Wallet" button
        driver.findElement(By.id("com.trustwallet:id/create_wallet_button")).click();

        // Skip backup
        driver.findElement(By.id("com.trustwallet:id/skip_button")).click();

        // Check if "home" text is displayed
        assertTrue(driver.findElement(By.xpath("//*[@text='home']")).isDisplayed(),
                "Test failed: Home text is not displayed.");

        // Check wallet has been created successfully
        assertTrue(driver.findElement(By.xpath("//*[@text='Main Wallet 1']")).isDisplayed(),
                "Test failed: Main Wallet 1 is not displayed.");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        DriverUtils.quitDriver();
    }
}