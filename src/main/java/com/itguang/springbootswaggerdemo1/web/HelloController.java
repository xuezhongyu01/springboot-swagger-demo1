package com.itguang.springbootswaggerdemo1.web;


import com.itguang.springbootswaggerdemo1.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/user", produces = APPLICATION_JSON_VALUE) //配置返回值 application/json
@Api(description = "用户管理")
public class HelloController {

    ArrayList<User> users = new ArrayList<>();


    @ApiOperation(value = "获取用户列表", notes = "获取所有用户信息")
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<User> hello() {
        users.add(new User("逻辑", "luoji"));
        users.add(new User("叶文杰", "yewenjie"));
        return users;
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User postUser(User user) {

        return user;
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)

    public User getUser(
            @PathVariable(value = "id") String id) {

        return new User(id, "itguang", "123456");
    }


}
