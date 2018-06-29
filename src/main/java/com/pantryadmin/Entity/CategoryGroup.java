
package com.pantryadmin.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="category_group")
public class CategoryGroup {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int groupId;
    
    @Column(length = 45)
    private String groupName;
    
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToMany(mappedBy = "categoryGroupId")//column name in another table
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public int getGroupId(){
        return groupId;
    }

    public void setGroupId(int groupId){
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
