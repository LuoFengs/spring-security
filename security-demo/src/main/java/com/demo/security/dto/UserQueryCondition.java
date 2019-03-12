package com.demo.security.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserQueryCondition {


    private String username;
    @ApiModelProperty(value = "年龄起始值")
    private int age;
    @ApiModelProperty(value = "年龄终止值")
    private int ageTo;
    private String xxx;


}
