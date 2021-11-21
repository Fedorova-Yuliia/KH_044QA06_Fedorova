package selenium.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home_Task3_1 {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://google.com");
        WebElement input = driver.findElement(By.xpath("//input[@aria-label=\"Найти\"]"));

        input.sendKeys("rozetka.com.ua");
        input.sendKeys(Keys.ENTER);

        WebElement rozetkaLink = driver.findElement(By.xpath("//a[@href=\"https://rozetka.com.ua/\"]"));
        rozetkaLink.click();

        WebElement rozetkaSearchInput = driver.findElement(By.xpath("//input[@name=\"search\"]"));
        rozetkaSearchInput.sendKeys("Монитор");
        rozetkaSearchInput.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class=\"catalog-grid ng-star-inserted\"]/li[1]")));
        WebElement firstProduct = driver.findElement(By.xpath("//ul[@class=\"catalog-grid ng-star-inserted\"]/li[1]"));
        firstProduct.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label=\"Купить\"]")));
        WebElement buyButton = driver.findElement(By.xpath("//button[@aria-label=\"Купить\"]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(buyButton);
        actions.perform();
        buyButton.click();

        // to see results
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
}
