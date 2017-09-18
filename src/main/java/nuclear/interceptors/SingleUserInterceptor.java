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
        if (url.indexOf("login") >= 0 || url.indexOf("dologin") >= 0) {
            return true;
        }
        if (null != request.getSession().getAttribute("id")) {
            int id = Integer.parseInt(request.getSession().getAttribute("id").toString());
            String sessionid = LoginDataUtil.getSessionIDMap().get(id);
            if (sessionid.equals(request.getSession().getId())) {
                return true;
            } else {
                 if(request.getHeader("x-requested-with")!=null
                        && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
                    response.setHeader("sessionstatus","timeout");
                    return false;
                }else{
                   String indexurl=request.getContextPath();
                   response.sendRedirect(indexurl);
                   return false;
                }
            }
        }
        request.getRequestDispatcher(request.getContextPath()).forward(request, response);
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
