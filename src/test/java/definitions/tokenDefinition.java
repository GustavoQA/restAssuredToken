package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import support.requestToken;

import java.util.List;
import java.util.Map;

public class tokenDefinition {
    requestToken token;
   public  String GuardoToken;

    public tokenDefinition() {
        token = new requestToken();
    }

    @Dado("que configuro el bodyrequest del servicio")
    public void queConfiguroElBodyrequestDelServicio(DataTable dt) {
        List<Map<String,String>> data = dt.asMaps(String.class,String.class);
        for (int i = 0; i <data.size() ; i++) {
            token.GenerarTokeen(data.get(i).get("audiencia"),data.get(i).get("id_cliente"),data.get(i).get("grant_type"));
            //validoQueLaRespuestaEs(data.get(i).get("codigo"));
           // mostrarElListadoDeUsuarios();

        }

    }

    @Y("valido que la respuesta es {string}")
    public void validoQueLaRespuestaEs(String codigo) {
        Assert.assertEquals(Integer.parseInt(codigo),requestToken.respuestaToken.statusCode());
    }



    @Dado("que configuro las cabeceras del servicio")
    public void queConfiguroLasCabecerasDelServicio(DataTable dt) {
        List<Map<String, String>> data = dt.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            String parametro = data.get(i).get("parametro");
            String valor = data.get(i).get("valor");
            token.GeneraCabecera1(parametro);
            token.GeneraCabecera2(valor);
        }


    }

    @Entonces("Guardo el token de sesion")
    public void guardoElTokenDeSesion() {
        ResponseBody bodyToken = requestToken.respuestaToken;
        JsonPath json = new JsonPath(bodyToken.asString());
        GuardoToken = json.getString("access_token");
        System.out.println(GuardoToken);
    }


}
