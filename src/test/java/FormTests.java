import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Campo Obrigatório")
    public void requieredPatientField(){
        patientSteps.que_eu_preencha_o_campo_paciente("");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de_campo_obrigatorio(1);
    }

    @Test
    @DisplayName("Validando campo Paciente com valor válido")
    public void validPatient() {
        patientSteps.que_eu_preencha_o_campo_paciente("Nicholas Ferreira");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_não_deve_retornar_nenhuma_mensagem_de_erro();
    }

    @Test
    @DisplayName("Campo do Paciente não pode conter mais de 5 caracteres repetidos")
    public void characterRepetition(){
        patientSteps.que_eu_preencha_o_campo_paciente("AAAAAAAA");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de_erro();
    }

    @Test
    @DisplayName("Validando campo Paciente com valor inválido")
    public void invalidPatient(){
        patientSteps.que_eu_preencha_o_campo_paciente("123 Ronaldo");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de_erro();
    }

}
