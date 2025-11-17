package src.utils;

import java.io.PrintWriter;

public class TestLogger {
    private static PrintWriter report;

    public static void setReport(PrintWriter writer) {
        report = writer;
    }

    public static void test(Runnable action, String description) {
        try {
            action.run();
            log(description, true, null);
        } catch (Exception e) {
            log(description, false, e.getMessage());
        }
    }

    public static void log(String name, boolean passed, String info) {
        String status = passed ? "[PASS]" : "[FAIL]";
        String message = status + " " + name + (info != null ? " - " + info : "");
        System.out.println(message);
        if (report != null) {
            report.println(message);
        }
    }
}
