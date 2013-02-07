//package com.xc.taosku.kernel.util.interceptor;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import com.jd.common.web.LoginContext;
//import com.jd.common.web.cookie.CookieUtils;
//
///**
// * 
// * port from com.jd.common.struts.interceptor.NewLoginContextInterceptor
// * 
// * @see com.jd.common.struts.interceptor.NewLoginContextInterceptor
// * @see com.jd.common.struts.interceptor.LoginContextInterceptor
// * @author xiaofei
// * 
// */
//public class LoginContextInterceptor extends HandlerInterceptorAdapter {
//
//    private final static Log log = LogFactory
//            .getLog(LoginContextInterceptor.class);
//    protected CookieUtils cookieUtils;
//
//    protected String loginCookieKey = "_lc_";
//    /**
//     * 判断session有效时间，单位：秒 1800 为 30 * 60 。30分钟
//     */
//    protected int sessionTimeout = 1800;
//    /**
//     * 写入cookie的时机
//     */
//    protected int rate = 2;
//
//
//    /**
//     * �����cookie�еõ�login context���󣬿��Ա����ǣ�
//     * 
//     * @param cookieValue
//     * @return
//     */
//    protected LoginContext getLoginContext(String cookieValue) {
//        return LoginContext.parse(cookieValue);
//    }
//
//    public void setCookieUtils(CookieUtils cookieUtils) {
//        this.cookieUtils = cookieUtils;
//    }
//
//    /**
//     * ��struts2��ע��
//     * 
//     * @param loginCookieKey
//     */
//    public void setLoginCookieKey(String loginCookieKey) {
//        this.loginCookieKey = loginCookieKey;
//    }
//
//    public void setSessionTimeout(int sessionTimeout) {
//        this.sessionTimeout = sessionTimeout;
//    }
//
//    public void setRate(int rate) {
//        this.rate = rate;
//    }
//
//    @Override
//    public final boolean preHandle(HttpServletRequest request,
//            HttpServletResponse response, Object handler)
//            throws ServletException,
//            IOException {
//
//        try {
//            updateLogin(request, response);
//        } catch (Exception e) {
//            log.warn("updatelogin error!", e);
//        }
//
//        return true;
//    }
//
//    public void afterCompletion(
//            HttpServletRequest request, HttpServletResponse response,
//            Object handler, Exception ex)
//            throws Exception {
//        LoginContext.remove();
//    }
//
//    protected void updateLogin(HttpServletRequest request,
//            HttpServletResponse response) {
//        // 判断是否配置了cookie的cookie名称
//        if (loginCookieKey != null) {
//            try {
//                String value = cookieUtils.getCookieValue(request,
//                        loginCookieKey);
//                if (StringUtils.isNotBlank(value)) {// 能取到值
//                    LoginContext context = getLoginContext(value);
//                    if (context != null) {// 又能解出来
//                        long current = System.currentTimeMillis();
//                        long created = context.getCreated();
//                        long expires = context.getExpires();
//                        long timeout = expires == 0 ? sessionTimeout * 1000
//                                : expires - created;// 如果没有设置过期时间，则使用默认的
//                        if (current - created < timeout) { // 如果没有过期
//                            LoginContext.setLoginContext(context);
//                            if ((current - created) * rate > timeout) {// 如果剩下的时间只有2/3，就需要重新派发cookie
//                                log.debug("session cookie[" + loginCookieKey
//                                        + "] rewrite!");
//                                // 写最后一次访问的cookie
//                                context.setCreated(current);
//                                if (expires != 0) {
//                                    context.setTimeout(timeout);
//                                }
//                                cookieUtils.setCookie(response, loginCookieKey,
//                                        context.toCookieValue());
//                            }
//                        } else {
//                            log.debug("session cookie[" + loginCookieKey
//                                    + "] is valid!");
//                            // 超时后，要清空
//                            cookieUtils.invalidate(request, response);
//                        }
//                    } else {
//                        log.debug("session cookie[" + loginCookieKey
//                                + "] is error!");
//                    }
//                } else {
//                    log.debug("session cookie[" + loginCookieKey
//                            + "] is empty!");
//                }
//            } catch (Exception e) {
//                log.error("login intercept error", e);
//            }
//        } else {
//            log.debug("session cookie key is empty!");
//        }
//
//    }
//
//}
