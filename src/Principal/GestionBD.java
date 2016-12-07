/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author JesT
 */
public class GestionBD 
{
    String usuario="root";
    String baseDatos="empresa";
    String contrasena="12345";
    String url="jdbc:mysql://localhost:3306/"+baseDatos;
    Connection conexion;
    Statement sentencia;
    
public void conectar(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conexion = DriverManager.getConnection(url,usuario,contrasena);
        sentencia = conexion.createStatement();
       
    }catch(ClassNotFoundException | SQLException e){
        System.err.println("Error:"+e);
    }
    System.out.println("Conexion realizada con exito!");
}   

public void insertar()
    {
    String sql = "INSERT INTO cliente(nombre, apellido)"
            + "VALUES('Benito','Camellot') ";
    try
    {
        conectar();
        sentencia.executeUpdate(sql);
        System.out.println("Datos ingresados con exito!!");
        sentencia.close();
    }catch(Exception e){
        System.err.println("Error: " + e);
    }
    }


PreparedStatement sentenciaPreparada=null;
ResultSet conjuntoResultados = null;

public void leer()
{
    String sql = "SELECT * FROM cliente";
    try{
        
        conectar();
        sentenciaPreparada = conexion.prepareStatement(sql);
        conjuntoResultados = sentenciaPreparada.executeQuery();
        
        while(conjuntoResultados.next()){
            System.out.println(conjuntoResultados.getInt(1));
            System.out.println(conjuntoResultados.getString(2));
            System.out.println(conjuntoResultados.getString(3));
            
        }
        
        conjuntoResultados.close();
        
    }catch(Exception e){
       System.err.println("Error: " + e); 
    }
}
    
}
