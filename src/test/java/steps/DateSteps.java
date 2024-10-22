package steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Entao;
import pageobjects.FormPage;
import setup.Driver;

import static org.junit.Assert.assertEquals;

public class DateSteps {
    FormPage formPage = new FormPage(Driver.getDriver());

    @Dado("que eu preencha o campo data com {string}")
    public void que_eu_preencha_o_campo_data_com(String dateValue) {
        formPage.DateField(dateValue);
    }

    @Dado("passe para o campo seguinte")
    public void passe_para_o_campo_seguinte() {
        formPage.doctorField("");
    }

    @Entao("o sistema deve retornar uma mensagem de {string}")
    public void o_sistema_deve_retornar_uma_mensagem_de(String requiredMessage, int i) {
        String messageFound = formPage.getMessage(i);
        assertEquals(requiredMessage, messageFound);
    }

}
