package edu.upc.dsa;

import java.sql.*;

/**
 * Created by marcelus on 1/10/15.
 */
public class MySQLTablaPieces implements PapaBD {


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
            resultSet = statement.executeQuery("select * from feedback.Pieces");
            //feedback.comments,
            writeResultSetPieces(resultSet);
        } catch (Exception e) {
        } finally {
            close();
        }
    }

    private void writeResultSetPieces(ResultSet resultSet) throws Exception{
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            int code = resultSet.getInt("Code");
            String Name = resultSet.getString("Name");
            System.out.println("Code: " + code+ " Name: "+Name );
            //System.out.println("Name: " + Name);
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
