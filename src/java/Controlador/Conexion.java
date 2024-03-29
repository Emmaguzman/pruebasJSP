/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Persona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author denis
 */
public class Conexion {

    Connection conn;
    ResultSet rs;
    Statement st;
    PreparedStatement prep;

    private void conectar() {
        final String URL = "jdbc:sqlserver://Gamex:1433;databaseName=TestPersonas";
        final String NOM = "Emma";
        final String PASS = "1234";
        try {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection(URL, NOM, PASS);
           

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR EN CONEXION");
        }
    }

    private void cerrar() {

       try {
            if(conn != null && !conn.isClosed())
                conn.close();System.out.println("conn cerrado");            
            if(rs!=null && !rs.isClosed())
                rs.close();System.out.println("rs cerrado");
            if(!st.isClosed() && st!=null)
                st.close();System.out.println("st cerrado");
            
            
        } catch (Exception e) {
            System.out.println("Error al cerrar conexión");
        }
    }
    public Persona traerPersona(int id){
    Persona p=null;
    final String QUERY="select * from personas where id=?";
        try {
            conectar();
            prep=conn.prepareStatement(QUERY);
            prep.setInt(1,id);
            rs=prep.executeQuery();
            while(rs.next()){
            p=new Persona(rs.getInt(1),rs.getString(2),rs.getString(3));            
           
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        cerrar();
        }
    
    return p;
    }

    public ArrayList<Persona> listarPersonas() {
        final String QUERY = "Select * from personas";
        ArrayList<Persona> listado = new ArrayList<Persona>();
        try {
            conectar();
            st = conn.createStatement();
            rs = st.executeQuery(QUERY);
            while (rs.next()) {
                listado.add(new Persona(rs.getInt(1), rs.getString(2),rs.getString(3)));
            }                       
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
            cerrar();
        }
        return listado;
    }

    public boolean agregarPersona(Persona p) {
        boolean inserto = false;
        final String QUERY = "insert into Personas values(?,?)";
        conectar();
        try {
            prep = conn.prepareStatement(QUERY);           
            prep.setString(1,p.getNombre());
            prep.setString(2,p.getApellido());
            
            prep.execute();
            inserto=true;
            System.out.println("Insercion Correcta");
        } catch (Exception e) {
        }finally{
            cerrar();
        }
        return inserto;
    }

}
