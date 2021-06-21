/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml_java_2021_project.Model;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author Fadwa
 */
public class Medical_Record {
    Date birtdate;
    String sexe;
    String phone_number;
    String address;
    String email;
    String emergency_contact;
    String treatment_history;
    String doctor_notes;
    List<String> medications = new ArrayList<>();
    
//    private int id_dossier_medical;
//    private int id_dossier_patient_dm;
//    private String taille;
//    private String poids;
//    private String allergie;
//    private String antecedants;
//    private String contres_indications;
//    private String vaccins;

    public Medical_Record() {
        JFrame frame = new JFrame();
        frame.setLayout(new CardLayout());
        //patient form:
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
        frame.setSize(600, 600);
        
        
    }
    
   
    
}
