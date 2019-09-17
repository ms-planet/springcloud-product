package com.imooc.producter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxlei
 * @date 2019/8/22 10:31
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg() {
        return "this is product' msg AIREY!!!";
    }

}
