package steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Entao;
import pageobjects.FormPage;
import setup.Driver;

import static org.junit.Assert.assertEquals;

public class PatientSteps {
    FormPage formPage = new FormPage(Driver.getDriver());

    @Dado("passe para o campo seguinte")
    public void passe_para_o_campo_seguinte() {
        DateSteps dateSteps = new DateSteps();
        dateSteps.que_nao_preencha_o_campo_data();
    }

    @Entao("o sistema deve retornar uma mensagem de campo obrigatorio")
    public void o_sistema_deve_retornar_uma_mensagem_de_campo_obrigatorio(int i) {
        String messageFound = formPage.getMessage(i);
        assertEquals(" Esta pergunta é obrigatória", messageFound);
    }

    @Dado("que eu preencha o campo paciente")
    public void que_eu_preencha_o_campo_paciente(String patientName) {
        formPage.patientField(patientName);
    }
    @Entao("o sistema não deve retornar nenhuma mensagem de erro")
    public void o_sistema_não_deve_retornar_nenhuma_mensagem_de_erro() {
        String messageFound = formPage.getMessage(1);
        assertEquals("", messageFound);
    }

    @Entao("o sistema deve retornar uma mensagem de erro")
    public void o_sistema_deve_retornar_uma_mensagem_de_erro() {
        String messageFound = formPage.getMessage(1);
        assertEquals(" O nome do paciente informado não atende o padrão esperado.", messageFound);
    }
}
