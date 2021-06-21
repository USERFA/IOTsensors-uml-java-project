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
import uml_java_2021_project.Model.Doctor;
import uml_java_2021_project.Model.Patient;
import uml_java_2021_project.Model.User;

/**
 *
 * @author Fadwa
 */
public class CRUD_person {

    Statement stmt;
    ArrayList persons = new ArrayList<>();
    Connection con;

    public CRUD_person() throws SQLException {
        String username = "root";
        String password = "";
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", username, password);
        stmt = con.createStatement();
    }

    public Connection CRUD_person() throws SQLException {
        String username = "root";
        String password = "";
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", username, password);
        stmt = con.createStatement();
        return con;
    }

    public User get_Login(String login, String password) throws SQLException {
//        String query = "select * from login  where username = "+"'"+login+"'"+" and password = "+"'"+password+"'";
        String query = "select * from patient inner join login on patient.login = login.username where login.username like '" + login + "' and login.password like '" + password + "'";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String cni = rs.getString("CIN");
            String tel = rs.getString("tel");
            String email = rs.getString("email");
            String pwd = rs.getString("password");
            Patient p = new Patient(nom, prenom, cni, tel, email);
            p.setPassword(pwd);
            if (p == null) {
                System.out.println("There is no patient with this infos");
            }
            System.out.println(p.toString());
            persons.add(p);
            return p;

        }
        String query1 = "select * from doctor inner join login on doctor.login = login.username where login.username like '" + login + "' and login.password like '" + password + "'";
        ResultSet rs1 = stmt.executeQuery(query1);
        while (rs1.next()) {
            String nom = rs1.getString("nom");
            String prenom = rs1.getString("prenom");
            String cni = rs1.getString("CIN");
            Doctor p = new Doctor(nom, prenom, cni);
            persons.add(p);
            System.out.println(p.toString());
            return p;
        }
        return null;
    }

    public ArrayList<Patient> getPatients() throws SQLException {
        ArrayList<Patient> patients = new ArrayList<>();
        //create a table patient in the DB Hospital
        String query = "select * from patient";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String cni = rs.getString("CIN");
            String tel = rs.getString("tel");
            String email = rs.getString("email");
            Patient p = new Patient(nom, prenom, cni, tel, email);
            //add a var medical record that links this table to the medical record table
            patients.add(p);
        }
        return patients;
    }

    public Patient getPatient_by_CIN(String cin) throws SQLException {
        String query = "select * from patient where cin like '" + cin + "'";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String cni = rs.getString("CIN");
            String tel = rs.getString("tel");
            String email = rs.getString("email");
            Patient p = new Patient(nom, prenom, cni, tel, email);
            return p;
        }
        return null;
    }

    public boolean add_patient(Patient p) throws SQLException {
        String query = "insert into patient(login,nom, prenom,CIN,tel,email) values ('" + p.getLogin() + "','" + p.getNom() + "','" + p.getPrenom() + "','" + p.getCIN() + "','" + p.getTel() + "','" + p.getEmail() + "')";
        int nbUpdated = stmt.executeUpdate(query);
        return nbUpdated != 0;
    }

    public boolean delete_patient(String cin) throws SQLException {
        String queryd = "delete from patient where CIN like '" + cin + "'";
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
