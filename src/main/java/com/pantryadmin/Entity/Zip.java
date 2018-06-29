package com.pantryadmin.Entity;

import javax.persistence.*;

@Entity
public class Zip{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private long zipCode;

    @Column(nullable = false)
    private int cityId;

    public int getCityId(){
        return cityId;
    }

    public void setCityId(int cityId){
        this.cityId = cityId;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public long getZipCode(){
        return zipCode;
    }

    public void setZipCode(long zipCode){
        this.zipCode = zipCode;
    }

}
