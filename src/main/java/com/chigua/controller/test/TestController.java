package com.chigua.controller.test;

import com.chigua.core.log.annotation.ApiLog;
import com.chigua.core.service.log.service.ILogApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameTestController
 * @Description
 * @Author Mr.Zhou
 * @Date2020/7/17 17:24
 * @Version V1.0
 **/
@RestController
@RequestMapping("/api/test")
@Api(value = "测试controller")
public class TestController {
    @Autowired
    private ILogApiService iLogApiService;
    @ApiOperation(value = "getName",tags = "获取名字")
    @GetMapping("/getName")
    @ResponseBody
    @ApiLog
    public String getName(){
        return "hello,my name  is zlb";
    }

    @ApiOperation(value = "getName1",tags = "获取名字2")
    @GetMapping("/getName1")
    @ResponseBody
    @ApiLog
    public String getName1(){
        iLogApiService.getById(1);
        int a=1;
        int b=0;
        double c=  a/b;
        return "hello,my name  is zlb";
    }
}
