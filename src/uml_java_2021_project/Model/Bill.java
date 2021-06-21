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
public class Bill {
    private String card_id;
    private float price;
    private Date date_payment;

    public Bill(String card_id, float price, Date date_payment) {
        this.card_id = card_id;
        this.price = price;
        this.date_payment = date_payment;
    }

    public String getCard_id() {
        return card_id;
    }

    public float getPrice() {
        return price;
    }

    public Date getDate_payment() {
        return date_payment;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDate_payment(Date date_payment) {
        this.date_payment = date_payment;
    }
    
    
}
