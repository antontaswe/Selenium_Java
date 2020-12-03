package com.lazerycode.selenium.tests;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.page_objects.GoogleHomePage;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SmoketestIT extends DriverBase {

    private ExpectedCondition<Boolean> pageTitleStartsWith(final String searchString) {
        return driver -> driver.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
    }

    @Test
    public void TestAppTitle() throws Exception {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = getDriver();

        // And now use this to visit the web application
        driver.get("http://bth_demo:3000");

        assertTrue(driver.getPageSource().contains("Take Notes"),"The text Take Notes doesn't exists");
    }

    @Test
    public void TestNewNoteSave() throws Exception {

        WebDriver driver = getDriver();

        driver.get("http://bth_demo:3000");

        driver.findElement(By.id("new")).click();
        driver.findElement(By.name("title")).sendKeys("This is a title");
        driver.findElement(By.name("description")).sendKeys("This is a description");
        driver.findElement(By.id("save")).click();

        //assertTrue(driver.getPageSource().contains("Take Notes"),"The text Take Notes doesn't exists");
    }

    @Test
    public void TestNewNoteCancel() throws Exception {

        WebDriver driver = getDriver();

        driver.get("http://bth_demo:3000");

        driver.findElement(By.id("new")).click();
        driver.findElement(By.name("title")).sendKeys("This is a temporary title");
        driver.findElement(By.name("description")).sendKeys("This is a temporary description");
        driver.findElement(By.id("cancel")).click();

        //assertTrue(driver.getPageSource().contains("Take Notes"),"The text Take Notes doesn't exists");
    }

    @Test
    public void TestDeleteNote() throws Exception {

        WebDriver driver = getDriver();

        driver.get("http://bth_demo:3000");

        driver.findElement(By.id("new")).click();
        driver.findElement(By.name("title")).sendKeys("This is a title");
        driver.findElement(By.name("description")).sendKeys("This is a description");
        driver.findElement(By.id("save")).click();
        driver.findElements(By.className("btn-danger")).get(0).click();

        //assertTrue(driver.getPageSource().contains("Take Notes"),"The text Take Notes doesn't exists");
    }

}
