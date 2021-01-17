package com.example.demo.validation;

import com.example.demo.validation.annotation.MaxYear;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;


public class MaxYearValidator implements ConstraintValidator<MaxYear, Integer> {

    @Override
    public boolean isValid(final Integer year, final ConstraintValidatorContext context) {
        return (validateYear(year));
    }
    private boolean validateYear(final int year) {
        Date date = new Date();
        if((date.getYear() -1900) >= year){
           return true;
        }else{
            return false;
        }
    }

}
