package com.demo.security.web.controller;

import com.demo.security.dto.User;
import com.demo.security.dto.UserQueryCondition;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation(value = "用户查询服务")
    public List<User> query(UserQueryCondition condition, Pageable pageable){
        System.out.println(ReflectionToStringBuilder.toString(condition,ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }


    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam("用户id") @PathVariable String id){

//        throw new UserNotExistException(id);
        System.out.println("调用getInfo服务");
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    @PostMapping()
    public User create(@Valid @RequestBody User user){

//        if(errors.hasErrors()){
//            errors.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
//        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().forEach(error -> {
//                FieldError fieldError = (FieldError) error;
//                String  message = fieldError.getField()+"  "+error.getDefaultMessage();
                System.out.println(error.getDefaultMessage());
            });
        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId("2");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void update(@PathVariable String id){

        System.out.println(id);
    }
}
