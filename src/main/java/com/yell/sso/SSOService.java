package com.yell.sso;

import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class SSOService {
    private static final String LOGIN_URL_BASE="user/login?redirectURL=";
    private static final String SHOW_USER = "user/show?key=";
    private String baseUrl;

    public SSOService(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    
    public String redirectUrlFor(String returnUrl) {
        // todo URL encode
        return baseUrl + LOGIN_URL_BASE + returnUrl;
    }

    public SSOUser completeLogin(String key) throws IOException {
        URL checkUserUrl = new URL(new URL(baseUrl), SHOW_USER + key);
        String userJson = requestContent(checkUserUrl);

        JSONObject jsonObject = JSONObject.fromObject(userJson);

        return new SSOUser(jsonObject.get("login").toString());
    }

    private String requestContent(URL url) throws IOException {
        InputStreamReader inputStream = new InputStreamReader(url.openStream());
        char[] buff = new char[512];
        StringBuilder out = new StringBuilder();
        int count;
        while((count = inputStream.read(buff)) != -1) {
            out.append(buff, 0, count);
        }

        return out.toString();
    }
}
