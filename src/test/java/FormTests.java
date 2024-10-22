import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pageobjects.FormPage;
import setup.Driver;
import steps.PatientSteps;
import utils.Messages;


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
        patientSteps.que_eu_preencha_o_campo_paciente_com("");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de(Messages.REQUIRED_FIELD_MESSAGE, 1);
    }

    @Test
    @DisplayName("Validando campo Paciente com valor válido")
    public void validPatient() {
        patientSteps.que_eu_preencha_o_campo_paciente_com("Nicholas Ferreira");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de("", 1);
    }

    @Test
    @DisplayName("Campo do Paciente não pode conter mais de 5 caracteres repetidos")
    public void characterRepetition(){
        patientSteps.que_eu_preencha_o_campo_paciente_com("AAAAAAAA");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de(Messages.INVALID_PATIENT_NAME_MESSAGE, 1);
    }

    @Test
    @DisplayName("Validando campo Paciente com valor inválido")
    public void invalidPatient(){
        patientSteps.que_eu_preencha_o_campo_paciente_com("123 Ronaldin");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de(Messages.INVALID_PATIENT_NAME_MESSAGE, 1);
    }

    @Test
    @DisplayName("Máximo de caracteres atingidos")
    public void characterLimit(){
        patientSteps.que_eu_preencha_o_campo_paciente_com("pneumoultramicroscopicossilicovulcanoconióticoanticonstitucionalissimamenteextraordinariamente");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de("", 1);
    }

    @Test
    @DisplayName("Máximo de caracteres excedidos")
    public void characterLimitExceeded() {
        patientSteps.que_eu_preencha_o_campo_paciente_com("pneumoultramicroscopicossilicovulcanoconióticoanticonstitucionalissimamenteextraordinariamente123");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de(Messages.INVALID_PATIENT_NAME_MESSAGE, 1);
    }


}
