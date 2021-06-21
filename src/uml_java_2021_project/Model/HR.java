/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml_java_2021_project.Model;

import java.util.Date;

/**
 *
 * @author Fadwa
 */
public class HR {

    private String id_HR;
    private String first_name, last_name,gender;
    private float weight, height;
    private Date birthdate, date_visit;
    private String diagnostic, treatment, details;

    public HR(String first_name, String last_name,String gender,float weight, float height,Date birthdate, Date date_visit, String diagnostic, String treatment, String details) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.weight = weight;
        this.height = height;
        this.gender=gender;
        this.birthdate = birthdate;
        this.date_visit = date_visit;
        this.diagnostic = diagnostic;
        this.treatment = treatment;
        this.details = details;
    }   

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Date getDate_visit() {
        return date_visit;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getDetails() {
        return details;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setDate_visit(Date date_visit) {
        this.date_visit = date_visit;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getId_HR() {
        return id_HR;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setId_HR(String id_HR) {
        this.id_HR = id_HR;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "HR{" + "id_HR=" + id_HR + ", first_name=" + first_name + ", last_name=" + last_name + ", gender=" + gender + ", weight=" + weight + ", height=" + height + ", birthdate=" + birthdate + ", date_visit=" + date_visit + ", diagnostic=" + diagnostic + ", treatment=" + treatment + ", details=" + details + '}';
    }

    

 
   
}
