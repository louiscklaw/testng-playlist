package dev.selenium.hko_getting_started;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Landing {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // Set the desired viewport size
        Dimension viewportSize = new Dimension(1920, 1080);
        driver.manage().window().setSize(viewportSize);

        driver.get("https://www.hko.gov.hk/en/index.html");

        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // WebElement textBox = driver.findElement(By.name("my-text"));
        // WebElement submitButton = driver.findElement(By.cssSelector("button"));

        // textBox.sendKeys("Selenium");
        // submitButton.click();

        // WebElement message = driver.findElement(By.id("message"));
        // message.getText();

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            // Specify the location where you want to save the screenshot
            String destinationPath = "./screenshot.png";
            FileUtils.copyFile(screenshotFile, new File(destinationPath));
            System.out.println("Screenshot saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }

        driver.quit();
    }
}
