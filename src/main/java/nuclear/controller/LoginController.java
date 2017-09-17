package nuclear.controller;

import nuclear.model.LoginMessage;
import nuclear.model.UserNu;
import nuclear.service.UserNuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@RequestMapping("/login")
@Controller
public class LoginController {
    @Autowired
    private UserNuService userNuService;
    @Autowired
    private  LoginMessage loginMessage;
   @RequestMapping("/dologin")
    public @ResponseBody LoginMessage dologin(UserNu userNu,HttpSession session){
        boolean flag =userNuService.login(userNu,(message)->loginMessage.setMessage(message));
        loginMessage.setFlag(flag);
        if(false == flag){
            return loginMessage;
        }else{
            UserNu userNutemp = userNuService.findByUname(userNu);
            session.setAttribute("id",userNutemp.getUid());
            session.setAttribute("ulimits",userNutemp.getUlimits());
            return loginMessage;
        }
    }
    @RequestMapping("/toindex")
    public String toindex(HttpSession session, Model model) {
        if (null == session.getAttribute("id")) {
            return "login";
        } else {
            int id = Integer.parseInt(session.getAttribute("id").toString());
            String uname = userNuService.findById(id).getUname();
            model.addAttribute("uname", uname);
            return "index";
        }
    }
}
