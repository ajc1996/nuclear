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

    @Override
    public List<UserNu> userquery() {
        List<UserNu> userNus = userNuMapper.selectByExample(null);
        System.out.println(userNus.size());
        for(int i=0;i<userNus.size();i++){
            System.out.println(userNus.get(i).getUid());
        }
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
