/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Collection;

import java.util.ArrayList;

/**
 *
 * @author Alina
 */
public class ReactorTypes {
     private ArrayList<String> type;
     private static ReactorTypes instance;
             
    private ReactorTypes (){
        type = new ArrayList();
        type.add("MKER");
        type.add("RBMK");
        type.add("VVER-1200");
        type.add("AP1000");
        type.add("BWR");
        type.add("ABWR");
        type.add("EPR");
        type.add("MAGNOX");
        type.add("BN");
        type.add("PWR");
        type.add("CPR-1000");
        type.add("CANDU");
        type.add("PHWR");
        type.add("KLT-40");
    }
    
    public static ArrayList<String> getType() {
     if (instance == null) {
          instance  = new ReactorTypes();
        } 
         return instance.type;  
}
}
