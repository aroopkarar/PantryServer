
package com.test.sbmvc.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="category")
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;

    @Column(length = 45)
    private String categoryName;

    private Date dateAdded;

    private Date dateModified;

    private Boolean isActive;

    @Column(nullable = false)
    private int categoryGroupId;
    
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToMany(mappedBy = "categoryId")
    private List<Subcategory> subcategories;


    public Boolean getActive(){
        return isActive;
    }

    public void setActive(Boolean active){
        isActive = active;
    }

    public int getCategoryGroupId() {
        return categoryGroupId;
    }

    public void setCategoryGroupId(int categoryGroupId) {
        this.categoryGroupId = categoryGroupId;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    public int getCategoryId(){
        return categoryId;
    }

    public void setCategoryId(int categoryId){
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}
