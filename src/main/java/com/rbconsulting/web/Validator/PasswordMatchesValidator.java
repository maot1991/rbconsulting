package com.rbconsulting.web.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.rbconsulting.web.Form.UserDto;

public class PasswordMatchesValidator 
  implements ConstraintValidator<PasswordMatches, Object> { 
     
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {       
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){   
        UserDto user = (UserDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());    
    }     
}
