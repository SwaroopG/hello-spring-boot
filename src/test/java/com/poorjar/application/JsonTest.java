package com.poorjar.application;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest
{
    @Test
    public void testSometin() throws Exception
    {
        String response = "{\"statusCode\":0,\"message\":\"Success\",\"data\":{\"InHome\":false, \"InNetwork\":false, \"InCountry\":false, \"Country\":\"US\"}}";

        Map<String, Object> actualResponse = new ObjectMapper().readValue(response.getBytes(), Map.class);
        System.out.println(actualResponse.toString());
        assertEquals(0, actualResponse.get("statusCode"));
        assertEquals("Success", actualResponse.get("message"));

        Map<String, Object> responseData = (Map<String, Object>) actualResponse.get("data");

        assertEquals(false, responseData.get("InHome"));
        assertEquals(false, responseData.get("InNetwork"));
        assertEquals(false, responseData.get("InCountry"));
        assertEquals("US", responseData.get("Country"));
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private class OnNetworkResponse
    {
        private int statusCode;
        private String message;
        private Map<String, String> data;

        public int getStatusCode()
        {
            return statusCode;
        }

        public void setStatusCode(int statusCode)
        {
            this.statusCode = statusCode;
        }

        public String getMessage()
        {
            return message;
        }

        public void setMessage(String message)
        {
            this.message = message;
        }

        public Map<String, String> getData()
        {
            return data;
        }

        public void setData(Map<String, String> data)
        {
            this.data = data;
        }

        @Override
        public String toString()
        {
            return "statusCode: " + statusCode + "\n" + "message: " + message + "\n" + "data: " + data;
        }
    }
}
