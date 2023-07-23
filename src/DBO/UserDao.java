/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBO;
import Model.User;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author MOHAMED ANAS A
 */

/*REGISTER*/

public class UserDao {
    public static void save(User user){
        String query = "INSERT INTO user (name, email, mobileNumber, address, password, securityQuestion, answer, status) VALUES ('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobileNumber()+"','"+user.getAddress()+"','"+user.getPassword()+"','"+user.getSecurityQuestion()+"','"+user.getAnswer()+"','true')";
        DBOperations.setDataOrDelete(query,"Registered  Successfully!");
    }
    
    
    /*LOGIN*/
    public static User login(String email,String password){
        User user = null;
        try{
           ResultSet rs = DBOperations.getData("select*from user where email='"+email+"'and password='"+password+"'");
           while (rs.next()){
               user = new User();
               user.setStatus(rs.getString("status"));
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
        return user;
    }
    
    public static User getSecurityQuestion(String email){
        User user = null;
        try{
            ResultSet rs = DBOperations.getData("select*from user where email ='"+email+"'");
            while(rs.next()){
                user = new User();
                user.setSecurityQuestion(rs.getString("SecurityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    
    public static void update(String email,String newPassword){
        String query = "Update user set password = '" + newPassword + "' where email = '" + email + "'";
        DBOperations.setDataOrDelete(query,"Password Changed Sucessfully");
    }
    
    public static ArrayList<User> getAllRecords(String email){
        ArrayList<User> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DBOperations.getData("select * from user where email like '%"+email+"%'");
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setAddress(rs.getString("address"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
        
    }
    
    public static void changeStatus(String email,String status){
        String query = "update user set status='"+status+"'";
        DBOperations.setDataOrDelete(query, "Status Changed Successfully");
    }
    
    public static void changePassword(String email,String oldPassword,String newPassword){
        try{
            ResultSet rs = DBOperations.getData("select * from user where email='"+email+"' and password = '"+oldPassword+"'");
            if (rs.next()){
                update(email, newPassword);
            }
            else{
                JOptionPane.showMessageDialog(null,"Old Password is wrong");
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
    }
    
}



