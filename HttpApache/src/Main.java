import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;


public class Main {
    public static void main(String[] args) throws Exception {
        URI uri = new URIBuilder().setScheme("https")
                .setHost("www.google.com/?#q=android")
                .build();
        HttpGet httpGet = new HttpGet(uri);
        System.out.println(httpGet.getURI());
    }
}
