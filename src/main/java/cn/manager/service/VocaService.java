package cn.manager.service;

import cn.manager.entity.Voca;
import cn.manager.mapper.VocaMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Wangyl
 * @date 2019/9/27
 */
@Service
public class VocaService extends ServiceImpl<VocaMapper, Voca> {


    public void insert(Voca voca) {
        baseMapper.insert(voca);
    }
}
