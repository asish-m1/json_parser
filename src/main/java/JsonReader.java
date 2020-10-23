import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonReader {

    public static void main(String[] args){
        String file = "myJson.json";
        TestCase[] tc = readWithGson(file);
        tc[0].getTcId();
        System.out.println(tc[4].toString());
    }

    public static TestCase[] readWithGson(String file){
        Gson gson = new Gson();
        TestCase[] tc = null;
        try (Reader reader = new FileReader(file)) {
            tc =  gson.fromJson(reader, TestCase[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tc;
    }
}

