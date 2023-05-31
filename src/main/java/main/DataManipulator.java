/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Collection.C_manipulation;
import DataBase.DB_connection;
import DataBase.DB_manipulation;
import DataBase.QuariesStorage;
import Reader.MakeChain;
import Reader.TXT;
import Table.Example;
import Table.T_manipulation;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.tree.DefaultMutableTreeNode;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author Alina
 */
public class DataManipulator {
    private final C_manipulation cm;
    private final DB_connection cbd;
    public DataManipulator(JLabel instruction1Label,JLabel exceptionLabel){
        cm = new C_manipulation();
        cbd = new DB_connection();
        QuariesStorage qs = new QuariesStorage();
        
        try {
            Connection conn = cbd.getConnection();
            if (!DB_manipulation.checkTables(conn, QuariesStorage.getQueryFindUnitTable())){
                instruction1Label.setText("Необходимо создать базу данных.");
            } else {
                instruction1Label.setText("База данных создана и заполнена.");
            }
            exceptionLabel.setText("  ");
        } catch (Exception ex) {
            instruction1Label.setText("Необходимо создать базу данных.");
        }
    }
    
    public void readByBuildChain(String fileName, JLabel fileLabel,JLabel exceptionLabel){
        cm.clearCollection();
        MakeChain mc = new MakeChain();
        String source = mc.readByChain(fileName, cm.getCollection());
        fileLabel.setText(source);
        exceptionLabel.setText(""); 
    }
    
    public DefaultMutableTreeNode getMainNode(){
        return cm.addInfoToTree();
    }
    
    public void createDB(JLabel instruction1Label,JLabel exceptionLabel){
        try {
            Connection conn = cbd.getConnection();
            String queryDelete = TXT.read(".\\resources\\deletion.txt");
            String queryCreate = TXT.read(".\\resources\\creation.txt");
            DB_manipulation.doQuery(conn, queryDelete, "Удалена");
            DB_manipulation.doQuery(conn, queryCreate, "Создана");
            instruction1Label.setText("База данных создана. Загрузите данные.");
            exceptionLabel.setText("Не создана");
            
        } catch (SQLException | IOException ex) {
            exceptionLabel.setText("Ошибка:" + ex.getMessage());
        }
    }
    
    public void deleteDB(JLabel instruction1Label,JLabel exceptionLabel){
        try {
            Connection conn = cbd.getConnection();
            String queryDelete = TXT.read(".\\resources\\deletion.txt");
            DB_manipulation.doQuery(conn, queryDelete, "Удалена");
            instruction1Label.setText("Необходимо создать базу данных.");
            exceptionLabel.setText("");
        } catch (SQLException | IOException ex) {
            exceptionLabel.setText("Ошибка:" + ex.getMessage());
        }
    }
    
    public void fillDB(JLabel instruction1Label,JLabel exceptionLabel){
        try {
            Connection conn = cbd.getConnection();
            String fileName = ".\\resources\\ReactorData.xlsx";
            if (!cm.getCollection().isEmpty()){
                exceptionLabel.setText("База данных заполняется");
                DB_manipulation.fillDB1(conn, fileName, cm);
                instruction1Label.setText("База данных создана и заполнена. Можно выполнять расчёт объёма ежегодно потребляемого топлива по различным группировкам (по реакторам, странам, регионам и компаниям).");
                exceptionLabel.setText("");
            } else {                 
                exceptionLabel.setText("Не хватает данных для заполнения базы, выберите файл.");
            }           
        } catch (SQLException | IOException | InvalidFormatException ex) {
            exceptionLabel.setText("Ошибка:" + ex.getMessage());
        } 
    } 
    public void countFuelForEachReactor(JTable fuelTable, JLabel totalFuelLabel, JLabel exceptionLabel){
        try {
            Connection conn = cbd.getConnection();
            ArrayList<Example> parameters = DB_manipulation.getAnnuelFuelReactor(conn, QuariesStorage.getQueryEachReactor());
            T_manipulation.drawModel(parameters, "Реактор", fuelTable);
            totalFuelLabel.setText(String.valueOf(DB_manipulation.getSumAnnuelFuelReactor(conn, QuariesStorage.getQuerySumReactor())));
            exceptionLabel.setText("");
        } catch (SQLException ex) {
            exceptionLabel.setText("Ошибка:" + ex.getMessage());
        }
    }
    
    public void countFuelForCountryReactor(JTable fuelTable, JLabel totalFuelLabel, JLabel exceptionLabel){
        try {
            Connection conn = cbd.getConnection();
            ArrayList<Example> parameters = DB_manipulation.getAnnuelFuelReactor(conn, QuariesStorage.getQueryCountryReactor());
            T_manipulation.drawModel(parameters, "Страна", fuelTable);
            totalFuelLabel.setText(String.valueOf(DB_manipulation.getSumAnnuelFuelReactor(conn, QuariesStorage.getQuerySumReactor())));
            exceptionLabel.setText("");
        } catch (SQLException ex) {
            exceptionLabel.setText("Ошибка:" + ex.getMessage());
        }
    }
    
    public void countFuelForRegionReactor(JTable fuelTable, JLabel totalFuelLabel,JLabel exceptionLabel){
        try {
            Connection conn = cbd.getConnection();
            ArrayList<Example> parameters = DB_manipulation.getAnnuelFuelReactor(conn, QuariesStorage.getQueryRegionReactor());
            T_manipulation.drawModel(parameters, "Регион", fuelTable);
            totalFuelLabel.setText(String.valueOf(DB_manipulation.getSumAnnuelFuelReactor(conn, QuariesStorage.getQuerySumReactor())));
            exceptionLabel.setText("");
        } catch (SQLException ex) {
            exceptionLabel.setText("Ошибка:" + ex.getMessage());
        }
    }
    
    public void countFuelForCompanyReactor(JTable fuelTable, JLabel totalFuelLabel, JLabel exceptionLabel){
        try {
            Connection conn = cbd.getConnection();
            ArrayList<Example> parameters = DB_manipulation.getAnnuelFuelReactor(conn, QuariesStorage.getQueryCompanyReactor());
            T_manipulation.drawModel(parameters, "Компания", fuelTable);
            totalFuelLabel.setText(DB_manipulation.getSumAnnuelFuelReactor(conn, QuariesStorage.getQuerySumReactor()));
            exceptionLabel.setText("");
        } catch (SQLException ex) {
            exceptionLabel.setText("Ошибка:" + ex.getMessage());
        }
    }
}
