package com.example.designer.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class InitInterceptor implements HandlerInterceptor {
 
	@Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //方法执行之前调用拦截
        System.out.println("拦截成功");
		String path = httpServletRequest.getServletPath();
		Boolean id=false,ma=false;
		Cookie[] cookies = httpServletRequest.getCookies();
        Cookie cookie = null;
        if(cookies!=null) {
        	for (int i = 0; i < cookies.length; i++) {
        		cookie = cookies[i];
        		if (cookie.getName().equals("useridss")) {
        			id=true;
        		}
        		if (cookie.getName().equals("uma")) {
        			ma=true;
        		}
        	}
        }
        System.out.println(id+"---"+ma);
        if(!id) {
        	httpServletResponse.sendRedirect("http://localhost:8080/designer/index.html");
        	return false;
        }else {
        	if(!ma&&path.contains("/manage/")) {
        		httpServletResponse.sendRedirect("http://localhost:8080/designer/index.html");
        		return false;
        	}
            return true;
        }
		//这里写拦截之后的处理
    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
 
}