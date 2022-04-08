package support;

import io.restassured.response.Response;

public class requestRegister {
    apiHelper api;

    public static Response RespuestaRegister;


    public requestRegister() {
        api = new apiHelper();
    }

    public void registrarUsuario(String correo, String clave) {
        String url = "https://reqres.in/api/register";
        String user = "{\n" +
                "    \"email\": \"" + correo + "\",\n" +
                "    \"password\": \"" + clave + "\"\n" +
                "}";
        //user = new payloadUser(nombre,puesto);
        RespuestaRegister = api.postResponse(url, user);


    }
}
