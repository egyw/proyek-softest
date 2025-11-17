package src.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import src.utils.Delay;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    // ===========================================
    // ======= ELEMENT" DI SIDEBAR OVERLAY =======
    // ===========================================
    private By openSideMenuOverlayButton = By.cssSelector(".Button.Button--iconOnly.Button--invisible.Button--medium.op-app-header--primer-button");
    private By closeSideMenuOverlayButton = By.cssSelector(".close-button.Overlay-closeButton");
    private By homeButtonInSideMenuOverlay = By.xpath("//a[contains(@class,'ActionListContent--visual16') and @href='/']");
    private By projectsButtonInSideMenuOverlay = By.xpath("//a[contains(@class,'ActionListContent--visual16') and @href='/projects']");
    private By workPackagesButtonInSideMenuOverlay = By.xpath("//a[contains(@class,'ActionListContent--visual16') and @href='/work_packages']");
    private By ganntChartsButtonInSideMenuOverlay = By.xpath("//a[contains(@class,'ActionListContent--visual16') and @href='/gantt']");
    private By teamPlannersButtonInSideMenuOverlay = By.xpath("//a[contains(@class,'ActionListContent--visual16') and @href='/team_planners']");
    private By boardsButtonInSideMenuOverlay = By.xpath("//a[contains(@class,'ActionListContent--visual16') and @href='/boards']");
    private By meetingsButtonInSideMenuOverlay = By.xpath("//a[contains(@class,'ActionListContent--visual16') and @href='/meetings']");
    private By newsButtonInSideMenuOverlay = By.xpath("//a[contains(@class,'ActionListContent--visual16') and @href='/news']");
    private By timeAndCostsButtonInSideMenuOverlay = By.xpath("//a[contains(@class,'ActionListContent--visual16') and @href='/cost_reports']");

    // ===================================
    // ======= ELEMENT" DI SIDEBAR =======
    // ===================================
    private By collapseSidebarButton = By.cssSelector(".Button.Button--iconOnly.Button--invisible.Button--medium");
    private By uncollapseSidebarButton = By.cssSelector("Button.Button--iconOnly.Button--invisible.Button--small");



    // constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }                             

    // ========================================
    // ======= FUNCTION SIDEBAR OVERLAY =======
    // ========================================
    public void openSideMenuOverlay() {
        driver.findElement(openSideMenuOverlayButton).click();
        Delay.waitFor(1500);
    }

    public void closeSideMenuOverlay(){
        driver.findElement(closeSideMenuOverlayButton).click();
        Delay.waitFor(1500);
    }

    public void clickHomeInSideMenuOverlay(){
        driver.findElement(homeButtonInSideMenuOverlay).click();
        Delay.waitFor(1500);
    }

    public void clickProjectsInSideMenuOverlay(){
        driver.findElement(projectsButtonInSideMenuOverlay).click();
        Delay.waitFor(1500);
        driver.navigate().back();
        Delay.waitFor(1500);

    }

    public void clickWorkPackagesInSideMenuOverlay(){
        driver.findElement(workPackagesButtonInSideMenuOverlay).click();
        Delay.waitFor(1500);
        driver.navigate().back();
        Delay.waitFor(1500);

    }

    public void clickGanntChartsInSideMenuOverlay(){
        driver.findElement(ganntChartsButtonInSideMenuOverlay).click();
        Delay.waitFor(1500);
        driver.navigate().back();
        Delay.waitFor(1500);

    }

    public void clickTeamPlannersInSideMenuOverlay(){
        driver.findElement(teamPlannersButtonInSideMenuOverlay).click();
        Delay.waitFor(1500);
        driver.navigate().back();
        Delay.waitFor(1500);

    }

    public void clickBoardsInSideMenuOverlay(){
        driver.findElement(boardsButtonInSideMenuOverlay).click();
        Delay.waitFor(1500);
        driver.navigate().back();
        Delay.waitFor(1500);

    }

    public void clickMeetingsInSideMenuOverlay(){
        driver.findElement(meetingsButtonInSideMenuOverlay).click();
        Delay.waitFor(1500);
        driver.navigate().back();
        Delay.waitFor(1500);

    }

    public void clickNewsInSideMenuOverlay(){
        driver.findElement(newsButtonInSideMenuOverlay).click();
        Delay.waitFor(1500);
        driver.navigate().back();
        Delay.waitFor(1500);

    }

    public void clickTimeAndCostsInSideMenuOverlay(){
        driver.findElement(timeAndCostsButtonInSideMenuOverlay).click();
        Delay.waitFor(1500);
        driver.navigate().back();
        Delay.waitFor(1500);

    }

    // ================================
    // ======= FUNCTION SIDEBAR =======
    // ================================
    public void collapseSidebar(){
        driver.findElement(collapseSidebarButton).click();
        Delay.waitFor(1500);
    }

    public void uncollapseSidebar(){
        driver.findElement(uncollapseSidebarButton).click();
        Delay.waitFor(1500);
    }
}
