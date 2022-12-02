package baseUrl.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import utilities.Authentication;


public class MedunnaBaseURL extends Authentication {

    protected RequestSpecification spec;

    @Before
    public void stUp(){
        spec = new RequestSpecBuilder().setBaseUri("https://www.medunna.com/api/").build();
    }
}
