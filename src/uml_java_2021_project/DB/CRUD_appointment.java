/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml_java_2021_project.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import uml_java_2021_project.Model.Appointment;
import uml_java_2021_project.Model.Patient;

/**
 *
 * @author Fadwa
 */
public class CRUD_appointment {

    Statement stmt;
    ArrayList persons = new ArrayList<>();

    public CRUD_appointment() throws SQLException {
        String username = "root";
        String password = "";
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", username, password);
        stmt = con.createStatement();

    }

    public Connection CRUD_appointment() throws SQLException {
        String username = "root";
        String password = "";
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", username, password);
        stmt = con.createStatement();
        return con;
    }

    public ArrayList<Appointment> getAppointments() throws SQLException {
        ArrayList<Appointment> appointments = new ArrayList<>();
        String query = "select * from appointment";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String patient_name = rs.getString("Patient_name");
            int age = rs.getInt("Age");
            String gender = rs.getString("gender");
            String tel = rs.getString("tel");
            String is_first_visit = rs.getString("is_first_visit");
            String details = rs.getString("Details");
            Date d = rs.getDate("DateOfApp");
            java.sql.Date ds = new java.sql.Date(d.getTime());
            Appointment a = new Appointment(patient_name, age, gender, tel, is_first_visit, details, ds);
            //add a var medical record that links this table to the medical record table
            appointments.add(a);
        }
        return appointments;
    }

    public Appointment get_app_by_patient_name(String name) throws SQLException {
        String query = "select * from appointment where patient_name like '" + name + "'";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String patient_name = name;
            int age = rs.getInt("Age");
            String gender = rs.getString("gender");
            String tel = rs.getString("tel");
            String is_first_visit = rs.getString("is_first_visit");
            String details = rs.getString("Details");
            Date d = rs.getDate("DateOfApp");
            Appointment a = new Appointment(patient_name, age, gender, tel, is_first_visit, details, d);
            return a;
        }
        return null;
    }

    public boolean add_appointment(Appointment p) throws SQLException {
        java.sql.Date ds = new java.sql.Date(p.getDate().getTime());
        String query = "insert into appointment(Patient_name,Age,Gender,tel,is_first_visit,Details,DateOfApp) values ('" + p.getPatient_name() + "','" + p.getAge() + "','" + p.getGender() + "','" + p.getTel() + "','" + p.isFirst_visit() + "','" + p.getDetails() + "','" + ds + "')";
        int nbUpdated = stmt.executeUpdate(query);
        return nbUpdated != 0;
    }

    public boolean delete_appointment(String patient_name) throws SQLException {
        String queryd = "delete from appointment where Patient_name like '" + patient_name + "'";
        int nbUpdated = stmt.executeUpdate(queryd);
        return nbUpdated != 0;
    }

    public void modify_appointment_date(String nom, java.sql.Date d) throws SQLException {
        String query1 = "update appointment set  DateOfApp= '" + d + "'" + " where  patient_name like '" + nom + "';";
        stmt.executeUpdate(query1);
        System.out.println("Your appointment has been modified!");
    }
}
