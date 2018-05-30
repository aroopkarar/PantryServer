package com.test.sbmvc.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "orderstatus_id")
    private OrderStatus status;

    private Date dateAdded;
    private Date dateModified;
    private int modifiedBy;
    private float shippingCharge;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "id",cascade= CascadeType.ALL)
    private List<OrderLine> orderlines;

    @Column(nullable = false)
    private int userId;

    @OneToOne
    @JoinColumn(name = "paymenttype_id")
    private PaymentType paymentType;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    public float getShippingCharge(){
        return shippingCharge;
    }

    public void setShippingCharge(float shippingCharge){
        this.shippingCharge = shippingCharge;
    }

    public PaymentType getPaymentType(){
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType){
        this.paymentType = paymentType;
    }

    public Invoice getInvoice(){
        return invoice;
    }

    public void setInvoice(Invoice invoice){
        this.invoice = invoice;
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

    public OrderStatus getStatus(){
        return status;
    }

    public void setStatus(OrderStatus status){
        this.status = status;
    }

    public List<OrderLine> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(List<OrderLine> orderlines) {
        this.orderlines = orderlines;
    }

}
