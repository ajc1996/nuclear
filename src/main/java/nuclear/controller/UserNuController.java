package nuclear.controller;

import nuclear.model.UserNu;
import nuclear.service.UserNuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserNuController {

    @Resource
    UserNuService userNuService;

    @RequestMapping("/userquery")
    public @ResponseBody Object userquery(UserNu userNu){
        System.out.println("1");
        List<UserNu> userNus = userNuService.userquery();
        return userNus;
    }

}
