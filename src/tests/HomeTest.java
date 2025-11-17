package src.tests;

import src.base.BaseTest;
import src.pages.HomePage;
import src.utils.TestLogger;

public class HomeTest extends BaseTest{
    public static void main(String[] args) {
        HomeTest test = new HomeTest();
        test.start();
        test.run();
        test.stop();
    }

    public void run() {
        driver.get("https://safe.openproject.com/");

        HomePage homePage = new HomePage(driver);

        // ============================================
        // ========== OPEN AND CLOSE SIDEBAR ==========
        // ============================================
        TestLogger.test(() -> homePage.openSideMenuOverlay(), "Open side menu overlay");
        TestLogger.test(() -> homePage.closeSideMenuOverlay(), "Close side menu overlay");
        System.out.println("-----------------------------------");


        // ====================================================
        // ======= CLICK ALL SIDEBAR OVERLAY MENU ITEMS =======
        // ====================================================
        TestLogger.test(() -> homePage.openSideMenuOverlay(), "Open side menu overlay again for further tests");
        TestLogger.test(() -> homePage.clickHomeInSideMenuOverlay(), "Click Home in side menu overlay");
        TestLogger.test(() -> homePage.openSideMenuOverlay(), "Open side menu overlay again for further tests");
        TestLogger.test(() -> homePage.clickProjectsInSideMenuOverlay(), "Click Projects in side menu overlay");
        TestLogger.test(() -> homePage.clickWorkPackagesInSideMenuOverlay(), "Click Work Packages in side menu overlay");
        TestLogger.test(() -> homePage.clickGanntChartsInSideMenuOverlay(), "Click Gannt Charts in side menu overlay");
        TestLogger.test(() -> homePage.clickTeamPlannersInSideMenuOverlay(), "Click Team Planners in side menu overlay");
        TestLogger.test(() -> homePage.clickBoardsInSideMenuOverlay(), "Click Boards in side menu overlay");
        TestLogger.test(() -> homePage.clickMeetingsInSideMenuOverlay(), "Click Meetings in side menu overlay");
        TestLogger.test(() -> homePage.clickNewsInSideMenuOverlay(), "Click News in side menu overlay");
        TestLogger.test(() -> homePage.clickTimeAndCostsInSideMenuOverlay(), "Click Time and Costs in side menu overlay");
        TestLogger.test(() -> homePage.closeSideMenuOverlay(), "Close side menu overlay after all tests");


        // ===============================================
        // ======= timeout biar ga langsung close ========
        // ===============================================
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
