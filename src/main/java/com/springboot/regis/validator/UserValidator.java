package com.springboot.regis.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springboot.regis.model.User;
import com.springboot.regis.service.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }
	
	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;
		
		if(userService.findByRegno(user.getRegno()) != null) {
			errors.rejectValue("regno", "Duplicate.userForm.username");
		}
	}
}
