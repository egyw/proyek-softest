package src.base;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import src.utils.TestLogger;

public class BaseTest {
    protected WebDriver driver;

    public void start() {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            PrintWriter writer = new PrintWriter(new FileWriter("report_" + timestamp + ".txt"));
            TestLogger.setReport(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.setProperty("webdriver.chrome.driver", "chromedriver-win64/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}
