package objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class headersToken {

    private String host;
    private String key;


    public headersToken(String host, String key) {
        this.host = host;
        this.key = key;
    }
}
