package nuclear.service.impl;

import nuclear.dao.UserNuMapper;
import nuclear.interfaces.MessageSender;
import nuclear.model.UserNu;
import nuclear.model.UserNuExample;
import nuclear.service.UserNuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "userNuService")
public class UserNuServiceImpl implements UserNuService {

    @Resource
    UserNuExample userNuExample;

    @Resource
    UserNuMapper userNuMapper;

    /**
     * 添加管理员信息
     * @param userNu
     * @return
     */
    @Override
    public String useradd(UserNu userNu) {
        int readd = userNuMapper.insert(userNu);
        System.out.println(readd);
        return null;
    }

    /**
     * 判断用户名是否存在
     * @param userNu
     * @return
     */
    @Override
    public Boolean judgecname(UserNu userNu) {
        userNuExample.clear();
        userNuExample.createCriteria().andUnameEqualTo(userNu.getUname());
        List<UserNu> userNus = userNuMapper.selectByExample(userNuExample);
        Boolean judge = false;
        if(0 == userNus.size()){
            judge = true;
        }else {
            judge = false;
        }
        return judge;
    }

    /**
     * 查询所有的用户数据
     * @return
     */
    @Override
    public List<UserNu> userquery() {
        List<UserNu> userNus = userNuMapper.selectByExample(null);
        return userNus;
    }

    /**
     * 判断登录是否成功
     * @param userNu
     * @param messageSender
     * @return
     */
    @Override
    public boolean login(UserNu userNu, MessageSender messageSender) {
        userNuExample.clear();
        userNuExample.createCriteria().andUnameEqualTo(userNu.getUname());
        if (0== userNuMapper.countByExample(userNuExample)){
            messageSender.sendMessage("账号不存在");
            return false;
        }else{
            UserNu userNu1temp = userNuMapper.selectByExample(userNuExample).get(0);
            if (userNu1temp.getUpassword().equals(userNu.getUpassword())){
                messageSender.sendMessage("登录成功");
                return true;
            }else{
                messageSender.sendMessage("密码错误");
                return  false;
            }
        }
    }

    /**
     * 按姓名查找
     * @param userNu
     * @return
     */
    @Override
    public UserNu findByUname(UserNu userNu) {
        userNuExample.clear();
        userNuExample.createCriteria().andUnameEqualTo(userNu.getUname());
        return userNuMapper.selectByExample(userNuExample).get(0);
    }

    /**
     * 按ID查找
     * @param id
     * @return
     */
    @Override
    public UserNu findById(int id) {
        return userNuMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改用户信息
     * @param userNu
     * @return
     */
    @Override
    public String usermodify(UserNu userNu) {
        userNuExample.clear();
        userNuExample.createCriteria().andUidEqualTo(userNu.getUid());
        userNuMapper.updateByExampleSelective(userNu,userNuExample);
        return "success";
    }

    /**
     * 分页查询实现
     * @param offset
     * @param limit
     * @return
     */
    @Override
    public Map<String, Object> selectByUser(int offset, int limit,String uname) {
        //清理Example将limit和offset放进去
        System.out.println("普通用户测试1111"+uname);
        userNuExample.clear();
        int total=0;
        if(uname.equals("")){
            System.out.println("uname是null");
            total = userNuMapper.selectByExample(null).size();

        }else{
            System.out.println("uname进入");
            uname = "%" + uname + "%";
            userNuExample.createCriteria().andUnameLike(uname).andUlimitsEqualTo(3);
            total = userNuMapper.selectByExample(userNuExample).size();
        }

        /*userNuExample.createCriteria().andUlimitsEqualTo(3);*/
       /* int total = userNuMapper.selectByExample(userNuExample).size();*/
        userNuExample.setLimit(limit);
        userNuExample.setOffset(offset);
        //用map存放数据
        Map<String,Object> result = new HashMap<String,Object>();
        List<UserNu> rows =userNuMapper.selectByExample(userNuExample);
        result.put("total",total);
        result.put("rows",rows);
        return result;
    }

    /**
     * 管理员分页查询的实现
     * @param offset
     * @param limit
     * @return
     */
    @Override
    public Map<String, Object> selectByManage(int offset, int limit,String uname) {
        //清理Example将limit和offset放进去
        System.out.println("11111111111实现类参数"+uname);
        int total=0;
        userNuExample.clear();

        if(uname.equals("")){
            System.out.println("uname是null");
            total = userNuMapper.selectByExample(null).size();

        }else{
            System.out.println("uname进入");
            uname = "%" + uname + "%";
            userNuExample.createCriteria().andUnameLike(uname).andUlimitsEqualTo(2);
            total = userNuMapper.selectByExample(userNuExample).size();
        }
       /* userNuExample.createCriteria().andUlimitsEqualTo(2).andUnameLike(uname);*/
       /*int total = userNuMapper.selectByExample(userNuExample).size();*/
        userNuExample.setLimit(limit);
        userNuExample.setOffset(offset);
        //用map存放数据
        Map<String,Object> result = new HashMap<String,Object>();
        List<UserNu> rows =userNuMapper.selectByExample(userNuExample);
        result.put("total",total);
        result.put("rows",rows);
        return result;
    }
}
