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
     *
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

    @Override
    public UserNu findByUname(UserNu userNu) {
        userNuExample.clear();
        userNuExample.createCriteria().andUnameEqualTo(userNu.getUname());
        return userNuMapper.selectByExample(userNuExample).get(0);
    }

    @Override
    public UserNu findById(int id) {
        return userNuMapper.selectByPrimaryKey(id);
    }
}
