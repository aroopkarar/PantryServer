package com.pantryadmin.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    private double price;

    @Column(length=1500)
    private String description;

    @Column(nullable = false)
    private int subcategoryId;

    @Column(length=1500)
    private String imageUrl;
    private Boolean hasOffer;
    private int offerPercent;
    private int addedBy;
    private Date dateAdded;
    private int modifiedBy;
    private Date dateModified;
    private Boolean isActive;

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public int getAddedBy(){
        return addedBy;
    }

    public void setAddedBy(int addedBy){
        this.addedBy = addedBy;
    }

    public Date getDateAdded(){
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded){
        this.dateAdded = dateAdded;
    }

    public int getModifiedBy(){
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy){
        this.modifiedBy = modifiedBy;
    }

    public Date getDateModified(){
        return dateModified;
    }

    public void setDateModified(Date dateModified){
        this.dateModified = dateModified;
    }

    public Boolean getActive(){
        return isActive;
    }

    public void setActive(Boolean active){
        isActive = active;
    }

    public Boolean getHasOffer(){
        return hasOffer;
    }

    public void setHasOffer(Boolean hasOffer){
        this.hasOffer = hasOffer;
    }

    public int getOfferPercent(){
        return offerPercent;
    }

    public void setOfferPercent(int offerPercent){
        this.offerPercent = offerPercent;
    }

    public int getSubcategoryId(){
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId){

        this.subcategoryId = subcategoryId;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
