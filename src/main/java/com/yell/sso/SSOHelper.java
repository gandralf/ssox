package com.yell.sso;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SSOHelper {

    public final String SSO_COOKIE = "user";
    private SSOService ssoService;

    public SSOHelper(SSOService ssoService) {

        this.ssoService = ssoService;
    }

    public boolean isLoggedIn(HttpServletRequest request) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (SSO_COOKIE.equals(cookie.getName())) {
                    // todo: encrypt
                    return true;
                }
            }
        }

        return false;
    }

    public String getRedirect() {
        return ssoService.redirectUrlFor("http://localhost:8080/login.do");
    }

    public void completeLogin(HttpServletResponse response, String key) {
        SSOUser user = ssoService.completeLogin(key);
        response.addCookie(new Cookie(SSO_COOKIE, user.getLogin()));
    }
}
