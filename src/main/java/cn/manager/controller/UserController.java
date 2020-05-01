package cn.manager.controller;

import cn.manager.entity.User;
import cn.manager.model.ResponseModel;
import cn.manager.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    public ResponseModel get(@RequestParam String name) {
        User user = userService.findByName(name);
        return new ResponseModel(user);
    }
}
