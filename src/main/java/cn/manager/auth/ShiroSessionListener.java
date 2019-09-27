package cn.manager.auth;


import org.apache.catalina.SessionEvent;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Wangyl
 * @date 2019/9/26
 */
public class ShiroSessionListener implements SessionListener {

    private final AtomicInteger sessionCount = new AtomicInteger(0);

    @Override
    public void onStart(Session session) {
        sessionCount.incrementAndGet();
    }

    @Override
    public void onStop(Session session) {
        sessionCount.decrementAndGet();
    }

    @Override
    public void onExpiration(Session session) {
        sessionCount.decrementAndGet();
    }
}
