/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Table;

/**
 *
 * @author Alina
 */
public class Example {
    private String name;
    private Double annuel_fuel;

    public Example() {
        name = "";
        annuel_fuel = 0.0;
    }

    public Example(String name, Double annuel_fuel) {
        this.name = name;
        this.annuel_fuel = annuel_fuel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAnnuel_fuel() {
        return annuel_fuel;
    }

    public void setAnnuel_fuel(Double annuel_fuel) {
        this.annuel_fuel = annuel_fuel;
    }
    
}
