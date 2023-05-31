/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reader;

import java.util.ArrayList;
import Collection.Reactor;

/**
 *
 * @author Alina
 */
public class BaseReader implements Reader {
    
    private Reader next = null;

    @Override
    public void setNext(Reader r) {
        next = r;
    }

    @Override
    public String read(String fileName, ArrayList<Reactor> collection) {
      if (next != null){
            return next.read(fileName, collection);
        }
        return "Файл не прочитан";  
    }
    
}
