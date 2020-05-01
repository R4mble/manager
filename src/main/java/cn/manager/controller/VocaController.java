package cn.manager.controller;

import cn.manager.model.ResponseModel;
import cn.manager.entity.Voca;
import cn.manager.service.VocaService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

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
    public ResponseModel insert(@RequestBody @Valid Voca voca) {
        int res = vocaService.insert(voca);
        if (res == -1) {
            return new ResponseModel("该单词已存在!");
        }
        return new ResponseModel(res);
    }

    @GetMapping
    public ResponseModel get(@RequestParam long id) {
        Voca voca = vocaService.get(id);
        return new ResponseModel(voca);
    }

    @DeleteMapping
    public ResponseModel delete(@RequestParam long id) {
        int res = vocaService.delete(id);
        return new ResponseModel(res);
    }

    @PutMapping
    public ResponseModel update(@RequestBody Voca voca) {
        boolean res = vocaService.updateById(voca);
        return new ResponseModel(res);
    }

    @GetMapping("/list")
    public ResponseModel list(@RequestParam Long userId) {
        List<Voca> list = vocaService.getByUserId(userId);
        return new ResponseModel(list);
    }
}
