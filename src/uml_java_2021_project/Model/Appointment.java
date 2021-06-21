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
public class Appointment {


    private String patient_name;
    private int age;
    private String gender;
    private String tel;
    private String first_visit;
    private String details;
    private Date date;

    public Appointment(String patient_name, int age, String gender, String tel, String first_visit, String details,Date d) {
        this.patient_name = patient_name;
        this.age = age;
        this.gender = gender;
        this.tel = tel;
        this.first_visit = first_visit;
        this.details = details;
        this.date=d;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getTel() {
        return tel;
    }

    public String isFirst_visit() {
        return first_visit;
    }

    public String getDetails() {
        return details;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setFirst_visit(String first_visit) {
        this.first_visit = first_visit;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    

    @Override
    public String toString() {
        return "Appointment: \n"+"Patient: "+patient_name+" Age: "+age+" Sexe: "+gender+"Telephone: "+tel+" Appointment details: "+details;
    }
    
    
    
    
}
