package cn.manager.controller;

import cn.manager.entity.Voca;
import cn.manager.service.VocaService;
import org.springframework.web.bind.annotation.*;
import java.util.Base64;

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
        String ph = Base64.getEncoder().encodeToString(voca.getPhonetic().getBytes());
        voca.setPhonetic(ph);
        vocaService.insert(voca);
    }

    @GetMapping
    public Voca get(@RequestParam long id) {
        Voca voca =  vocaService.get(id);
        String ph = new String(Base64.getDecoder().decode(voca.getPhonetic()));
        voca.setPhonetic(ph);
        return voca;
    }

}
