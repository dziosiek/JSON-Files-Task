package http;

import pojo.JsonFile;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class MyHttpClient {
    private static final String REST_URI
            = "https://jsonplaceholder.typicode.com/posts";
    private Client client = ClientBuilder.newClient();

    public List<JsonFile> getPosts(){
        return client.target(REST_URI).request(MediaType.APPLICATION_JSON).get(new GenericType<List<JsonFile>>() {});
    }
}
