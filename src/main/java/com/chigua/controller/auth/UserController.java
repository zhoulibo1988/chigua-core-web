package com.chigua.controller.auth;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNameUserController
 * @Description 用户的接口资源
 * @Author Mr.Zhou
 * @Date2020/9/18 16:30
 * @Version V1.0
 **/
@Api(value = "用户的接口资源",tags = "用户的接口资源")
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("")
    @ResponseBody
    public String index(){
        return "用户接口";
    }

    @GetMapping("/select")
    @ResponseBody
    public String select(){
        return "用户查询接口";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(){
        return "用户删除接口";
    }
}
