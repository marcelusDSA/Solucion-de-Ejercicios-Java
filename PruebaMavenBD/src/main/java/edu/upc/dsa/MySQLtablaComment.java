package edu.upc.dsa;

import java.sql.*;

/**
 * Created by marcelus on 1/10/15.
 */
public class MySQLtablaComment implements  PapaBD {
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
            resultSet = statement.executeQuery("select * from feedback.comments");
            //feedback.comments,
            writeResultSetcomments(resultSet);

            // PreparedStatements can use variables and are more efficient
            //PreparedStatements puede utilizar variables y son más eficientes
            preparedStatement = connect.prepareStatement("insert into  feedback.comments values (default, ?, ?, ?, ? , ?, ?)");
            // "myuser, webpage, datum, summery, COMMENTS from feedback.comments");
            // Parameters start with 1
            preparedStatement.setString(1, "Test");
            preparedStatement.setString(2, "TestEmail");
            preparedStatement.setString(3, "TestWebpage");
            preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
            preparedStatement.setString(5, "TestSummary");
            preparedStatement.setString(6, "TestComment");
            preparedStatement.executeUpdate();

            //Es irrelevante si le pines en el comanda sql la columna en mayusculas o minusculas
            preparedStatement = connect.prepareStatement("SELECT myuser, webpage, datum, SUMMARY, COMMENTS from feedback.comments");
            resultSet = preparedStatement.executeQuery();
            writeResultSetcomments(resultSet);

            // Remove again the insert comment
            preparedStatement = connect.prepareStatement("delete from feedback.comments where myuser= ? ; ");
            //preparedStatement = connect.prepareStatement("delete from feedback.comments where SUMMARY= ? ; ");
            preparedStatement.setString(1, "Test");
            preparedStatement.executeUpdate();

            resultSet = statement.executeQuery("select * from feedback.comments");
            writeMetaData(resultSet);

        } catch (Exception e) {
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //   Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSetcomments(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String user = resultSet.getString("myuser");
            String website = resultSet.getString("webpage");
            String summery = resultSet.getString("summary");
            java.util.Date date = resultSet.getDate("datum");
            String comment = resultSet.getString("comments");
            System.out.println("User: " + user);
            System.out.println("Website: " + website);
            System.out.println("Summary: " + summery);
            System.out.println("Date: " + date);
            System.out.println("Comment: " + comment);
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

