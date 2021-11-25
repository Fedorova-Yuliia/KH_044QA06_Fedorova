package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HouseholdAppliancesTest extends BaseTest {

    @Test(groups = "firstTestGroup")
    public void testHouseholdAppliancesList(){
        String path = "/html/body/app-root/div/div/rz-super-portal/div/main/section/div[2]/rz-dynamic-widgets/rz-widget-list[1]/section/ul/li[1]/rz-list-tile/div/ul/li";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
        List<WebElement> list = driver.findElements(By.xpath(path));

        assertEquals(6, list.size());
        assertEquals(list.get(0).getText(), "Холодильники");
        assertEquals(list.get(1).getText(), "Стиральные машины");
        assertEquals(list.get(2).getText(), "Посудомоечные машины");
        assertEquals(list.get(3).getText(), "Кухонные плиты");
        assertEquals(list.get(4).getText(), "Морозильные камеры");
        assertEquals(list.get(5).getText(), "Сушильные машины");
    }

    @Test(groups = "secondTestGroup")
    public void testKitchenAppliancesList(){

        String path = "/html/body/app-root/div/div/rz-super-portal/div/main/section/div[2]/rz-dynamic-widgets/rz-widget-list[1]/section/ul/li[3]/rz-list-tile/div/ul/li";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
        List<WebElement> list = driver.findElements(By.xpath(path));

        assertEquals(7, list.size());
        assertEquals(list.get(0).getText(), "Кофемашины");
        assertEquals(list.get(1).getText(), "Мультиварки");
        assertEquals(list.get(2).getText(), "Печи СВЧ");
        assertEquals(list.get(3).getText(), "Блендеры");
        assertEquals(list.get(4).getText(), "Грили");
        assertEquals(list.get(5).getText(), "Аксессуары для кухонной техники");
        assertEquals(list.get(6).getText(), "Прочая мелкая техника");
    }

    @Override
    protected String url() {
        return "https://bt.rozetka.com.ua";
    }
}
