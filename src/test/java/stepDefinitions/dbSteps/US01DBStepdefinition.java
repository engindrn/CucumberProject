package stepDefinitions.dbSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import utilities.DatabaseUtility;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static stepDefinitions.uiSteps.US01KayitStepDefinition.registrant;

public class US01DBStepdefinition {
    List<Object> actualData;


    @Given("CE kullanici connection kurar")
    public void ce_kullanici_connection_kurar() {
        DatabaseUtility.createConnection();

     //  DatabaseUtility.createConnection(ConfigReader.getProperty("database_url"),
     //          ConfigReader.getProperty("database_username"),
     //          ConfigReader.getProperty("database_password"));

    }

    @Given("CE tum yeni kayitli biligileri alir {string} ve {string}")
    public void ce_tum_yeni_kayitli_biligileri_alir_ve(String query, String columnName) {
        actualData = DatabaseUtility.getColumnData(query, columnName);
    }

    @Then("CE kulanici bilgilerini dogrular")
    public void ce_kulanici_bilgilerini_dogrular() {
        assertTrue("data eslesmedi",actualData.contains(registrant.getSsn()));
    }

}