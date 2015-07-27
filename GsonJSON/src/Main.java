import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class Main {

    public static void gsonWrite() {
        DataObject obj = new DataObject();
        Gson gson = new Gson();

        String json = gson.toJson(obj);

        try {
            FileWriter writer = new FileWriter("out.json");
            writer.write(json);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void gsonRead(){

        Gson gson = new Gson();
        try{
            BufferedReader br = new BufferedReader(new FileReader("out.json"));
            DataObject obj = gson.fromJson(br, DataObject.class);
            System.out.println(obj);
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {

        Main mn = new Main();
        mn.gsonWrite();
        mn.gsonRead();
    }

}

















