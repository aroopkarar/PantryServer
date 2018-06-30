package com.pantryadmin.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date dateAdded;
    private Date dateModified;

    private int addedBy;
    private int modifiedBy;

    @Column(nullable = false)
    private int userId;

    private float shippingCharge;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "order_status")
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",unique = true)
    private Address address;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "orderId",cascade= CascadeType.ALL)
    private List<OrderLine> orderlines;

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public int getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(int addedBy) {
        this.addedBy = addedBy;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public float getShippingCharge(){
        return shippingCharge;
    }

    public void setShippingCharge(float shippingCharge){
        this.shippingCharge = shippingCharge;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public int getModifiedBy(){
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy){
        this.modifiedBy = modifiedBy;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderLine> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(List<OrderLine> orderlines) {
        this.orderlines = orderlines;
    }

}
