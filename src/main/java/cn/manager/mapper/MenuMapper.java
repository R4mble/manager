package cn.manager.mapper;

import cn.manager.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author Wangyl
 * @date 2019/9/26
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getPermissionByName(String name);
}
