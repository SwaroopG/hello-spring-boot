package securemedia;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.containsString;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class RestAssuredTest
{
    private static String pingUrl = "http://localhost:8205/rightsinfo/1?sname=rightsinfo&cmd=ping";

    @Test
    public void pingTest()
    {
        expect().statusCode(200).when().get(pingUrl);
        expect().body(containsString(expectedResponse())).when().get(pingUrl);
    }

    private String expectedResponse()
    {
        return "<rpksmsresp><rc>0</rc><msg>OK</msg></rpksmsresp>";
    }
}
