
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ThreadDemo implements Runnable {


    public void run() {

        String urlPath = "http://192.168.1.16:3000/dishes/amran";
        try {

            URL url = new URL(urlPath);
            HttpURLConnection http_conn;
            http_conn = (HttpURLConnection)url.openConnection();
            http_conn.setRequestMethod("POST");

            http_conn.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(http_conn.getOutputStream());

            wr.flush();
            wr.close();

            int response = http_conn.getResponseCode();
            System.out.println(response);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}









