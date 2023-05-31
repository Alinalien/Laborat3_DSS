/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Collection;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
/**
 *
 * @author Alina
 */
public class Reactor {

    private String name;
    private double burnup;                 // глубина выгорания
    private double kpd;                    // КПД
    private double enrichment;             // обогащение
    private double termal_capacity;        // тепловая мощность
    private double electrical_capacity;    // электрическая мощность
    private double life_time;              // срок службы
    private double first_load;             // первый запуск
    private String source;
    
    public Reactor(){
    }
    
    public Reactor(String name, double burnup, double kpd, double enrichment, int termal_capacity, double electrical_capacity, 
                    int life_time, double first_load, String source) {
        this.name = name;
        this.burnup = burnup;
        this.kpd = kpd;
        this.enrichment = enrichment;
        this.termal_capacity = termal_capacity;
        this.electrical_capacity = electrical_capacity;
        this.life_time = life_time;
        this.first_load = first_load;
        this.source = source;
    }

    public Reactor(ArrayList<String> info, String source) {        // для XML
        int tempID = 0;
        this.name = info.get(tempID++);        
        this.burnup = Double.parseDouble(info.get(tempID++));
        this.kpd = Double.parseDouble(info.get(tempID++));
        this.enrichment = Double.parseDouble(info.get(tempID++));
        this.termal_capacity = Double.parseDouble(info.get(tempID++));
        this.electrical_capacity = Double.parseDouble(info.get(tempID++));
        this.life_time = Double.parseDouble(info.get(tempID++));
        this.first_load = Double.parseDouble(info.get(tempID++));
        this.source = source;
    }

    public Reactor(LinkedHashMap<String, Object> d, String source) {        // для YAML
        this.name = (String) d.get("name");
        this.burnup = (double) d.get("burnup");
        this.kpd = (double) d.get("kpd");
        this.enrichment = (double) d.get("enrichment");
        this.termal_capacity = (double) d.get("termal_capacity");
        this.electrical_capacity = (double) d.get("electrical_capacity");
        this.life_time = (double) d.get("life_time");
        this.first_load = (double) d.get("first_load");
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBurnup() {
        return burnup;
    }

    public void setBurnup(double burnup) {
        this.burnup = burnup;
    }

    public double getKpd() {
        return kpd;
    }

    public void setKpd(double kpd) {
        this.kpd = kpd;
    }

    public double getEnrichment() {
        return enrichment;
    }

    public void setEnrichment(double enrichment) {
        this.enrichment = enrichment;
    }

    public double getTermal_capacity() {
        return termal_capacity;
    }

    public void setTermal_capacity(double termal_capacity) {
        this.termal_capacity = termal_capacity;
    }

    public double getElectrical_capacity() {
        return electrical_capacity;
    }

    public void setElectrical_capacity(double electrical_capacity) {
        this.electrical_capacity = electrical_capacity;
    }

    public double getLife_time() {
        return life_time;
    }

    public void setLife_time(double life_time) {
        this.life_time = life_time;
    }

    public double getFirst_load() {
        return first_load;
    }

    public void setFirst_load(double first_load) {
        this.first_load = first_load;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    
    public MutableTreeNode getNode() {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(this.name);
        node.add(new DefaultMutableTreeNode("burnup: " + this.burnup));
        node.add(new DefaultMutableTreeNode("kpd: " + this.kpd));
        node.add(new DefaultMutableTreeNode("enrichment: " + this.enrichment));
        node.add(new DefaultMutableTreeNode("termal_capacity: " + this.termal_capacity));
        node.add(new DefaultMutableTreeNode("electrical_capacity: " + this.electrical_capacity));
        node.add(new DefaultMutableTreeNode("life_time: " + this.life_time));
        node.add(new DefaultMutableTreeNode("first_load: " + this.first_load));
        node.add(new DefaultMutableTreeNode("from: " + this.source));
        return node;
    }
    
    }


