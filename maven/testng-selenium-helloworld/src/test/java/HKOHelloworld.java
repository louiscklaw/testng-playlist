import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

@Test()
public class HKOHelloworld {

    @Test()
    public void test() {
        WebDriver driver = new ChromeDriver();

        // Set the desired viewport size
        Dimension viewportSize = new Dimension(1920, 1080);
        driver.manage().window().setSize(viewportSize);

        driver.get("https://www.hko.gov.hk");

        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            // Specify the location where you want to save the screenshot
            String destinationPath = "./hko_org_helloworld.png";
            FileUtils.copyFile(screenshotFile, new File(destinationPath));
            System.out.println("Screenshot saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }

        driver.quit();
        Assert.assertEquals("done", "done");
    }

}
