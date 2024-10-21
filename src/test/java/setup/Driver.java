package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://forms.gle/UTDF9Wm1TDLF5Mgh9");
            System.out.println(driver.getTitle());
        }
        return driver;
    }

    public static void quitDriver(){
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
