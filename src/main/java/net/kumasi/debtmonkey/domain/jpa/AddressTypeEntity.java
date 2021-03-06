/*
 * Created on 17 Feb 2017 ( Time 16:36:17 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package net.kumasi.debtmonkey.domain.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "Address_Type"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="Address_Type", catalog="homeAccount" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="AddressTypeEntity.countAll", query="SELECT COUNT(x) FROM AddressTypeEntity x" )
} )
public class AddressTypeEntity implements Serializable {

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
    @Column(name="address_code", nullable=false, length=45)
    private String     addressCode  ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="addressType", targetEntity=AccountAddressEntity.class)
    private List<AccountAddressEntity> listOfAccountAddress;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public AddressTypeEntity() {
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
    //--- DATABASE MAPPING : address_code ( VARCHAR ) 
    public void setAddressCode( String addressCode ) {
        this.addressCode = addressCode;
    }
    public String getAddressCode() {
        return this.addressCode;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfAccountAddress( List<AccountAddressEntity> listOfAccountAddress ) {
        this.listOfAccountAddress = listOfAccountAddress;
    }
    public List<AccountAddressEntity> getListOfAccountAddress() {
        return this.listOfAccountAddress;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(addressCode);
        return sb.toString(); 
    } 

}
