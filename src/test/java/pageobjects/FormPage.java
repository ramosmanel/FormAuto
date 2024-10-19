package pageobjects;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import setup.Driver;

public class FormPage {
    private Driver driver;

    @Before
    public void startDriver(){
        driver.webDriver();
    }

    @After
    public void endDriver(){
        driver.webDriver().close();
        driver.webDriver().quit();
    }

    //Paciente
    public void patientField(String name) {
        driver.webDriver().findElement(By.cssSelector("[aria-labelledby='i1']")).sendKeys(name);
    }

    public String requiredMessage(int i){
        String xpath = "//div[@class='o3Dpx']/div["+i+"]//div[@class='SL4Sz']";
        return driver.webDriver().findElement(By.xpath(xpath)).getText();
    }

    //Data
    public void DateField(String date) {
        driver.webDriver().findElement(By.cssSelector("[type='date']")).sendKeys(date);
    }
}
