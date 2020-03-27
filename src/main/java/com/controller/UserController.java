package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: UserController
 * Package: com.controller
 * Date: 2020/3/27 16:51
 * Author; 吴华川
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getName")
    public String getName() {
        return "Tom";
    }

    @PostMapping("/setName")
    public String setName(String name) {
        return name;
    }
}
