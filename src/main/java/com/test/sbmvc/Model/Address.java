package com.test.sbmvc.Model;

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

    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToOne
    @JoinColumn(name = "state_id")
    private State state;

    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToOne
    @JoinColumn(name = "zip_id")
    private Zip zip;

    public City getCity(){
        return city;
    }

    public void setCity(City city){
        this.city = city;
    }

    public Zip getZip(){
        return zip;
    }

    public void setZip(Zip zip){
        this.zip = zip;
    }

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
    public Country getCountry(){
        return country;
    }

    public void setCountry(Country country){
        this.country = country;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
