/*
 * Created on 17 Feb 2017 ( Time 16:36:17 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a composite Primary Key  


package net.kumasi.debtmonkey.domain.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

/**
 * Persistent class for entity stored in table "User_Role"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="User_Role", catalog="homeAccount" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="UserRoleEntity.countAll", query="SELECT COUNT(x) FROM UserRoleEntity x" )
} )
public class UserRoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
	@EmbeddedId
    private UserRoleEntityKey compositePrimaryKey ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public UserRoleEntity() {
		super();
		this.compositePrimaryKey = new UserRoleEntityKey();       
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE COMPOSITE KEY 
    //----------------------------------------------------------------------
    public void setUserAccountId( Integer userAccountId ) {
        this.compositePrimaryKey.setUserAccountId( userAccountId ) ;
    }
    public Integer getUserAccountId() {
        return this.compositePrimaryKey.getUserAccountId() ;
    }
    public void setRoleRoleId( Integer roleRoleId ) {
        this.compositePrimaryKey.setRoleRoleId( roleRoleId ) ;
    }
    public Integer getRoleRoleId() {
        return this.compositePrimaryKey.getRoleRoleId() ;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        if ( compositePrimaryKey != null ) {  
            sb.append(compositePrimaryKey.toString());  
        }  
        else {  
            sb.append( "(null-key)" ); 
        }  
        sb.append("]:"); 
        return sb.toString(); 
    } 

}