/*
 * Created on 17 Feb 2017 ( Time 16:36:37 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.domain;

import java.io.Serializable;

import javax.validation.constraints.*;


public class UserAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    @Size( min = 1, max = 15 )
    private String userName;

    @Size( max = 45 )
    private String emailAddress;

    @Size( max = 45 )
    private String password;

    @Size( max = 45 )
    private String firstName;

    @Size( max = 45 )
    private String lastName;



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
    public void setUserName( String userName ) {
        this.userName = userName;
    }
    public String getUserName() {
        return this.userName;
    }

    public void setEmailAddress( String emailAddress ) {
        this.emailAddress = emailAddress;
    }
    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setPassword( String password ) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return this.lastName;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(userName);
        sb.append("|");
        sb.append(emailAddress);
        sb.append("|");
        sb.append(password);
        sb.append("|");
        sb.append(firstName);
        sb.append("|");
        sb.append(lastName);
        return sb.toString(); 
    } 


}
