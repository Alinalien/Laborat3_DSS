/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reader;


import java.io.File;
import Collection.Reactor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author Alina
 */
public class YAML extends BaseReader {
    @Override
    public String read(String fileName, ArrayList<Reactor> collection) {
        InputStream inputStream = null;
        try {
            String source = "yaml";
            inputStream = new FileInputStream(new File(fileName));
            Yaml yaml = new Yaml();
            ArrayList<LinkedHashMap<String,Object>> data = yaml.load(inputStream);
            for (LinkedHashMap<String,Object> d: data){
                collection.add(new Reactor(d, source));
            }
            return "yaml";
        } catch (Exception ex) {
            return super.read(fileName, collection);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
            }
        }
    }
 }
    
