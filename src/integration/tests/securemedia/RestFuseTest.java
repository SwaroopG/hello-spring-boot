package securemedia;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.runner.RunWith;

import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;
import com.eclipsesource.restfuse.annotation.HttpTest;

@Ignore
@RunWith(HttpJUnitRunner.class)
public class RestFuseTest
{
    @Rule
    public Destination destination = new Destination(this, "http://localhost:8205" );
    
    @Context
    private Response actualResponse;

    @HttpTest(method = Method.GET, path = "/rightsinfo/1?sname=rightsinfo&cmd=ping")
    public void headerTest()
    {
        System.out.println(actualResponse.getStatus());
        System.out.println(actualResponse.getBody());
        Assert.assertEquals("Checking HTTP Response Code", 200, actualResponse.getStatus());
        Assert.assertEquals("Expected and actual response do not match!", getExpectedResponse(), actualResponse.getBody());
    }

    private String getExpectedResponse()
    {
        return "<rpksmsresp><rc>0</rc><msg>OK</msg></rpksmsresp>";
    }
}
