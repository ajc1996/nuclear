package nuclear.dao;

import java.util.List;
import nuclear.model.UserNu;
import nuclear.model.UserNuExample;
import org.apache.ibatis.annotations.Param;

public interface UserNuMapper {
    int countByExample(UserNuExample example);

    int deleteByExample(UserNuExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(UserNu record);

    int insertSelective(UserNu record);

    List<UserNu> selectByExample(UserNuExample example);

    UserNu selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") UserNu record, @Param("example") UserNuExample example);

    int updateByExample(@Param("record") UserNu record, @Param("example") UserNuExample example);

    int updateByPrimaryKeySelective(UserNu record);

    int updateByPrimaryKey(UserNu record);
}