package com.test.sbmvc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Invoice{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String invoiceNumber;
    private Date dateAdded;


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getInvoiceNumber(){
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber){
        this.invoiceNumber = invoiceNumber;
    }

    public Date getDateAdded(){
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded){
        this.dateAdded = dateAdded;
    }
}
