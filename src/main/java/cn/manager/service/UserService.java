package cn.manager.service;

import cn.manager.mapper.UserMapper;
import cn.manager.model.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Wangyl
 * @date 2019/9/26
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

}
