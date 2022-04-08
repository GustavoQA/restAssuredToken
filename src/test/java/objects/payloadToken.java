package objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class payloadToken {

    @JsonProperty(value="audience") private String audiencia;
    @JsonProperty(value="client_id") private String idCliente;
    @JsonProperty(value="grant_type") private String tipoGrant;


    public payloadToken(String audiencia, String idCliente, String tipoGrant) {
        this.audiencia = audiencia;
        this.idCliente = idCliente;
        this.tipoGrant = tipoGrant;
    }
}
