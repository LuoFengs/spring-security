package com.demo.security.validator;

import com.demo.security.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("my validator init");
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        helloService.greeting("tom");
        System.out.println(obj);
        return false;
    }
}
