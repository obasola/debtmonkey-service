/*
 * Created on 11 Feb 2017 ( Time 18:00:51 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.model;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class PaymentHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer idpaymentHistory;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Double amountPaid;

    @NotNull
    private Date datePaid;


    private Date dateModified;


    private Date dateCreated;

    @NotNull
    private Integer accountId;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIdpaymentHistory( Integer idpaymentHistory ) {
        this.idpaymentHistory = idpaymentHistory ;
    }

    public Integer getIdpaymentHistory() {
        return this.idpaymentHistory;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setAmountPaid( Double amountPaid ) {
        this.amountPaid = amountPaid;
    }
    public Double getAmountPaid() {
        return this.amountPaid;
    }

    public void setDatePaid( Date datePaid ) {
        this.datePaid = datePaid;
    }
    public Date getDatePaid() {
        return this.datePaid;
    }

    public void setDateModified( Date dateModified ) {
        this.dateModified = dateModified;
    }
    public Date getDateModified() {
        return this.dateModified;
    }

    public void setDateCreated( Date dateCreated ) {
        this.dateCreated = dateCreated;
    }
    public Date getDateCreated() {
        return this.dateCreated;
    }

    public void setAccountId( Integer accountId ) {
        this.accountId = accountId;
    }
    public Integer getAccountId() {
        return this.accountId;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idpaymentHistory);
        sb.append("|");
        sb.append(amountPaid);
        sb.append("|");
        sb.append(datePaid);
        sb.append("|");
        sb.append(dateModified);
        sb.append("|");
        sb.append(dateCreated);
        sb.append("|");
        sb.append(accountId);
        return sb.toString(); 
    } 


}
