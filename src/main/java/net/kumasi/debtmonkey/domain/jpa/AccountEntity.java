/*
 * Created on 17 Feb 2017 ( Time 16:36:16 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package net.kumasi.debtmonkey.domain.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "Account"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="Account", catalog="homeAccount" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="AccountEntity.countAll", query="SELECT COUNT(x) FROM AccountEntity x" )
} )
public class AccountEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="account_name", nullable=false, length=45)
    private String     accountName  ;

    @Column(name="original_balance")
    private Double     originalBalance ;

    @Column(name="current_balance")
    private Double     currentBalance ;

    @Temporal(TemporalType.DATE)
    @Column(name="date_last_payment")
    private Date       dateLastPayment ;

    @Temporal(TemporalType.DATE)
    @Column(name="date_opened")
    private Date       dateOpened   ;

    @Temporal(TemporalType.DATE)
    @Column(name="date_closed")
    private Date       dateClosed   ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_created")
    private Date       dateCreated  ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_modified")
    private Date       dateModified ;

    @Column(name="auto_payment")
    private Byte       autoPayment  ;

	// "accountTypeId" (column "Account_Type_Id") is not defined by itself because used as FK in a link 
	// "userAccountId" (column "User_account_id") is not defined by itself because used as FK in a link 
	// "accountAddressId" (column "Account_Address_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="account", targetEntity=PaymentHistoryEntity.class)
    private List<PaymentHistoryEntity> listOfPaymentHistory;

    @ManyToOne
    @JoinColumn(name="Account_Address_id", referencedColumnName="id")
    private AccountAddressEntity accountAddress;

    @ManyToOne
    @JoinColumn(name="User_account_id", referencedColumnName="id")
    private UserAccountEntity userAccount ;

    @OneToMany(mappedBy="account", targetEntity=PaymentScheduleEntity.class)
    private List<PaymentScheduleEntity> listOfPaymentSchedule;

    @ManyToOne
    @JoinColumn(name="Account_Type_Id", referencedColumnName="id")
    private AccountTypeEntity accountType ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public AccountEntity() {
		super();
    }
    
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
    //--- DATABASE MAPPING : account_name ( VARCHAR ) 
    public void setAccountName( String accountName ) {
        this.accountName = accountName;
    }
    public String getAccountName() {
        return this.accountName;
    }

    //--- DATABASE MAPPING : original_balance ( DOUBLE ) 
    public void setOriginalBalance( Double originalBalance ) {
        this.originalBalance = originalBalance;
    }
    public Double getOriginalBalance() {
        return this.originalBalance;
    }

    //--- DATABASE MAPPING : current_balance ( DOUBLE ) 
    public void setCurrentBalance( Double currentBalance ) {
        this.currentBalance = currentBalance;
    }
    public Double getCurrentBalance() {
        return this.currentBalance;
    }

    //--- DATABASE MAPPING : date_last_payment ( DATE ) 
    public void setDateLastPayment( Date dateLastPayment ) {
        this.dateLastPayment = dateLastPayment;
    }
    public Date getDateLastPayment() {
        return this.dateLastPayment;
    }

    //--- DATABASE MAPPING : date_opened ( DATE ) 
    public void setDateOpened( Date dateOpened ) {
        this.dateOpened = dateOpened;
    }
    public Date getDateOpened() {
        return this.dateOpened;
    }

    //--- DATABASE MAPPING : date_closed ( DATE ) 
    public void setDateClosed( Date dateClosed ) {
        this.dateClosed = dateClosed;
    }
    public Date getDateClosed() {
        return this.dateClosed;
    }

    //--- DATABASE MAPPING : date_created ( DATETIME ) 
    public void setDateCreated( Date dateCreated ) {
        this.dateCreated = dateCreated;
    }
    public Date getDateCreated() {
        return this.dateCreated;
    }

    //--- DATABASE MAPPING : date_modified ( DATETIME ) 
    public void setDateModified( Date dateModified ) {
        this.dateModified = dateModified;
    }
    public Date getDateModified() {
        return this.dateModified;
    }

    //--- DATABASE MAPPING : auto_payment ( TINYINT ) 
    public void setAutoPayment( Byte autoPayment ) {
        this.autoPayment = autoPayment;
    }
    public Byte getAutoPayment() {
        return this.autoPayment;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfPaymentHistory( List<PaymentHistoryEntity> listOfPaymentHistory ) {
        this.listOfPaymentHistory = listOfPaymentHistory;
    }
    public List<PaymentHistoryEntity> getListOfPaymentHistory() {
        return this.listOfPaymentHistory;
    }

    public void setAccountAddress( AccountAddressEntity accountAddress ) {
        this.accountAddress = accountAddress;
    }
    public AccountAddressEntity getAccountAddress() {
        return this.accountAddress;
    }

    public void setUserAccount( UserAccountEntity userAccount ) {
        this.userAccount = userAccount;
    }
    public UserAccountEntity getUserAccount() {
        return this.userAccount;
    }

    public void setListOfPaymentSchedule( List<PaymentScheduleEntity> listOfPaymentSchedule ) {
        this.listOfPaymentSchedule = listOfPaymentSchedule;
    }
    public List<PaymentScheduleEntity> getListOfPaymentSchedule() {
        return this.listOfPaymentSchedule;
    }

    public void setAccountType( AccountTypeEntity accountType ) {
        this.accountType = accountType;
    }
    public AccountTypeEntity getAccountType() {
        return this.accountType;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(accountName);
        sb.append("|");
        sb.append(originalBalance);
        sb.append("|");
        sb.append(currentBalance);
        sb.append("|");
        sb.append(dateLastPayment);
        sb.append("|");
        sb.append(dateOpened);
        sb.append("|");
        sb.append(dateClosed);
        sb.append("|");
        sb.append(dateCreated);
        sb.append("|");
        sb.append(dateModified);
        sb.append("|");
        sb.append(autoPayment);
        return sb.toString(); 
    } 

}
