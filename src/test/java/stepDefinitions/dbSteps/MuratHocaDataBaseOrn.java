package stepDefinitions.dbSteps;

import org.testng.annotations.Test;
import utilities.DatabaseUtility;

import java.util.List;



public class MuratHocaDataBaseOrn {


    @Test
    public void test(){
        //database ile baglanti kur

        DatabaseUtility.createConnection();

        String quary="select * from physician";
        System.out.println(DatabaseUtility.getColumnNames(quary));
      //sutun isimleri
     //[id, first_name, last_name, birth_date, phone, gender, blood_group, adress, description, created_date, user_id, country_id, cstate_id, created_by, last_modified_by, last_modified_date, speciality, exam_fee, image, image_content_type]


        //id lere ulasma ve kaydetme
        System.out.println("*******************ID LIST*****************");
        List<Object> idList= DatabaseUtility.getColumnData(quary, "id");
        System.out.println(idList + "\n" );







    }
}
