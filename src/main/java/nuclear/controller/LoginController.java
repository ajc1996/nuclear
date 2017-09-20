package nuclear.controller;

import nuclear.model.ControlNu;
import nuclear.model.LoginMessage;
import nuclear.model.UserNu;
import nuclear.service.ControlNuService;
import nuclear.service.UserNuService;
import nuclear.utils.LoginDataUtil;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.List;

/**
 *登录controller类
 */
@RequestMapping("/login")
@Controller
public class LoginController {
    @Autowired
    private UserNuService userNuService;
    @Autowired
    private  LoginMessage loginMessage;
    @Autowired
    private ControlNuService controlNuService;

    /**
     * 登录校验
     * @param userNu
     * @param session
     * @param authCode
     * @param request
     * @return
     */
   @RequestMapping("/dologin")
    public @ResponseBody LoginMessage dologin(UserNu userNu,HttpSession session,String authCode,HttpServletRequest request){
       if(session.getAttribute("strCode").toString().equals(authCode)) {//如果验证码正确的话
           boolean flag = userNuService.login(userNu, (message) -> loginMessage.setMessage(message));//接收service判断的登录是否成功
           loginMessage.setFlag(flag);
           if (false == flag) {
               return loginMessage;
           } else {
               UserNu userNutemp = userNuService.findByUname(userNu);
               int uid = userNutemp.getUid();
               session.setAttribute("id", uid);
               session.setAttribute("name", userNutemp.getUname());
               session.setAttribute("pic", userNutemp.getUpic());
               session.setAttribute("ulimits", userNutemp.getUlimits());
               String sessionID = request.getRequestedSessionId();
               if (!LoginDataUtil.getSessionIDMap().containsKey(uid)) { //不存在，首次登陆，放入Map
                   LoginDataUtil.getSessionIDMap().put(uid, sessionID);
               }else if(LoginDataUtil.getSessionIDMap().containsKey(uid)&&!StringUtils.equals(sessionID, LoginDataUtil.getSessionIDMap().get(uid))){
                   LoginDataUtil.getSessionIDMap().remove(uid);
                   LoginDataUtil.getSessionIDMap().put(uid, sessionID);
               }
               return loginMessage;
           }
       }else{
           loginMessage.setFlag(false);
           loginMessage.setMessage("验证码错误");
           return loginMessage;
       }
    }

    /**
     * 跳转到主页
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/toindex")
    public String toindex(HttpSession session, Model model) {
        if (null == session.getAttribute("id")) {
            return "login";
        } else {
            int id = (int)session.getAttribute("ulimits");
            List<ControlNu> controlNuList = controlNuService.getLimitsByIden(id);
            model.addAttribute("controlNuList",controlNuList);
            return "index";
        }
    }

    /**
     * 验证码生成方法
     * @param request
     * @param response
     * @param session
     * @throws IOException
     */
    @RequestMapping("/authCode")
    public void getAuthCode(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws IOException {
        int width = 63;
        int height = 37;
        Random random = new Random();
        //设置response头信息
        //禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //生成缓冲区image类
        BufferedImage image = new BufferedImage(width, height, 1);
        //产生image类的Graphics用于绘制操作
        Graphics g = image.getGraphics();
        //Graphics类的样式
        g.setColor(this.getRandColor(200, 250));
        g.setFont(new Font("Times New Roman",0,28));
        g.fillRect(0, 0, width, height);
        //绘制干扰线
        for(int i=0;i<40;i++){
            g.setColor(this.getRandColor(130, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }

        //绘制字符
        String strCode = "";
        for(int i=0;i<4;i++){
            String rand = String.valueOf(random.nextInt(10));
            strCode = strCode + rand;
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand, 13*i+6, 28);
        }
        //将字符保存到session中用于前端的验证
        session.setAttribute("strCode", strCode);
        g.dispose();

        ImageIO.write(image, "JPEG", response.getOutputStream());
        response.getOutputStream().flush();

    }

    private Color getRandColor(int fc,int bc) {
            Random random = new Random();
            if(fc>255)
                fc = 255;
            if(bc>255)
                bc = 255;
            int r = fc + random.nextInt(bc - fc);
            int g = fc + random.nextInt(bc - fc);
            int b = fc + random.nextInt(bc - fc);
            return new Color(r,g,b);
    }
}
