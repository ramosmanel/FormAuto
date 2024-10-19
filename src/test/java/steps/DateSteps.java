package steps;

import io.cucumber.java.es.Dado;
import org.junit.After;
import org.junit.Before;
import pageobjects.FormPage;
import setup.Driver;

public class DateSteps {
    private Driver driver;
    FormPage formPage = new FormPage();

    @Before
    public void startDriver(){
        driver.webDriver();
    }

    @After
    public void endDriver(){
        driver.webDriver().close();
        driver.webDriver().quit();
    }

    @Dado("que nao preencha o campo data")
    public void que_nao_preencha_o_campo_data() {
        formPage.DateField("");
    }
}
