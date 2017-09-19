package nuclear.service.impl;

import nuclear.dao.UserNuMapper;
import nuclear.interfaces.MessageSender;
import nuclear.model.UserNu;
import nuclear.model.UserNuExample;
import nuclear.service.UserNuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
}
