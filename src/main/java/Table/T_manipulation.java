/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Table;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alina
 */
public class T_manipulation {
    public static void drawModel(ArrayList<Example> parameters, String groupBy, JTable modelOrig){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(groupBy);
        model.addColumn("Ежегодное потребление топлива");
        
        for (int i = 0; i < parameters.size(); i++) {
            Object[] values = new Object[2];
            values[0] = parameters.get(i).getName();
            values[1] = parameters.get(i).getAnnuel_fuel();
            model.addRow(values);
        }
        modelOrig.setModel(model);
    }
}
