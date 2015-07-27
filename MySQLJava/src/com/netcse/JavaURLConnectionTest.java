package com.netcse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class JavaURLConnectionTest {
    public static void main(String args[]) {
        String urlCallStr = "http://mysafeinfo.com/api/data?list=englishmonarchs&format=json";
        System.out.println(
                "output: " +
                        callURL(urlCallStr)
        );
    }

    private static String callURL(String myURL) {
        System.out.println("Requested URL : " +
                        myURL
        );
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn;
        InputStreamReader in = null;
        try {
            URL url = new URL(myURL);
            urlConn = url.openConnection();
            if (urlConn != null)
                urlConn.setReadTimeout(0);
                // but urlConn.setReadTimeout(10) does not
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(),
                        Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
        } catch (Exception e) {
            throw new RuntimeException("Exception is happening : " + myURL, e);
        }
        return sb.toString();
    }
}
