package com.chigua.controller.auth;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chigua.core.service.oauth.entity.UserInfo;
import com.chigua.core.service.oauth.entity.UserRole;
import com.chigua.core.service.oauth.service.IUserRoleService;
import com.chigua.core.service.oauth.service.IUserService;
import com.chigua.core.tool.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNameAdminController
 * @Description 管理员的接口资源
 * @Author Mr.Zhou
 * @Date2020/9/18 16:28
 * @Version V1.0
 **/
@Api(value = "管理员的接口资源",tags = "管理员的接口资源")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    IUserRoleService iUserRoleService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @GetMapping("")
    @ResponseBody
    public String index(){
        return "管理员接口";
    }

    @GetMapping("/select")
    @ResponseBody
    public String select(){
        return "管理员查询接口";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(){
        return "管理员删除接口";
    }
    @ApiOperation(value = "add",tags = "添加用户")
    @PostMapping("/add")
    @ResponseBody
    public R delete(String name,String password,Integer roleId){
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername(name);
        userInfo.setIsDeleted(0);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.setEntity(userInfo);
        UserInfo userInfo2= iUserService.getOne(queryWrapper);
        if(null!=userInfo2){
            return R.fail("用户已存在");
        }
        userInfo.setAge(22);
        userInfo.setPassword(bCryptPasswordEncoder.encode(password));
        userInfo.setCreateUser(iUserService.getLogin().getUserId());
        iUserService.save(userInfo);
        UserRole userRole=new UserRole();
        userRole.setUserId(userInfo.getUserId());
        userRole.setRoleId(roleId);
        userRole.setCreateUser(iUserService.getLogin().getUserId());
        iUserRoleService.save(userRole);
        return R.data(null);
    }

}
