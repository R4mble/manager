package cn.manager.service;

import cn.manager.entity.Voca;
import cn.manager.mapper.VocaMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wangyl
 * @date 2019/9/27
 */
@Service
public class VocaService extends ServiceImpl<VocaMapper, Voca> {


    public int insert(Voca voca) {
        int res;
        try {
            res = baseMapper.insert(voca);
        } catch (DuplicateKeyException e) {
            res = -1;
        }
        return res;
    }

    public Voca get(Long id) {
        return baseMapper.selectById(id);
    }

    public int delete(long id) {
        return baseMapper.deleteById(id);
    }

    public List<Voca> getByUserId(Long userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        return baseMapper.selectByMap(map);
    }
}
