package steps;

import io.cucumber.java.es.Dado;
import pageobjects.FormPage;
import setup.Driver;

public class DateSteps {
    FormPage formPage = new FormPage(Driver.getDriver());

    @Dado("que nao preencha o campo data")
    public void que_nao_preencha_o_campo_data() {
        formPage.DateField("");
    }
}
