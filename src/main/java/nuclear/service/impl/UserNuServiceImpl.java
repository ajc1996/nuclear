package nuclear.service.impl;

import nuclear.dao.UserNuMapper;
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
}
