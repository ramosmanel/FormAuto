import org.junit.After;
import org.junit.Before;
import pageobjects.FormPage;
import setup.Driver;

public class FormTests {
    private Driver driver;
    FormPage formPage;

    @Before
    public void startDriver() {
        driver.webDriver();
    }

    @After
    public void endDriver(){
        driver.webDriver().close();
        driver.webDriver().quit();
    }


}
