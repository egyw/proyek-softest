import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumElement {
    static PrintWriter report;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "chromedriver-win64/chromedriver.exe");

        // Initialize a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
            driver.manage().window().maximize();

            // buat laporan
            String timestamp = new SimpleDateFormat("yyyyMMdd_Hmmss").format(new Date());
            report = new PrintWriter(new FileWriter("report_trythingsthis_" + timestamp + ".txt", true));

            // buka website
            driver.get("https://trytestingthis.netlify.app/");
            log("Buka Website", true, "Title: " + driver.getTitle());

            // input text by.Id/By.Name
            test(()-> {
                WebElement fname = driver.findElement(By.id("fname"));
                WebElement lname = driver.findElement(By.name("lname"));
                fname.sendKeys("Egbert");
                lname.sendKeys("wangarry");

                // explicit wait
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
                wait.until(ExpectedConditions.attributeToBe(fname, "value", "Egbert"));
                wait.until(ExpectedConditions.attributeToBe(lname, "value", "wangarry"));
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Text Fields: First Name and Last Name");

            // RADIO BUTTON
            test(()->{
                WebElement gender = driver.findElement(By.xpath("//input[@value='male']"));
                gender.click();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                wait.until(ExpectedConditions.attributeToBe(gender, "value", "male"));
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Radio Button: male");

            // DROPDOWN
            test(()-> {
                WebElement dropdownElement = driver.findElement(By.name("option"));
                Select dropdown = new Select(dropdownElement);
                dropdown.selectByValue("option 2");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                wait.until(ExpectedConditions.attributeToBe(dropdownElement, "value", "option 2"));
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Dropdown: pilih option 2");

            // MULTIPLE DROPDOWN
            test(() -> {
                WebElement multipleDropDownElement = driver.findElement(By.xpath("//select[@multiple]"));
                Select multipleDropDown = new Select(multipleDropDownElement);
                multipleDropDown.selectByValue("option");
                multipleDropDown.selectByValue("option 3");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@multiple]")));
                try{
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Multiple Dropdown: option 1 dan option 3");

            // CHECKBOX
            test(()->{
                WebElement opt1 = driver.findElement(By.cssSelector("input[name='option1']"));
                WebElement opt2 = driver.findElement(By.cssSelector("input[name='option2']"));
                opt1.click();
                opt2.click();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                wait.until(ExpectedConditions.elementToBeSelected(opt1));
                wait.until(ExpectedConditions.elementToBeSelected(opt2));
                try{
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Checkbox: option 1 dan option 2");

            // DATALIST DENGAN CSS SELECTOR
            test(()->{
                WebElement input = driver.findElement(By.cssSelector("input[list='datalists']"));
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                wait.until(ExpectedConditions.elementToBeClickable(input));
                input.clear();
                input.sendKeys("Banana");
                wait.until(ExpectedConditions.attributeToBe(input, "value", "Banana"));
                try{
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Datalist input: Banana");

            // COLOR
            test(()->{
                WebElement colorInput = driver.findElement(By.id("favcolor"));
                colorInput.sendKeys("#2a44c6");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                wait.until(ExpectedConditions.elementToBeClickable(colorInput));
                try{
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Pilih warna: #2a44c6");

            // DATE
            test(()->{
                WebElement dateInput = driver.findElement(By.id("day"));
                dateInput.clear();
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].value = '2025-11-14';", dateInput, "2025-11-14");

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                wait.until(ExpectedConditions.attributeToBe(dateInput, "value", "2025-11-14"));
                try{
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Tanggal di input: " + dateInput.getAttribute("value"));
            }, "Date");

            // range nilai
            test(()->{
                WebElement rangeSlider = driver.findElement(By.id("a"));
                WebElement outputValue = driver.findElement(By.cssSelector("output[name=x]"));

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript(
                    "arguments[0].value = 70;" + 
                    "arguments[1].innerText=arguments[0].value;" +
                    "arguments[0].dispatchEvent(new Event('input')); "+ 
                    "arguments[0].dispatchEvent(new Event('change'));",
                    rangeSlider, outputValue
                );

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                wait.until(ExpectedConditions.textToBePresentInElement(outputValue, "70"));
                try{
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Range nilai 70");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(driver != null) {
                driver.quit();
            }
            if(report != null) {
                report.flush();
                report.close();
            }
        }
    }
    
    public static void test(Runnable action, String descripton) {
        try {
            action.run();
            log(descripton, true, null);
        } catch (Exception e) {
            String msg = e.getMessage();
            log(descripton, false, msg);
        }
    }
    
    public static void log(String testName, boolean passed, String info) {
        String status = passed ? "[PASS]" : "[FAIL]";
        String message = status + " " + testName + (info!=null ? " - " + info : "");
        System.out.println(message);
        report.println(message);
    }
}
