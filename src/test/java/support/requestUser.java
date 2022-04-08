package support;

import io.restassured.response.Response;
import objects.payloadUser;

public class requestUser {
    apiHelper api;
    public static Response RespuestaUsers;
    payloadUser user;

    public requestUser() {
        api = new apiHelper();
    }

    public void getUsers() {
        String url = "https://reqres.in/api/users";
        RespuestaUsers = api.getResponse(url);

    }

    public void getUser(String id) {
        String url = "https://reqres.in/api/users/" + id;
        RespuestaUsers = api.getResponse(url);

    }
    public void crearUsuario(String nombre ,String puesto) {
        String url = "https://reqres.in/api/users";
        String user = "{\n" +
                "    \"name\": \""+nombre+"\",\n" +
                "    \"job\": \""+puesto+"\"\n" +
                "}";
        //user = new payloadUser(nombre,puesto);
        RespuestaUsers = api.postResponse(url,user);

    }
  public void actualizarUsuarioPut(String id,String nombre ,String puesto){
      String url = "https://reqres.in/api/users/"+id;
      user = new payloadUser(nombre,puesto);
      RespuestaUsers=api.putResponse(url,user);

  }


}
