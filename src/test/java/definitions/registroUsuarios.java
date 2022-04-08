package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.Assert;
import support.requestRegister;
import support.requestUser;

import java.util.List;
import java.util.Map;

public class registroUsuarios {
    requestRegister user;

    public registroUsuarios() {
        user = new requestRegister();
    }

    @Dado("que registros los usuarios")
    public void queRegistrosLosUsuarios(DataTable dt) {
        List<Map<String, String>> data = dt.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            user.registrarUsuario(data.get(i).get("correo"), data.get(i).get("clave"));
            validarCodigoDeRespuestaRegistro(data.get(i).get("codigo"));


        }


    }

    @Y("validar codigo de respuesta registro {string}")
    public void validarCodigoDeRespuestaRegistro(String codigo) {
        Assert.assertEquals(Integer.parseInt(codigo),requestRegister.RespuestaRegister.getStatusCode());
    }

    @Entonces("muestro los usuario registrados")
    public void muestroLosUsuarioRegistrados() {

    }



}
