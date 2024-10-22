package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import setup.Driver;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public void takeScreenshot() {
        File screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        String evidencePath = "src/test/java/evidence/";

        File directory = new File(evidencePath);
        if (!directory.exists()){
            directory.mkdir();
        }

        try {
            FileHandler.copy(screenshot, new File(evidencePath + "evidence_test_" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
