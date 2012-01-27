package com.yell.sso;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SSOService {
    private static final String LOGIN_URL_BASE="/user/login?redirectURL=";
    private static final String SHOW_USER = "/user/show";
    private String baseUrl;

    public SSOService(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    
    public String redirectUrlFor(String returnUrl) {
        // todo URL encode
        return baseUrl + LOGIN_URL_BASE + returnUrl;
    }

    public SSOUser completeLogin(String key) {
        return new SSOUser("mamae");

        /*
        boolean ok = false;
        try {
            URL urlClient = new URL(new URL(baseUrl), SHOW_USER + "?key=" + key);

            HttpURLConnection connection = (HttpURLConnection) urlClient.openConnection();

            if (ok = (connection.getResponseCode() == 200)) {
                JSONObject object = JSONObject.fromString(urlClient.toString(connection.getInputStream()));

                PlanosUser user = new PlanosUser();
                user.setId(object.getInt("id"));
                user.setLogin(object.getString("login"));

                try {
                    SocialProfile socialProfile = socialService.profile(user.getId());
                    user.setSocialProfile(socialProfile);

                } catch (ServiceException e) {
                    logger.debug("Erro ao obter perfil do Social: " + e.getMessage(), e);
                }

                cookieUtil.addObjectToCookie(USER_COOKIE, user, response);

                if (logger.isDebugEnabled()) {
                    logger.debug("Usuario logado no SSO: " + user);
                }
            }
        } catch (Exception e) {
            throw new ServiceException("Erro ao efetuar o login no SSO. " + e.getMessage(), e);
        }
        return ok;
        */
    }
}
