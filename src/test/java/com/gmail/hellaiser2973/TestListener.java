package com.gmail.hellaiser2973;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestListener implements ITestListener {

    public void onTestFailure(ITestResult testResult) {
        try {
            Object webDriver = testResult.getTestContext().getAttribute("WebDriver");

            TakesScreenshot ts = (TakesScreenshot) webDriver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(source, new File("./Screenshots/" + testResult.getName() + ".png"));

            //todo выводить эти записи в лог
            System.out.println("Screenshot taken");

        } catch (Exception e) {
            //todo выводить эти записи в лог
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }

    }

}
