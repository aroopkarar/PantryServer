package com.test.sbmvc.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Address{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;
    private String addressline1;
    private String addressline2;
    private Date dateAdded;
    private Date dateModified;

    @Column(nullable = false)
    private int userId;

    //@OneToOne
    //@JoinColumn(name = "country_id")
    @Column(name="country_id")
    private int country;

    //@OneToOne
    //@JoinColumn(name = "state_id")
    @Column(name="state_id")
    private int state;

    //@OneToOne
    //@JoinColumn(name = "city_id")
    @Column(name="city_id")
    private int city;

    //@OneToOne
    //@JoinColumn(name = "zip_id")
    @Column(name="zip_id")
    private int zip;

    public int getAddressId(){
        return addressId;
    }

    public void setAddressId(int addressId){
        this.addressId = addressId;
    }

    public String getAddressline1(){
        return addressline1;
    }

    public void setAddressline1(String addressline1){
        this.addressline1 = addressline1;
    }

    public String getAddressline2(){
        return addressline2;
    }

    public void setAddressline2(String addressline2){
        this.addressline2 = addressline2;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public Date getDateAdded(){
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded){
        this.dateAdded = dateAdded;
    }

    public Date getDateModified(){
        return dateModified;
    }

    public void setDateModified(Date dateModified){
        this.dateModified = dateModified;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

}
