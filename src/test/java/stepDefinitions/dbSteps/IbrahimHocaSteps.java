package stepDefinitions.dbSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DatabaseUtility;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DatabaseUtility.createConnection;
import static utilities.DatabaseUtility.getColumnData;

public class IbrahimHocaSteps {

    List<Object> actulaDate;

    @Given("kullanci connection kuarar")
    public void kullanciConnectionKuarar() {
      //  DatabaseUtility.createConnection();  busekilde statik methodumuzu class ismiyle direk cagirabilir

        createConnection();   //yazip statik bir method old icin import edipte te kullanabiliriz

    }

    @And("Kullanici tum yeni kayitli bilgileri ceker {string} ve {string}")
    public void kullaniciTumYeniKayitliBilgileriCekerVe(String query, String columnName) {
                                                         //    |query    |columnName|
                                                         //    |SELECT * FROM jhi_user|ssn|
       actulaDate= getColumnData(query, columnName);  //Scenario Outline old icin feature den gelecek
                                 //bu method bize List<object> donecek
        /*bu methodla elde edecegimiz datalari koyacagimiz List <object> variablemizi asagidaki diger
        method da validate (dogrulama) yapilacagi icin ordanda ulasmak icin clas levelda olusturuyoruz*/
    }

    @Then("Kullanici kullanici bilgilerini dogrular")
    public void kullaniciKullaniciBilgileriniDogrular() {

       assertTrue("Data match etmedi", actulaDate.contains("456-25-6547"));
                                                         //SELECT * FROM jhi_user ile butun kullanicilari liste alip
                                                        //colum namesi ssn olan sutunda istedigimiz ssn nosunu arattik
    }
}
