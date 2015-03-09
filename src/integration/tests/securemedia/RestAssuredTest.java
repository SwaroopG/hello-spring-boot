package securemedia;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.collect.Lists;
import com.poorjar.entity.SearchItem;

@Ignore
public class RestAssuredTest
{
    private static String baseUrl = "http://localhost:8080";
    private static String searchUrl = "http://localhost:8080/search/description/swaroop/";

    @Test
    public void landingPageTest()
    {
        expect().statusCode(200).when().get(baseUrl);
        expect().body(containsString(expectedResponse())).when().get(baseUrl);
    }

    @Test
    public void pingTestWithHeaders()
    {
        given().headers("header1", "HEADER").header("header2", "HEADER2").and().expect().body(containsString(expectedResponse())).when()
                .get(baseUrl);
    }

    @Test
    public void searchTest() throws Exception
    {
        expect().statusCode(200).when().get(searchUrl);
        expect().body(containsString(getExpectedSearchResponse())).when().get(searchUrl);
    }

    private String expectedResponse()
    {
        return "Hello Spring Boot!";
    }

    private String getExpectedSearchResponse() throws Exception
    {
        ObjectWriter ow = new ObjectMapper().writer();
        return ow.writeValueAsString(Lists.newArrayList(new SearchItem(1, "Hello World"), new SearchItem(2, "Hello Track")));
    }
}
