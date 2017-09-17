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

    @Override
    public List<UserNu> userquery() {
        List<UserNu> userNus = userNuMapper.selectByExample(null);
        System.out.println(userNus.size());
        for(int i=0;i<userNus.size();i++){
            System.out.println(userNus.get(i).getUid());
        }
        return userNus;
    }
}
