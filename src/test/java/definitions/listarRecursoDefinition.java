package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import support.requestResource;


import java.util.List;
import java.util.Map;

public class listarRecursoDefinition {
    requestResource resource;

    public listarRecursoDefinition() {
        resource = new requestResource();
    }

    @Dado("que listo los recursos")
    public void que_listo_los_recursos() {
      resource.getResources();

    }
    @Cuando("muestro el listado de recursos")
    public void muestro_el_listado_de_recursos() {
        ResponseBody body = requestResource.RespuestaResource;

    }
    @Cuando("valido con codigo de respuesta {string}")
    public void valido_con_codigo_de_respuesta(String codigo) {
        Assert.assertEquals(Integer.parseInt(codigo), requestResource.RespuestaResource.getStatusCode());


    }
    @Entonces("valido el numero de recursos")
    public void valido_el_numero_de_recursos() {
        ResponseBody body = requestResource.RespuestaResource;
        JsonPath json = new JsonPath(body.asString());
        List<String> listado = json.with(body.asString()).get("data");
        int cantidad = json.getInt("per_page");
        Assert.assertEquals(cantidad,listado.size());


    }


    @Dado("listar con recurso con id {string}")
    public void listarConRecursoConId(String id) {
        resource.getResource(id);
    }

    @Cuando("mostrar la informacion del recurso")
    public void mostrarLaInformacionDelRecurso() {
        muestro_el_listado_de_recursos();
    }

    @Entonces("validar informacion de la consulta del recurso")
    public void validarInformacionDeLaConsultaDelRecurso(DataTable recurso) {
        ResponseBody body = requestResource.RespuestaResource;
        JsonPath json = new JsonPath(body.asString()).setRootPath("data");
        List<Map<String,String>> data = recurso.asMaps(String.class,String.class);
        for (int i = 0; i <data.size() ; i++) {
            Assert.assertEquals(data.get(i).get("nombre"),json.getString("name"));
            Assert.assertEquals(data.get(i).get("año"),json.getString("year"));
            Assert.assertEquals(data.get(i).get("color"),json.getString("color"));
        }

    }
}
