package support;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class apiHelper {

    public Response getResponse(String url){
            Response Respuesta = given().get(url).prettyPeek();
          return Respuesta;
    }

    public Response postResponse(String url,Object payload){
        Response Respuesta = given().body(payload).contentType("application/json").post(url).prettyPeek();
        return Respuesta;
    }

    public Response putResponse(String url,Object payload){
        Response Respuesta = given().body(payload).contentType("application/json").put(url).prettyPeek();
        return Respuesta;
    }
    public Response patchResponse(String url,Object payload){
        Response Respuesta = given().body(payload).contentType("application/json").patch(url).prettyPeek();
        return Respuesta;
    }

    public Response postResponseToken(String url,Object payload){
        Response Respuesta = given()
                .header("Content-Type", "application/json")
                .header("x-rapidapi-host","bravenewcoin.p.rapidapi.com")
                .header("x-rapidapi-key","c8f042a2b0msh5ccc719e499ade9p1d3beejsne55a03735ed0")
                .body(payload).post(url).prettyPeek();

        return Respuesta;
    }


    public Response Cabeceras(String url,Object payload,String parametro , String valor){
        Response Respuesta = given()
                .header("Content-Type", "application/json")
                .header(parametro,valor)
                .body(payload).log().all()
                .post(url)
                 .prettyPeek();
        return Respuesta;
    }




}
