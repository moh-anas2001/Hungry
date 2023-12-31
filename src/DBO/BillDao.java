/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBO;

import Model.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author moham
 */
public class BillDao {
    public static String getId(){
        int id = 1;
        try{
            ResultSet rs = DBOperations.getData("select max(id) from bill");
            if(rs.next()){
                id = rs.getInt(1);
                id = id +1;
                
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }
    public static void save(Bill bill){
        String query = "insert into bill values('"+bill.getId()+"','"+bill.getName()+"','"+bill.getMobileNumber()+"','"+bill.getEmail()+"','"+bill.getDate()+"','"+bill.getTotal()+"','"+bill.getCreatedBy()+"')";  
     //   DBOperations.setDataOrDelete(query, "Bill details added successfully");
    }
    
    public static ArrayList<Bill> getAllRecordsByINC(String date){
        ArrayList<Bill> arraylist = new ArrayList<>();
        try{
            ResultSet rs = DBOperations.getData("select * from bill where date like '%"+date+"%'");
            while (rs.next()){
             Bill bill = new  Bill();
             bill.setId(rs.getInt("id"));
             bill.setName(rs.getString("name"));
             bill.setMobileNumber(rs.getString("mobileNumber"));
             bill.setEmail(rs.getString("email"));
             bill.setDate(rs.getString("date"));
             bill.setTotal(rs.getString("total"));
             bill.setCreatedBy(rs.getString("createdBy"));
             arraylist.add(bill);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arraylist;
        } 
    
        public static ArrayList<Bill> getAllRecordsByDESC(String date){
        ArrayList<Bill> arraylist = new ArrayList<>();
        try{
            ResultSet rs = DBOperations.getData("select * from bill where date like '%"+date+"%' order by id DESC ");
            while (rs.next()){
             Bill bill = new  Bill();
             bill.setId(rs.getInt("id"));
             bill.setName(rs.getString("name"));
             bill.setMobileNumber(rs.getString("mobileNumber"));
             bill.setEmail(rs.getString("email"));
             bill.setDate(rs.getString("date"));
             bill.setTotal(rs.getString("total"));
             bill.setCreatedBy(rs.getString("createdBy"));
             arraylist.add(bill);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arraylist;
        }
}
