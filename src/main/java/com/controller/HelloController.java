package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * ClassName: HelloController
 * Package: com.controller
 * Date: 2020/3/27 16:33
 * Author; 吴华川
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/getName")
    public String getName() {
        return "tom";
    }

    @GetMapping("/setName")
    public String setName(String name, HttpSession session) {
        return name;
    }
}
