package com.yell.sso;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SSOServiceTest {
    @Test
    public void shouldReturnValidUser() throws IOException {
        String resourcePath = "user/show";
        String url = getClass().getClassLoader().getResource(resourcePath).toString();
        String baseUrl = url.substring(0, url.length() - resourcePath.length());

        SSOService ssoService = new SSOService(baseUrl);
        SSOUser user = ssoService.completeLogin("123");
        assertEquals("labs", user.getLogin());
    }
}
