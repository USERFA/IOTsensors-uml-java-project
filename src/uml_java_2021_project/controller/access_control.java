/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml_java_2021_project.controller;

import GUI.Login_interface;
import uml_java_2021_project.DB.CRUD_person;

/**
 *
 * @author Fadwa
 */
public class access_control {

    public static void main(String[] args) {
        CRUD_person person;

        Login_interface d = new Login_interface();
        d.setVisible(true);
        d.setLocationRelativeTo(null);
        d.setResizable(false);
        

    }

}
