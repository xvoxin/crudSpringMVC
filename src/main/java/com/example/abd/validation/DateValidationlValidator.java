package com.example.abd.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class DateValidationlValidator implements ConstraintValidator<DateValidation, String> {


	@Override
	public void initialize(DateValidation validEmail) {}

	@Override
	public boolean isValid(String inputdate, ConstraintValidatorContext context) {
		if (inputdate.matches("\\d{2}-\\d{2}-\\d{4}")) {
			String date[] = inputdate.split("-");
		    System.out.println(date[0]);
		    int day = Integer.parseInt(date[0]);
		    int month = Integer.parseInt(date[1]);
		    int year = Integer.parseInt(date[2]);
		    int counter = 0;
		    
		    if(day < 32 && day > 0) 
		    	counter++;
		    if(month < 13 && month > 0) 
		    	counter++;
		    if(year < 2018 && year > 1901) 
		    	counter++;
		    
		    if(counter < 3) {
		    	return false;
		    } else{
		    	int switchCase = 0;
		    	if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
		    		switchCase = 1;
		    	if(month == 4 || month == 6 || month == 9 || month == 11) 
		    		switchCase = 2;
		    	if(month == 2) 
		    		switchCase = 3;
		    	
		    	switch(switchCase){
			    	case 1:{
			    		if(day > 31){
			    			return false;
			    		}
			    		else return true;
			    	}
			    	case 2:{
			    		if(day > 30){
			    			return false;
			    		}
			    		else return true;
			    	}
			    	case 3:{
			    		if(year % 4 == 0){
			    			if(day > 29){
			    				return false;
			    			}
			    			else return true;
			    		} else if(day > 28) {
			    			return false;
			    		}
			    		else return true;
			    	}
		    	}
		    	return true;
		    }
		} 
		else return false;
	}
}