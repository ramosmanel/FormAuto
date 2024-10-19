package steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Entao;
import org.junit.After;
import org.junit.Before;
import pageobjects.FormPage;
import setup.Driver;

import static org.junit.Assert.assertEquals;

public class PatientSteps {
    Driver driver = new Driver();
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

    @Dado("que nao preencha o campo paciente")
    public void que_nao_preencha_o_campo_paciente() {
        formPage.patientField("");
    }

    @Dado("passe para o campo seguinte")
    public void passe_para_o_campo_seguinte() {
        DateSteps dateSteps = new DateSteps();
        dateSteps.que_nao_preencha_o_campo_data();
    }

    @Entao("o sistema deve retornar uma mensagem de campo obrigatorio")
    public void o_sistema_deve_retornar_uma_mensagem_de_campo_obrigatorio() {
        String messageFound = formPage.requiredMessage(1);
        assertEquals("Esta pergunta é obrigatória", messageFound);
    }
}
