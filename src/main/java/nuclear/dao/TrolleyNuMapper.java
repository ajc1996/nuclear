package nuclear.dao;

import java.util.List;
import nuclear.model.TrolleyNu;
import nuclear.model.TrolleyNuExample;
import org.apache.ibatis.annotations.Param;

public interface TrolleyNuMapper {
    int countByExample(TrolleyNuExample example);

    int deleteByExample(TrolleyNuExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TrolleyNu record);

    int insertSelective(TrolleyNu record);

    List<TrolleyNu> selectByExample(TrolleyNuExample example);

    TrolleyNu selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TrolleyNu record, @Param("example") TrolleyNuExample example);

    int updateByExample(@Param("record") TrolleyNu record, @Param("example") TrolleyNuExample example);

    int updateByPrimaryKeySelective(TrolleyNu record);

    int updateByPrimaryKey(TrolleyNu record);
}