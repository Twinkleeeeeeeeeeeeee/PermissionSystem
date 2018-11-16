package com.asiainfo.permission.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter{
	
	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		
		//在这里进行验证码校验
		//如果校验失败提示验证码失败，将失败信息通过shiroLoginFail
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpSession session = httpServletRequest.getSession();
		//取出正确的验证吗；
		String validateCode = (String) session.getAttribute("validateCode");
		//取出页面的验证码
		String randomcode = httpServletRequest.getParameter("randomcode");
		if(randomcode!=null && validateCode!=null && !randomcode.equals(validateCode)) {
			httpServletRequest.setAttribute("shiroLoginFailure", "randomError");
			return true;
		}
		return super.onAccessDenied(request, response);
	}
	
}
