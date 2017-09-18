package nuclear.interceptors;

import nuclear.utils.LoginDataUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.PrintWriter;

public class SingleUserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        String url = request.getRequestURI();
        if (url.contains("login") || url.contains("dologin")) {
            System.out.println("登录请求");
            return true;
        }
        if (null != request.getSession().getAttribute("id")) {
            int id = Integer.parseInt(request.getSession().getAttribute("id").toString());
            String sessionid = LoginDataUtil.getSessionIDMap().get(id);
            if (sessionid.equals(request.getSession().getId())) {
                System.out.println("已登录");
                return true;
            } else {
                 if(request.getHeader("x-requested-with")!=null
                        && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
                    response.setHeader("sessionstatus","timeout");
                     System.out.println("异步重定向");
                     return false;
                }else{
                   String indexurl=request.getContextPath()+"view/login.jsp";
                   response.sendRedirect(indexurl);
                     System.out.println("非异步重定向："+indexurl);
                   return false;
                }
            }
        }
        request.getRequestDispatcher(request.getContextPath()+"view/login.jsp").forward(request, response);
        System.out.println("未登录");
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
