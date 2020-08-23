package com.example.demo.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value = "swagger api")
public class SwaggerApi {

    // 文档
    // https://www.cnblogs.com/coderxx/p/10953726.html

    @ApiOperation(value = "hello method")
    @ResponseBody
    @RequestMapping("/hello")
    public void hello() {
        System.out.println("kkkkkkkkkkkkkkkkk");
    }
}
