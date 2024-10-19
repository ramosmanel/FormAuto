import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobjects.FormPage;
import setup.Driver;


public class FormTests {
    FormPage formPage;

    @Before
    public void startDriver() {
        formPage = new FormPage(Driver.getDriver());
    }

    @After
    public void endDriver(){
        Driver.quitDriver();
    }

    @Test
    public void requieredField(){
        formPage.patientField("");
        formPage.requiredMessage(1);
    }

}
