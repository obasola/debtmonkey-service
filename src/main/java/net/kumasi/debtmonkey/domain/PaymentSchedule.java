/*
 * Created on 17 Feb 2017 ( Time 16:36:37 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.domain;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class PaymentSchedule implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    private Date nextPaymentDue;


    private Double balanceDue;

    @NotNull
    private Integer accountId;
    
    private String accountName;


    private Byte autoPayment;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }

    public Integer getId() {
        return this.id;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setNextPaymentDue( Date nextPaymentDue ) {
        this.nextPaymentDue = nextPaymentDue;
    }
    public Date getNextPaymentDue() {
        return this.nextPaymentDue;
    }

    public void setBalanceDue( Double balanceDue ) {
        this.balanceDue = balanceDue;
    }
    public Double getBalanceDue() {
        return this.balanceDue;
    }

    public void setAccountId( Integer accountId ) {
        this.accountId = accountId;
    }
    public Integer getAccountId() {
        return this.accountId;
    }

    public void setAutoPayment( Byte autoPayment ) {
        this.autoPayment = autoPayment;
    }
    public Byte getAutoPayment() {
        return this.autoPayment;
    }

    

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

		public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(nextPaymentDue);
        sb.append("|");
        sb.append(balanceDue);
        sb.append("|");
        sb.append(accountId);
        sb.append("|");
        sb.append(autoPayment);
        return sb.toString(); 
    } 


}
