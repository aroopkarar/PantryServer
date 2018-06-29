package com.test.sbmvc.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String password;
    private String username;
    private String firstname;
    private String lastname;
    private String mobile;
    private String email;
    private String imageUrl;
    private boolean isAdmin;
    private boolean isEmailVerified;
    private boolean isMobileVerified;
    private boolean isFirstLogin;
    private Date dateAdded;
    private Date dateModified;
    private int addedBy;
    private int modifiedBy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id",unique = true)
    private Cart cart;

    @OneToMany(mappedBy = "userId",fetch=FetchType.LAZY)
    private List<Address> addresses;

    public boolean isFirstLogin() {
        return isFirstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        isFirstLogin = firstLogin;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public boolean isMobileVerified() {
        return isMobileVerified;
    }

    public void setMobileVerified(boolean mobileVerified) {
        isMobileVerified = mobileVerified;
    }

    @OneToMany(mappedBy = "userId",fetch=FetchType.LAZY)
    private List<Orders> orders;

    public List<Address> getAddresses(){
        return addresses;
    }

    public void setAddresses(List<Address> addresses){
        this.addresses = addresses;
    }

    public List<Orders> getOrders(){
        return orders;
    }

    public void setOrders(List<Orders> orders){
        this.orders = orders;
    }

    public int getAddedBy(){
        return addedBy;
    }

    public void setAddedBy(int addedBy){
        this.addedBy = addedBy;
    }

    public int getModifiedBy(){
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy){
        this.modifiedBy = modifiedBy;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getMobile(){
        return mobile;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
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

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }
}
