package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class FormPage {
    private final WebDriver driver;

    public FormPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Paciente
    public void patientField(String name) {
        driver.findElement(By.cssSelector("[aria-labelledby='i1']")).sendKeys(name);
    }

    public String getMessage(int i){
        String xpath = "//div[@class='o3Dpx']/div["+i+"]//div[@class='SL4Sz']";
        return driver.findElement(By.xpath(xpath)).getText();
    }

    //Data
    public void DateField(String date) {
        driver.findElement(By.cssSelector("[type='date']")).sendKeys(date);
    }
}
