package nuclear.dao;

import java.util.List;
import nuclear.model.ControlNu;
import nuclear.model.ControlNuExample;
import org.apache.ibatis.annotations.Param;

public interface ControlNuMapper {
    int countByExample(ControlNuExample example);

    int deleteByExample(ControlNuExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(ControlNu record);

    int insertSelective(ControlNu record);

    List<ControlNu> selectByExample(ControlNuExample example);

    ControlNu selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") ControlNu record, @Param("example") ControlNuExample example);

    int updateByExample(@Param("record") ControlNu record, @Param("example") ControlNuExample example);

    int updateByPrimaryKeySelective(ControlNu record);

    int updateByPrimaryKey(ControlNu record);
}