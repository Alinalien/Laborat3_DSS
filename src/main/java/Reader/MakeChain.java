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
public class MakeChain {
    private final Reader r1;
    private final Reader r2;
    private final Reader r3;
    
    public MakeChain() {
        r1 = new JSON();
        r2 = new YAML();
        r3 = new XML();
        r1.setNext(r2);
        r2.setNext(r3);        
    }
    public String readByChain(String fileName, ArrayList<Reactor> collection){
        return r1.read(fileName, collection);
    }
}
