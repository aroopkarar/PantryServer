package com.test.sbmvc.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class State{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @Column(nullable = false)
    private int countryId;

    @OneToMany(mappedBy = "stateId",fetch=FetchType.LAZY)
    private List<City> cities;

    public List<City> getCities(){
        return cities;
    }

    public int getCountryId(){
        return countryId;
    }

    public void setCountryId(int countryId){
        this.countryId = countryId;
    }

    public void setCities(List<City> cities){
        this.cities = cities;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}
