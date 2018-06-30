
package com.pantryadmin.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date dateCreated;

	@OneToOne
	private User user;

    @OneToMany(mappedBy = "cartId",cascade = CascadeType.ALL)
    private Set<CartItem> cartItems;


	public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

}
