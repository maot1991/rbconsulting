package com.rbconsulting.web.Form;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

import com.rbconsulting.web.Validator.PasswordMatches;
import com.rbconsulting.web.Validator.ValidEmail;

@PasswordMatches
public class UserDto {
//    @NotNull
//    @NotEmpty
    private String firstName;
     
//    @NotNull
//    @NotEmpty
    private String lastName;
     
    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;
     
    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;
    
//    @NotNull
//    @NotEmpty
    private String phoneNumber;

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getPassword(){
        return this.password;
    }

    public String getMatchingPassword(){
        return this.matchingPassword;
    }

    public String getEmail(){
        return this.email;
    }
    
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
     
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setMatchingPassword(String matchingPassword){
        this.matchingPassword = matchingPassword;
    }

    public void setEmail(String email){
        this.email = email;
    }
    
    public String setPhoneNumber(){
        return this.phoneNumber;
    }
}