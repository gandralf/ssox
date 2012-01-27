package com.yell.sso.demo;

import com.yell.sso.SSOHelper;
import com.yell.sso.SSOService;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        SSOHelper sso = new SSOHelper(new SSOService("http://sso.amarillas.cl/")); // todo singleton
        if (sso.isLoggedIn(request)) {
            return mapping.findForward("success");
        } else {
            return new ActionRedirect(sso.getRedirect());
        }
    }
}
