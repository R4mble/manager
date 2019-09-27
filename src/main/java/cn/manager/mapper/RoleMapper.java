package cn.manager.mapper;

import cn.manager.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author Wangyl
 * @date 2019/9/26
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getRoleByName(String name);
}
