package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

import static org.testng.Assert.*;

public class SearchFiltersTest extends BaseTest {

    @Test(groups = "firstTestGroup")
    public void testBrandSelected(){
        WebElement searchInput = driver.findElement(By.xpath("//input[@name=\"search\"]"));
        searchInput.sendKeys("Холодильник Samsung");
        searchInput.sendKeys(Keys.ENTER);

        String brandsPath = "/html/body/app-root/div/div/rz-category/div/main/rz-catalog/div/div/aside/rz-filter-stack/div[4]/div/rz-scrollbar/div/div[1]/div/div/rz-filter-section-autocomplete/ul[1]/li";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(brandsPath)));
        List<WebElement> list = driver.findElements(By.xpath(brandsPath));
        assertFalse(list.isEmpty());
        for (int i = 0; i < list.size(); i++) {
            WebElement el = list.get(i);
            WebElement link = list.get(0).findElement(By.tagName("a"));
            if(el.getText().contains("Samsung")) {
                assertTrue(Objects.isNull(link.getAttribute("href")));
            } else {
                assertFalse(Objects.isNull(link.getAttribute("href")));
            }
        }
    }


    @Override
    protected String url() {
        return "https://rozetka.com.ua";
    }
}
