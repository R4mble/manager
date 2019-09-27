package cn.manager.auth;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Wangyl
 * @date 2019/9/26
 */
@Configuration
public class ShiroConfig {

    private String host;

    private int port;

    private String password;

    private int timeout;

    private int database;

    private RedisManager redisManager() {
        RedisManager manager = new RedisManager();
        manager.setHost(host + ":" + port);
        manager.setPassword(password);
        manager.setTimeout(timeout);
        manager.setDatabase(database);
        return manager;
    }

    private RedisCacheManager cacheManager() {
        RedisCacheManager manager = new RedisCacheManager();
        manager.setRedisManager(redisManager());
        return manager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);

        return bean;
    }

    private SimpleCookie rememberMeCookie() {
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        cookie.setMaxAge(60 * 60 * 1000);
        return cookie;
    }

    private CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager manager = new CookieRememberMeManager();
        manager.setCookie(rememberMeCookie());

        return manager;
    }

    @Bean
    public SecurityManager securityManager(ShiroRealm realm) {
        DefaultSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        manager.setSessionManager(sessionManager());

        return manager;
    }

    @Bean
    public SessionManager sessionManager() {
        DefaultSessionManager manager = new DefaultWebSessionManager();
        Collection<SessionListener> listeners = new ArrayList<>();
        listeners.add(new ShiroSessionListener());
        manager.setGlobalSessionTimeout(60 * 60 * 1000L);
        manager.setSessionListeners(listeners);
        manager.setSessionDAO(redisSessionDao());

        return manager;
    }

    @Bean
    public SessionDAO redisSessionDao() {
        RedisSessionDAO dao = new RedisSessionDAO();
        dao.setRedisManager(redisManager());
        return dao;
    }
}
