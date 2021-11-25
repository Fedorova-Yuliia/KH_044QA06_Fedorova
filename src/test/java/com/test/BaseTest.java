package com.test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get(url());
    }

    @AfterMethod(alwaysRun = true)
    public void keepScreenshotsAndClose() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./screenshots/" + scrFile.getName()));
        driver.close();
        driver.quit();
    }

    protected abstract String url();
}
