/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coneccao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User
 */
public class ConectionFactory {
    
    public Connection getConnection(){
        try {
            var conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Vango?zeroDateTimeBehavior=CONVERT_TO_NULL&useTimezone=true&serverTimezone=UTC", "root", "1234");
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        
    }
    
}
