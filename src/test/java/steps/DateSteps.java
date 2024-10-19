package steps;

import io.cucumber.java.es.Dado;
import pageobjects.FormPage;

public class DateSteps {
    FormPage formPage;

    @Dado("que nao preencha o campo data")
    public void que_nao_preencha_o_campo_data() {
        formPage.DateField("");
    }
}
