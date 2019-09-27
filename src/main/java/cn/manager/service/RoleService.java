package cn.manager.service;

import cn.manager.mapper.RoleMapper;
import cn.manager.entity.Role;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wangyl
 * @date 2019/9/26
 */
@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> {

    public List<Role> getRoleByName(String name) {
        return baseMapper.getRoleByName(name);
    }
}
