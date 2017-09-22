package nuclear.controller;

import nuclear.model.DeleteModel;
import nuclear.model.UserNu;
import nuclear.service.UserNuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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

    /**
     * 修改解除限制
     * @return
     */
    @RequestMapping("/usermodify")
    @ResponseBody
    public String usermodify(){
        System.out.println("1");
        return "modify1";
    }

    /**
     * 修改信息
     * @return
     */
    @RequestMapping("/usermodify2")
    @ResponseBody
    public String usermodify2(UserNu userNu,HttpSession session){
        System.out.println("增加");
        userNu.setUid((int)session.getAttribute("id"));
        userNuService.usermodify(userNu);
        System.out.println("2");
        return "modify2";
    }

    /**
     * 验证用户名是否存在(不包括自己)
     * @param userNu
     * @return
     */
    @RequestMapping("/checkModify")
    @ResponseBody
    public Map checkModify(UserNu userNu,HttpSession session){
        System.out.println("1");
        session.getAttribute("name");
        System.out.println(session.getAttribute("name"));
        Map<String ,Boolean> map = new HashMap<String, Boolean>();
        Boolean judge = false;
        if(session.getAttribute("name").equals(userNu.getUname())){
            judge = true;
            map.put("valid",judge);
        }else {
            judge = userNuService.judgecname(userNu);
            map.put("valid",judge);
        }
        return map;
    }

    /**
     * 根据seesionID查询所有信息
     * @param userNu
     * @param session
     * @return
     */
    @RequestMapping("/userFind")
    @ResponseBody
    public UserNu userFind(UserNu userNu,HttpSession session){
        int id = Integer.parseInt(session.getAttribute("id").toString());
        userNu = userNuService.findById(id);
        return userNu;
    }

    /**
     * 成功跳转
     * @return
     */
    @RequestMapping("/userlogin")
    public String userlogin(){
        return "login";
    }

    /**
     * 用户的分页查询
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @RequestMapping("selectByUser")
    @ResponseBody
    public Map<String ,Object> selectByUser(int pageSize,int pageNumber,String uname){
        System.out.println("user查询");
        System.out.println("参数测试"+uname);
        /* 所需参数 */
        int offset=(pageNumber-1)*pageSize;
        int limits=pageSize;
        return userNuService.selectByUser(offset,limits,uname);
    }

    /**
     * 管理员的分页查询
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @RequestMapping("selectByManage")
    @ResponseBody
    public Map<String ,Object> selectByManage(int pageSize,int pageNumber,String uname){
        System.out.println("管理员user查询");
        System.out.println("测试1111111111"+uname);
        /* 所需参数 */
        int offset=(pageNumber-1)*pageSize;
        int limits=pageSize;
        return userNuService.selectByManage(offset,limits,uname);
    }

    /**
     * 删除
     * @param deleteModel
     */
    @RequestMapping("/delete")
    public void userdelete(@RequestBody DeleteModel deleteModel){
        //   String []data =request.getParameterValues("names");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        String[] username = deleteModel.getNames();
        for (String name:username
                ) {
            System.out.println(name);
            userNuService.deletebyname(name);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
    }


}
