package cn.manager.controller;

import cn.manager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Wangyl
 * @date 2019/9/26
 */
@Controller("/view")
public class ViewController extends BaseController {

    @Resource
    private UserService userService;

    @GetMapping("/login")
    @ResponseBody
    public Object login(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/login");
        return mv;
    }

}
