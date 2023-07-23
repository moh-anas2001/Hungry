/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBO;

import javax.swing.JOptionPane;
//import java.sql.*;

/**
 *
 * @author moham
 */
public class Tables {
    public static void main(String args[]){
        try{
            String userTable = "CREATE TABLE user (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(200), email VARCHAR(200) UNIQUE, mobileNumber VARCHAR(200), address VARCHAR(200), password VARCHAR(200), securityQuestion VARCHAR(200), Answer VARCHAR(200), status VARCHAR(20));";
            String adminDetails = "insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('Admin','admin@gmail.com','1234567890','India','admin','1-5','12345','true')";
            String categoryTable = "create table category(id int AUTO_INCREMENT primary key,name varchar(200))";
            String productTable = "create table product(id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200),price varchar(200))";
            String billTable = "create table bill(id int primary key,name varchar(200),mobileNumber varchar(100),email varchar(100),date varchar(50),total varchar (200),CreatedBy varchar(200))";
    //       DBOperations.setDataOrDelete(userTable,"user Table Created Successfully");
    //       DBOperations.setDataOrDelete(adminDetails,"Admin Details Created Successfully");
    //       DBOperations.setDataOrDelete(categoryTable,"Category Table Created Successfully");
    //       DBOperations.setDataOrDelete(billTable,"bill Table Created Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
}
