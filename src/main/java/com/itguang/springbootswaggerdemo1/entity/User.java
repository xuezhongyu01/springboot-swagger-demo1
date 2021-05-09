package com.itguang.springbootswaggerdemo1.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    @ApiModelProperty(hidden = true)
    protected String id;

    @ApiModelProperty(value = "用户名")
    protected String username;

    @ApiModelProperty(value = "密码")
    protected String password;

    @ApiModelProperty(value = "邮箱")
    protected String email;

    @ApiModelProperty(value = "年龄")
    protected Integer age;

    @ApiModelProperty(hidden = true)
    protected Boolean enabled;


    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

}
