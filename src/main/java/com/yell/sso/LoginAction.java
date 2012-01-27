package com.yell.sso;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String key = request.getParameter("key");
        SSOHelper ssoHelper = new SSOHelper(new SSOService("http://sso.amarillas.cl/")); // Todo: singleton
        ssoHelper.completeLogin(response, key);

        return mapping.findForward("success");
    }
}
