/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml_java_2021_project.Model;

/**
 *
 * @author Fadwa
 */
public class Patient extends User{
    //a patient can take an appointment after getting a negative test result 
    private String nom,login;
    private String prenom;
    private String CIN;
    private String tel,email;
    private Medical_Record my_record;

    public Patient(String nom, String prenom, String CIN, String tel, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.tel = tel;
        this.email = email;
    }
    
    

    public Patient(String login,String nom, String prenom, String CIN,String tel, String email) {
        this.login=login;
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.email=email;
        this.tel=tel;
        this.my_record = new Medical_Record();
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }
    
    

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCIN() {
        return CIN;
    }

    public Medical_Record getMy_record() {
        return my_record;
    }

    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public void setMy_record(Medical_Record my_record) {
        this.my_record = my_record;
    }



    @Override
    public String toString() {
        return "Patient:   " + "Nom=" + nom + ", Prenom=" + prenom + ", CIN=" + CIN + ", tel=" + tel +  ", Email=" + email +"\n";
    }
    
    
}
