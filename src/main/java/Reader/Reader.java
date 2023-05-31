/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reader;

import java.io.File;
import java.util.ArrayList;
import Collection.Reactor;

/**
 *
 * @author Alina
 */
public interface Reader {

//    public String getFileType(String fileName);
//    public ArrayList<Reactor> getReactor();
//    public void readFile(File file);
//    public void setNeighbour(Reader reader);
    
     public void setNext(Reader r);
     public String read(String fileName, ArrayList<Reactor> collection);
}
