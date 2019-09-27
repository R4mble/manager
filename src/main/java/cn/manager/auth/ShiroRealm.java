package cn.manager.auth;

import cn.manager.entity.Menu;
import cn.manager.entity.Role;
import cn.manager.entity.User;
import cn.manager.service.MenuService;
import cn.manager.service.RoleService;
import cn.manager.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Wangyl
 * @date 2019/9/26
 */
@Component
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    /**
     * 获取用户角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String name = user.getName();

        // 获取用户角色集合
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<Role> roleList = roleService.getRoleByName(name);
        Set<String> roleSet = roleList.stream().map(Role::getName).collect(Collectors.toSet());
        info.setRoles(roleSet);

        // 获取用户权限集合
        List<Menu> permissionList = menuService.getPermissionByName(name);
        Set<String> permissionSet = permissionList.stream().map(Menu::getPerm).collect(Collectors.toSet());
        info.setStringPermissions(permissionSet);

        return info;
    }

    /**
     * 用户认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String name = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        User user = userService.findByName(name);

        if (user == null) {
            throw new UnknownAccountException("账号未注册!");
        }
        if (!user.getPassword().equals(password)) {
            throw new IncorrectCredentialsException("用户名或密码错误!");
        }

        return new SimpleAuthenticationInfo(user, password, getName());
    }

    /**
     * 清除当前用户权限缓存
     * 使用方法：在需要清除用户权限的地方注入 ShiroRealm,
     * 然后调用其 clearCache方法。
     */
    public void clearCache() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principalCollection);
    }
}
