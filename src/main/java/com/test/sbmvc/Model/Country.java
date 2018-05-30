package com.test.sbmvc.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Country{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy = "countryId",fetch=FetchType.LAZY)
    private List<State> states;

    public List<State> getStates(){
        return states;
    }

    public void setStates(List<State> states){
        this.states = states;
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
