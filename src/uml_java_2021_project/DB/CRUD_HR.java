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
import uml_java_2021_project.Model.HR;
import uml_java_2021_project.Model.Patient;

/**
 *
 * @author Fadwa
 */
public class CRUD_HR {

    Statement stmt;
    ArrayList persons = new ArrayList<>();

    public CRUD_HR() throws SQLException {
        String username = "root";
        String password = "";
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", username, password);
        stmt = con.createStatement();

    }

    public Connection CRUD_HR() throws SQLException {
        String username = "root";
        String password = "";
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", username, password);
        stmt = con.createStatement();
        return con;
    }

    public ArrayList<HR> getHRs() throws SQLException {
        ArrayList<HR> HRS = new ArrayList<>();
        String query = "select * from health_record";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            String gender = rs.getString("gender");
            float height = rs.getFloat("height");
            float weight = rs.getFloat("weight");
            Date birthdate = rs.getDate("birthdate");
            Date visit_date = rs.getDate("visit_date");
            String diagnostic = rs.getString("diagnostic");
            String treatment = rs.getString("treatment");
            String details = rs.getString("details");
            HR hr = new HR(first_name, last_name,gender, weight, height,birthdate, visit_date, diagnostic, treatment, details);
            HRS.add(hr);
        }
        return HRS;
    }

    public HR getHR_by_name(String nm) throws SQLException {
        String query = "select * from health_record where first_name like '" + nm + "'";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String last_name = rs.getString("last_name");
            String gender = rs.getString("gender");
            float height = rs.getFloat("height");
            float weight = rs.getFloat("weight");
            Date birthdate = rs.getDate("birthdate");
            Date visit_date = rs.getDate("visit_date");
            String diagnostic = rs.getString("diagnostic");
            String treatment = rs.getString("treatment");
            String details = rs.getString("details");
            HR hr = new HR(nm, last_name, gender,weight, height, birthdate, visit_date, diagnostic, treatment, details);
            return hr;
        }
        return null;
    }

    public boolean add_HR(HR h) throws SQLException {
        java.sql.Date ds = new java.sql.Date(h.getBirthdate().getTime());
        java.sql.Date ds2 = new java.sql.Date(h.getDate_visit().getTime());

        String query = "insert into health_record(first_name, last_name,gender,weight,height,birthdate,visit_date,diagnostic,treatment,details) values ('" + h.getFirst_name() + "','" + h.getLast_name() + "','" + h.getHeight() + "','" + h.getWeight() + "','" + h.getGender() +"','"+ ds + "','" + ds2 + "','" + h.getDiagnostic() + "','" + h.getTreatment() + "','" + h.getDetails() + "')";
        int nbUpdated = stmt.executeUpdate(query);
        return nbUpdated != 0;
    }

    public boolean delete_HR(String name) throws SQLException {
        String queryd = "delete from health_record where first_name like '" + name + "'";
        int nbUpdated = stmt.executeUpdate(queryd);
        return nbUpdated != 0;
    }

    public void modify_patient_nom(String CIN, String nom) throws SQLException {
        String query1 = "update patient set nom = '" + nom + "'" + " where patient.CIN = '" + CIN + "';";
        stmt.executeUpdate(query1);
        System.out.println("Your patient has been modified!");
    }

    public void modify_patient_prenom(Patient p, String prenom) throws SQLException {
        String query1 = "update patient set prenom = '" + prenom + "'" + " where patient.CIN = '" + p.getCIN() + "';";
        stmt.executeUpdate(query1);
        System.out.println("Your patient has been modified!");
    }

    public void modify_patient_CIN(Patient p, String cin) throws SQLException {
        String query1 = "update patient set CIN = '" + cin + "'" + " where patient.CIN = '" + p.getCIN() + "';";
        stmt.executeUpdate(query1);
        System.out.println("Your patient has been modified!");
    }

    public void modify_patient_tel(Patient p, String tel) throws SQLException {
        String query1 = "update patient set tel = '" + tel + "'" + " where patient.CIN = '" + p.getCIN() + "';";
        stmt.executeUpdate(query1);
        System.out.println("Your patient has been modified!");
    }

    public void modify_patient_email(Patient p, String email) throws SQLException {
        String query1 = "update patient set email = '" + email + "'" + " where patient.CIN = '" + p.getCIN() + "';";
        stmt.executeUpdate(query1);
        System.out.println("Your patient has been modified!");
    }
}
