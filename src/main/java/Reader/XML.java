/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reader;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import Collection.Reactor;

/**
 *
 * @author Alina
 */
public class XML extends BaseReader {

    @Override
    public String read(String fileName, ArrayList<Reactor> collection) {
        try {
            String source = "xml";
            fileName = "file:\\" + fileName;
            DocumentBuilder docB = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            org.w3c.dom.Document doc = docB.parse(fileName);
            
            NodeList reactorsList = doc.getDocumentElement().getChildNodes();
            System.out.println(source);
            for (int i = 0; i < reactorsList.getLength(); i++) {
                Node r = reactorsList.item(i);
                if (r.getNodeType() != Node.TEXT_NODE) {
                    
                    NodeList rPar = r.getChildNodes();
                    ArrayList<String> info = new ArrayList<>();
                    for(int j = 0; j < rPar.getLength(); j++) {
                        Node param = rPar.item(j);
                        if (param.getNodeType() != Node.TEXT_NODE) {info.add(param.getChildNodes().item(0).getTextContent());}
                    }
                    collection.add(new Reactor(info, source));
                }
            }
            return "xml";
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            return super.read(fileName, collection);
        }
    }
    }
    

    
