/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml_java_2021_project.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import uml_java_2021_project.Model.Bill;

/**
 *
 * @author Fadwa
 */
public class CRUD_payment_bill {

    Statement stmt;

    public CRUD_payment_bill() throws SQLException {
        String username = "root";
        String password = "";
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", username, password);
        stmt = con.createStatement();

    }

    public Connection CRUD_payment_bill() throws SQLException {
        String username = "root";
        String password = "";
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", username, password);
        stmt = con.createStatement();
        return con;
    }

    public boolean add_bill(Bill b) throws SQLException {
        java.sql.Date ds = new java.sql.Date(b.getDate_payment().getTime());
        String query = "insert into bill(cardID, amount,paymentdate) values ('" + b.getCard_id() + "','" + b.getPrice() + "','" + ds + "')";
        int nbUpdated = stmt.executeUpdate(query);
        return nbUpdated != 0;
    }
}
