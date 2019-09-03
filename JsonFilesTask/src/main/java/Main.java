import com.fasterxml.jackson.databind.ObjectMapper;
import http.MyHttpClient;
import pojo.JsonFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyHttpClient httpClient = new MyHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        List<JsonFile> files = httpClient.getPosts();

        files.forEach(jsonFile -> {
            try {
                mapper.writeValue(new File(System.getProperty("user.dir") + "\\files\\" + jsonFile.getId() + ".json"), jsonFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
