package src.tests;

import src.base.BaseTest;

public class TryTest extends BaseTest{
    public static void main(String[] args) {
        TryTest test = new TryTest();
        test.run();
    }

    public void run() {
        start(); // start browser diambil dari function BaseTest.java

        try {
            // test membuka website trytestingthis untuk percobaan apakah bisa konek
            driver.get("https://trytestingthis.netlify.app/");

            System.out.println("Title: " + driver.getTitle());

            Thread.sleep(1500);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stop(); // stop browser diambil dari function BaseTest.java
        }
    }
}
