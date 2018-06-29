package com.test.sbmvc.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class City{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @Column(nullable = false)
    private int stateId;

    @OneToMany(mappedBy = "cityId",fetch=FetchType.LAZY)
    private List<Zip> zips;

    public int getStateId(){
        return stateId;
    }

    public void setStateId(int stateId){
        this.stateId = stateId;
    }

    public List<Zip> getZips(){
        return zips;
    }

    public void setZips(List<Zip> zips){
        this.zips = zips;
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
