package context;

import io.restassured.response.Response;

public class ScenarioContext {
    private static Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        ScenarioContext.response = response;
    }
}
