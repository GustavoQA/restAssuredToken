package support;

import io.restassured.response.Response;
import objects.headersToken;
import objects.payloadToken;

public class requestToken {
    apiHelper api;
    public static Response respuestaToken;
    payloadToken token;
    headersToken header;
    String valor;
    String parametro;

    public requestToken() {
        api = new apiHelper();
    }

//    public void GenerarToken(String audiencia, String id_cliente, String tipo_grant) {
//        String url = "https://bravenewcoin.p.rapidapi.com/oauth/token";
//        String bodyRequest = "{\n" +
//                "    \"audience\": \"" + audiencia + "\",\n" +
//                "    \"client_id\": \"" + id_cliente + "\",\n" +
//                "    \"grant_type\": \"" + tipo_grant + "\"\n" +
//                "}";
//        token = new payloadToken(audiencia, id_cliente, tipo_grant);
//        respuestaToken = api.postResponseToken(url, bodyRequest);
//
//    }

    public String GeneraCabecera1(String parametro) {

        return this.parametro = parametro;
    }

    public String GeneraCabecera2(String valor) {
        return this.valor = valor;

    }


    public void GenerarTokeen(String audiencia, String id_cliente, String tipo_grant) {
        String url = "https://bravenewcoin.p.rapidapi.com/oauth/token";
        String para = GeneraCabecera1(parametro);
        String val = GeneraCabecera2(valor);
        String bodyRequest = "{\n" +
                "    \"audience\": \"" + audiencia + "\",\n" +
                "    \"client_id\": \"" + id_cliente + "\",\n" +
                "    \"grant_type\": \"" + tipo_grant + "\"\n" +
                "}";
        token = new payloadToken(audiencia, id_cliente, tipo_grant);
        respuestaToken = api.Cabeceras(url, bodyRequest, para, val);

    }


}
