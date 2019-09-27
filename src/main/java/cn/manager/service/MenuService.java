package cn.manager.service;

import cn.manager.mapper.MenuMapper;
import cn.manager.entity.Menu;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wangyl
 * @date 2019/9/26
 */
@Service
public class MenuService extends ServiceImpl<MenuMapper, Menu> {

    public List<Menu> getPermissionByName(String name) {
        return baseMapper.getPermissionByName(name);
    }
}
