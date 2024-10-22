import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pageobjects.FormPage;
import setup.Driver;
import steps.DateSteps;
import steps.PatientSteps;
import utils.Messages;
import utils.Screenshot;


public class FormTests {
    FormPage formPage;
    PatientSteps patientSteps = new PatientSteps();
    DateSteps dateSteps = new DateSteps();
    Screenshot screenshot = new Screenshot();

    @Before
    public void startDriver() {
        formPage = new FormPage(Driver.getDriver());
    }

    @After
    public void endDriver(){
        screenshot.takeScreenshot();
        Driver.quitDriver();
    }

    @Test
    @DisplayName("CT01 - Campo Paciente Obrigatório")
    public void requieredPatientField(){
        patientSteps.que_eu_preencha_o_campo_paciente_com("");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de(Messages.REQUIRED_FIELD_MESSAGE, 1);
    }

    @Test
    @DisplayName("CT02 - Validando campo Paciente com valor válido")
    public void validPatient() {
        patientSteps.que_eu_preencha_o_campo_paciente_com("Nicholas Ferreira");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de("", 1);
    }

    @Test
    @DisplayName("CT03 - Campo do Paciente não pode conter mais de 5 caracteres repetidos")
    public void characterRepetition(){
        patientSteps.que_eu_preencha_o_campo_paciente_com("AAAAAAAA");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de(Messages.INVALID_PATIENT_NAME_MESSAGE, 1);
    }

    @Test
    @DisplayName("CT04 - Validando campo Paciente com valor inválido")
    public void invalidPatient(){
        patientSteps.que_eu_preencha_o_campo_paciente_com("123 Ronaldin");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de(Messages.INVALID_PATIENT_NAME_MESSAGE, 1);
    }

    @Test
    @DisplayName("CT05 - Máximo de caracteres atingidos")
    public void characterLimit(){
        patientSteps.que_eu_preencha_o_campo_paciente_com("pneumoultramicroscopicossilicovulcanoconióticoanticonstitucionalissimamenteextraordinariamente");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de("", 1);
    }

    @Test
    @DisplayName("CT06 - Máximo de caracteres excedidos")
    public void characterLimitExceeded() {
        patientSteps.que_eu_preencha_o_campo_paciente_com("pneumoultramicroscopicossilicovulcanoconióticoanticonstitucionalissimamenteextraordinariamente123");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de(Messages.INVALID_PATIENT_NAME_MESSAGE, 1);
    }

    @Test
    @DisplayName("CT07 - Paciente sem sobrenome")
    public void patientWithoutLastName(){
        patientSteps.que_eu_preencha_o_campo_paciente_com("Jorge");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de(Messages.INVALID_PATIENT_NAME_MESSAGE, 1);
    }

    @Test
    @DisplayName("CT08 - Nome do paciente começando com espaço")
    public void patientNameStartingWithSpace(){
        patientSteps.que_eu_preencha_o_campo_paciente_com(" Jogue");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de(Messages.INVALID_PATIENT_NAME_MESSAGE, 1);
    }

    @Test
    @DisplayName("CT09 - Nome do paciente composto apenas por espaços")
    public void compositePatientNameWithSpaceOnly() {
        patientSteps.que_eu_preencha_o_campo_paciente_com("      ");
        patientSteps.passe_para_o_campo_seguinte();
        patientSteps.o_sistema_deve_retornar_uma_mensagem_de(Messages.INVALID_PATIENT_NAME_MESSAGE, 1);
    }

    @Test
    @DisplayName("CT10 - Campo Data Obrigatorio")
    public void requiredDateField(){
        dateSteps.que_eu_preencha_o_campo_data_com("");
        dateSteps.passe_para_o_campo_seguinte();
        dateSteps.o_sistema_deve_retornar_uma_mensagem_de(Messages.REQUIRED_FIELD_MESSAGE, 2);
    }

    @Test
    @DisplayName("CT11 - Campo Data com dados validos")
    public void dateValid(){
        dateSteps.que_eu_preencha_o_campo_data_com("24/04/2000");
        dateSteps.passe_para_o_campo_seguinte();
        dateSteps.o_sistema_deve_retornar_uma_mensagem_de("", 2);
    }

    @Test
    @DisplayName("CT12 - Data invalida com valores no passado invalidos")
    public void invalidDatePassed(){
        dateSteps.que_eu_preencha_o_campo_data_com("01/01/1500");
        dateSteps.passe_para_o_campo_seguinte();
        dateSteps.o_sistema_deve_retornar_uma_mensagem_de(Messages.INVALID_DATE_VALUE_MESSAGE, 2);
    }

    @Test
    @DisplayName("CT13 - Data invalida com valores futuros")
    public void futureInvalidDate(){
        dateSteps.que_eu_preencha_o_campo_data_com("01/01/2050");
        dateSteps.passe_para_o_campo_seguinte();
        dateSteps.o_sistema_deve_retornar_uma_mensagem_de(Messages.INVALID_DATE_VALUE_MESSAGE, 2);
    }

    @Test
    @DisplayName("CT14 - Usuário menor de 18 anos")
    public void underage(){
        dateSteps.que_eu_preencha_o_campo_data_com("22/10/2021");
        dateSteps.passe_para_o_campo_seguinte();
        dateSteps.o_sistema_deve_retornar_uma_mensagem_de(Messages.INVALID_DATE_VALUE_MESSAGE, 2);
    }
}
