package com.bank.accounts.details;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String forename;
    private String surname;
    private String email;

    public Customer(){}

    public Customer(String email, String forename, String surname) {    
        this.forename = forename;
    	this.email = email;
    	this.surname = surname;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getForename(){
        return forename;
    }

    public void setFirstName(String forename){
        this.forename = forename;
    }
    
    public String getSurName(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }
}
