import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobjects.FormPage;
import setup.Driver;
import steps.PatientSteps;


public class FormTests {
    FormPage formPage;
    PatientSteps patientSteps = new PatientSteps();

    @Before
    public void startDriver() {
        formPage = new FormPage(Driver.getDriver());
    }

    @After
    public void endDriver(){
        Driver.quitDriver();
    }

    @Test
    public void requieredPatientField(){
        patientSteps.que_eu_preencha_o_campo_paciente("");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de_campo_obrigatorio(1);
    }

    @Test
    public void validPatient() {
        patientSteps.que_eu_preencha_o_campo_paciente("Nicholas Ferreira");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_não_deve_retornar_nenhuma_mensagem_de_erro();
    }

    @Test
    public void characterRepetition(){
        patientSteps.que_eu_preencha_o_campo_paciente("AAAAAAAA");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de_erro();
    }



}
