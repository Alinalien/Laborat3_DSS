/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reader;


import com.google.gson.Gson;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import Collection.Reactor;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Alina
 */
public class JSON extends BaseReader {    

    @Override
    public String read(String fileName, ArrayList<Reactor> collection) {
       try {
            String source = "json";
            
            JSONArray jsonArray = (JSONArray) new JSONParser().parse(new FileReader(fileName));
            for (int i = 0; i < jsonArray.size(); i++) {
                Reactor newReactor = new Gson().fromJson(jsonArray.get(i).toString(), Reactor.class);
                newReactor.setSource(source);
                collection.add(newReactor);
            }
            return "json";
        } catch (JsonSyntaxException | IOException | ParseException ex) {
            return super.read(fileName, collection);
        } 
    }
  }



    
