/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coneccao;
import java.sql.Connection;
/**
 *
 * @author User
 */
public class Teste extends ConectionFactory{
    public static void main(String[] args) {
        ConectionFactory c = new ConectionFactory();
        Connection conn = c.getConnection();
        System.out.println("deu certo");
        
        
        

    }
    
}
