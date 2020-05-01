package main;

import org.testng.TestNG;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static TestNG runner = new TestNG();

    public static void main(String[] args) {
        String testSuite = args[0];
        List<String> suiteFiles = new ArrayList<String>();
        // String testSuite = "sanity";
        suiteFiles.add("./suites/" + testSuite + ".xml");

        runner.setTestSuites(suiteFiles);
        runner.run();
    }
}
