package nuclear.service;

import nuclear.model.UserNu;

import java.util.List;

public interface UserNuService {

    /**
     * 查询所有的用户数据
     * @return
     */
    List<UserNu> userquery();

    /**
     * 判断用户名是否存在
     * @param userNu
     * @return
     */
    Boolean judgecname(UserNu userNu);

    /**
     * 添加新用户
     * @param userNu
     * @return
     */
    String useradd(UserNu userNu);

}
