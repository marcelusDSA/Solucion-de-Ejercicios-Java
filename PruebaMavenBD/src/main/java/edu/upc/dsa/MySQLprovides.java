package edu.upc.dsa;

import java.sql.*;

/**
 * Created by marcelus on 1/10/15.
 */
public class MySQLprovides implements PapaBD {



    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() {
        try {
            // Esto cargará el controlador MySQL, cada DB tiene su propio controlador
            Class.forName("com.mysql.jdbc.Driver");
            // Configuración de la conexión con el DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost/feedback?" + "user=sqluser&password=sqluserpw");

            // Statements allow to issue SQL queries to the database
            //Las declaraciones permiten realizar consultas SQL a la base de datos
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            //Conjunto de resultados obtener el resultado de la consulta SQL
            resultSet = statement.executeQuery("select * from feedback.Provides");
            //feedback.comments,
            writeResultSetProvides(resultSet);

            resultSet = statement.executeQuery("select Piece, avg(Price) from feedback.Provides group by Piece;");
            writePrecioMedioDeCadaPieza(resultSet);
        } catch (Exception e) {
        } finally {
            close();
        }
    }

    private void writeResultSetProvides(ResultSet resultSet) throws Exception{
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            int Piece = resultSet.getInt("Piece");
            String Provider = resultSet.getString("Provider");
            int Price = resultSet.getInt("Price");
            System.out.println("Piece : " + Piece+ " Provider : "+Provider+" Price: "+Price);
        }
    }
    private void writePrecioMedioDeCadaPieza(ResultSet resultSet) throws Exception{
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            int Piece = resultSet.getInt("Piece");
             Double Avg = resultSet.getDouble("AVG(Price)");
            System.out.println("Piece : " + Piece+ " AVG(Price): "+Avg);
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}

