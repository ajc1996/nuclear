package nuclear.controller;

import nuclear.model.UserNu;
import nuclear.service.UserNuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserNuController {

    @Resource
    UserNuService userNuService;

    /**
     * 查询所有用户信息
     * @param userNu
     * @return
     */
    @RequestMapping("/userquery")
    public @ResponseBody Object userquery(UserNu userNu){
        System.out.println("1");
        List<UserNu> userNus = userNuService.userquery();
        return userNus;
    }

    /**
     * 验证用户名是否存在
     * @param userNu
     * @return
     */
    @RequestMapping("/checkExist")
    @ResponseBody
    public Map checkExist(UserNu userNu){
        Map<String ,Boolean> map = new HashMap<String, Boolean>();
        Boolean judge = userNuService.judgecname(userNu);
        map.put("valid",judge);
        return map;
    }

    /**
     * 添加管理员
     * @param userNu
     * @return
     */
    @RequestMapping("/useradd")
    @ResponseBody
    public String useradd(UserNu userNu){
        String readd = userNuService.useradd(userNu);
        System.out.println("2");
        return "success";
    }

}
