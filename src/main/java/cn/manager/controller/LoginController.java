package cn.manager.controller;

import cn.manager.entity.ResponseModel;
import cn.manager.service.UserService;
import cn.manager.util.MD5Util;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Wangyl
 * @date 2019/9/26
 */
@Validated
@RestController
public class LoginController extends BaseController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public ResponseModel login(String name, String password, String captcha, boolean rememberMe) {
        password = MD5Util.encrypt(name.toLowerCase(), password);
        UsernamePasswordToken token = new UsernamePasswordToken(name, password, rememberMe);
        login(token);

        return new ResponseModel();
    }

    @PostMapping("/register")
    public ResponseModel register(String name, String password) {
        userService.register(name, password);

        return new ResponseModel();
    }

}
