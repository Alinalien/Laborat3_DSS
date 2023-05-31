/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Collection;

import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Alina
 */
public class C_manipulation {
    private final ArrayList<Reactor> reactor;
    
    public C_manipulation(){
        
        reactor = new ArrayList<>();
    }
        
    public void clearCollection(){
        this.reactor.clear();
    }
    
    public ArrayList<Reactor> getCollection(){
        return reactor;
    }
    
    public ArrayList<String> getReactorTypes(){
        return ReactorTypes.getType();
    }
    
    
    private Reactor getReactorByType(String type){        
        for (Reactor r : reactor) {
            if (r.getName().equals(type)) {
                return r;
            }
        }
        return reactor.get(reactor.size()-1);
    }
    
    public double getBurnupByReactor(String type){
        type = type.trim();
        return getReactorByType(type).getBurnup();
    }
    
    
    public double getFirstLoadByReactor(String type){
        type = type.trim();
        return getReactorByType(type).getFirst_load();
    }
    
    public DefaultMutableTreeNode addInfoToTree(){        
        DefaultMutableTreeNode main = new DefaultMutableTreeNode("Реакторы");
        for (Reactor r: reactor){
            main.add(r.getNode());
        }
        return main;
    }
}
