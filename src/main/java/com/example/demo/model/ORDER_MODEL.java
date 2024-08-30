package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ORDER_MODEL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int o_id;
    int amount;
    String order_id;
    String Customer_name;
    int Customer_phone;
    String Customer_email;

    @Override
    public String toString() {
        return "ORDER_MODEL{" +
                "o_id=" + o_id +
                ", amount=" + amount +
                ", order_id='" + order_id + '\'' +
                ", Customer_name='" + Customer_name + '\'' +
                ", Customer_phone=" + Customer_phone +
                ", Customer_email='" + Customer_email + '\'' +
                '}';
    }

    public String getCustomer_email() {
        return Customer_email;
    }

    public ORDER_MODEL() {
    }

    public void setCustomer_email(String customer_email) {
        Customer_email = customer_email;
    }

    public int getCustomer_phone() {
        return Customer_phone;
    }

    public void setCustomer_phone(int customer_phone) {
        Customer_phone = customer_phone;
    }

    public String getCustomer_name() {
        return Customer_name;
    }

    public void setCustomer_name(String customer_name) {
        Customer_name = customer_name;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ORDER_MODEL(int o_id) {
        this.o_id = o_id;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }
}
