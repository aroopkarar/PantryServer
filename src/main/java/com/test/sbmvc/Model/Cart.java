
package com.test.sbmvc.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date dateAdded;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "cart_product", joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
	private Set<Product> products;

	public Date getDateAdded(){
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded){
		this.dateAdded = dateAdded;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public Set<Product> getProducts(){
		return products;
	}
	public void setProducts(Set<Product> products){
		this.products = products;
	}

}
