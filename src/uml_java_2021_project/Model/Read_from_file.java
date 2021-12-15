/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml_java_2021_project.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Fadwa
 */
public class Read_from_file {

    public static String get_random_temperature() {
        try {
            Scanner x = new Scanner(new File("C:\\Users\\Hp_ProBook\\Desktop\\COURSES\\Snippets\\Projet OOP\\Temperature_data.txt"));
            if (!x.hasNext()) {
                System.out.println("This file does not exist");
            }
            List temp = new ArrayList();
            while (x.hasNext()) {
                float temperature = x.nextFloat();
                temp.add(temperature);
                int num = new Random().nextInt(temp.size());
            }
            int y = (int) (Math.random() * temp.size());
            return "" + (float) temp.get(y);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public static String get_random_heartrate() {
        try {
            Scanner x = new Scanner(new File("C:\\Users\\Hp_ProBook\\Desktop\\COURSES\\Snippets\\Projet OOP\\Heart_rate_data.txt"));
            if (!x.hasNext()) {
                System.out.println("This file does not exist");
            }
            List hrd = new ArrayList();
            while (x.hasNext()) {
                long h= x.nextLong();
                hrd.add(h);
                int num = new Random().nextInt(hrd.size());
            }
            int y = (int) (Math.random() * hrd.size());
            return "" + (long) hrd.get(y);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public static void main(String[] args) {
        String y;
        y = get_random_temperature();
        System.out.println(y);
        String h;
        h = get_random_heartrate();
        System.out.println(h);
    }
}
