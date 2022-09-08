package com.isil.sesion1demo;

import java.sql.*;

public class MainApp {

    public static void main(String[] args) throws Exception {

        //1.cargar driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.Crear conexion
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/TEST",
                "root",
                "root"
        );
        //3.Crear statements
        //Statement stmt= con.createStatement();

        //int resultUpdate = stmt.executeUpdate("update Users set city='Rosario' where name='Messi'");
        //4.Ejecutar resultado
        //ResultSet result = stmt.executeQuery("select * from Users");
        //5.Recorrer resultados
        //while(result.next()){
            //System.out.println(result.getString(2));
        //}


        PreparedStatement preparedStatement = con.prepareStatement("select * from Users where name=? and city=?");

        preparedStatement.setString(1,"Cueva");
        preparedStatement.setString(2,"Lima");

        ResultSet resultSet2 = preparedStatement.executeQuery();

        while (resultSet2.next()){
            System.out.println(resultSet2.getString("name")+ "\n"+
                    resultSet2.getString("phone") + "\n"+
                    resultSet2.getString("city"));
        }


        //6.Cerrar conexion
        con.close();

    }
}
