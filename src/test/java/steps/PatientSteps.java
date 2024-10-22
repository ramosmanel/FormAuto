package steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Entao;
import pageobjects.FormPage;
import setup.Driver;

import static org.junit.Assert.assertEquals;

public class PatientSteps {
    FormPage formPage = new FormPage(Driver.getDriver());

    @Dado("que eu preencha o campo paciente com {string}")
    public void que_eu_preencha_o_campo_paciente_com(String patientName) {
        formPage.patientField(patientName);
    }

    @Dado("passe para o campo seguinte")
    public void passe_para_o_campo_seguinte() {
        formPage.DateField("");
    }

    @Entao("o sistema deve retornar uma mensagem de {string}")
    public void o_sistema_deve_retornar_uma_mensagem_de(String requiredMessage, int i) {
        String messageFound = formPage.getMessage(i);
        assertEquals(requiredMessage, messageFound);
    }
}
