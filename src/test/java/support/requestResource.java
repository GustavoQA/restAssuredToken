package support;

import io.restassured.response.Response;

public class requestResource {

    apiHelper api;

    public static Response RespuestaResource;

    public requestResource() {
        api = new apiHelper();
    }

    public void getResources() {
        String url = "https://reqres.in/api/unknown";
        RespuestaResource = api.getResponse(url);

    }

    public void getResource(String id) {
        String url = "https://reqres.in/api/unknown/" + id;
        RespuestaResource = api.getResponse(url);

    }




}
