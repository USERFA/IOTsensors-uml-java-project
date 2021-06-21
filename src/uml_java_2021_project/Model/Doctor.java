/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml_java_2021_project.Model;

import java.util.ArrayList;

/**
 *
 * @author Fadwa
 */
public class Doctor extends User {

    private String nom;
    private String prenom;
    private String CIN;
    private String speciality;
    private ArrayList<String> education = new ArrayList<>();

    public Doctor(String nom, String prenom, String CIN) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
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

    public String getSpeciality() {
        return speciality;
    }

    public ArrayList<String> getEducation() {
        return education;
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

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setEducation(ArrayList<String> education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Doctor{" + "nom=" + nom + ", prenom=" + prenom + ", CIN=" + CIN + ", speciality=" + speciality + '}';
    }

}
