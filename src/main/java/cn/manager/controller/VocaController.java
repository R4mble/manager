package cn.manager.controller;

import cn.manager.entity.Voca;
import cn.manager.service.VocaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Wangyl
 * @date 2019/9/27
 */
@RestController
@RequestMapping("/voca")
public class VocaController {

    @Resource
    private VocaService vocaService;

    @PostMapping
    public void insert(@RequestBody Voca voca) {
        vocaService.insert(voca);
    }

}
