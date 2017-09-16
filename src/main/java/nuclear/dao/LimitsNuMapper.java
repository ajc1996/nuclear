package nuclear.dao;

import java.util.List;
import nuclear.model.LimitsNu;
import nuclear.model.LimitsNuExample;
import org.apache.ibatis.annotations.Param;

public interface LimitsNuMapper {
    int countByExample(LimitsNuExample example);

    int deleteByExample(LimitsNuExample example);

    int deleteByPrimaryKey(String lid);

    int insert(LimitsNu record);

    int insertSelective(LimitsNu record);

    List<LimitsNu> selectByExample(LimitsNuExample example);

    LimitsNu selectByPrimaryKey(String lid);

    int updateByExampleSelective(@Param("record") LimitsNu record, @Param("example") LimitsNuExample example);

    int updateByExample(@Param("record") LimitsNu record, @Param("example") LimitsNuExample example);

    int updateByPrimaryKeySelective(LimitsNu record);

    int updateByPrimaryKey(LimitsNu record);
}