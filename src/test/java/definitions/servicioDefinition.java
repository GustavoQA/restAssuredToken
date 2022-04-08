package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import support.requestUser;

import java.util.List;
import java.util.Map;


public class servicioDefinition {
    requestUser user;

    public servicioDefinition() {
        user = new requestUser();
    }

    @Dado("que configuro las cabecera")
    public void queConfiguroLasCabecera() {
        user.getUsers();
    }

    @Cuando("mostrar el listado de usuarios")
    public void mostrarElListadoDeUsuarios() {
        ResponseBody body= requestUser.RespuestaUsers;
        //System.out.println(body.asString());

    }

    @Y("validar codigo de respuesta {string}")
    public void validarCodigoDeRespuesta(String codigo) {
        Assert.assertEquals(Integer.parseInt(codigo),requestUser.RespuestaUsers.getStatusCode());
    }

    @Entonces("validar numero de registros")
    public void validarNumeroDeRegistros() {
        ResponseBody body= requestUser.RespuestaUsers;
        JsonPath json = new JsonPath(body.asString());
        List<String>  listado = json.with(body.asString()).get("data");
        int cantidad = json.getInt("per_page");
        Assert.assertEquals(cantidad,listado.size());
    }

    @Dado("listar con usuario con id {string}")
    public void listarConUsuarioConId(String id) {
        user.getUser(id);

    }

    @Cuando("mostrar la informacion del usuario")
    public void mostrarLaInformacionDelUsuario() {
        mostrarElListadoDeUsuarios();
    }

    @Entonces("validar informacion de la consulta")
    public void validarInformacionDeLaConsulta(DataTable user) {
        ResponseBody body= requestUser.RespuestaUsers;
        JsonPath json = new JsonPath(body.asString()).setRootPath("data");
        List<Map<String,String>> data = user.asMaps(String.class,String.class);
        for (int i = 0; i <data.size() ; i++) {
            Assert.assertEquals(data.get(i).get("codigo"),json.getString("id"));
            Assert.assertEquals(data.get(i).get("email"),json.getString("email"));
            Assert.assertEquals(data.get(i).get("nombre"),json.getString("first_name"));
            Assert.assertEquals(data.get(i).get("apellido"),json.getString("last_name"));
        }


    }

    @Dado("que no existe usuario registrado")
    public void queNoExisteUsuarioRegistrado() {

    }

    @Cuando("registro datos del usuario")
    public void registroDatosDelUsuario(DataTable dt) {
        List<Map<String,String>> data = dt.asMaps(String.class,String.class);
        for (int i = 0; i <data.size() ; i++) {
            user.crearUsuario(data.get(i).get("nombre"),data.get(i).get("cargo"));
            validarCodigoDeRespuesta(data.get(i).get("codigo"));
            mostrarElListadoDeUsuarios();

        }


    }

    @Entonces("muestro los usuario registro")
    public void muestroLosUsuarioRegistro() {

        mostrarElListadoDeUsuarios();
    }



    @Dado("que el usuario este registrado")
    public void queElUsuarioEsteRegistrado() {

    }

    @Cuando("actualizar datos del usuario")
    public void actualizarDatosDelUsuario(DataTable dt) {
        List<Map<String, String>> data = dt.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            user.actualizarUsuarioPut(data.get(i).get("id"),data.get(i).get("nombre"), data.get(i).get("puesto"));
            validarCodigoDeRespuesta(data.get(i).get("codigo"));

        }
    }




}
