package nuclear.dao;

import java.util.List;
import nuclear.model.GoodsNu;
import nuclear.model.GoodsNuExample;
import org.apache.ibatis.annotations.Param;

public interface GoodsNuMapper {
    int countByExample(GoodsNuExample example);

    int deleteByExample(GoodsNuExample example);

    int deleteByPrimaryKey(Integer gid);

    int insert(GoodsNu record);

    int insertSelective(GoodsNu record);

    List<GoodsNu> selectByExample(GoodsNuExample example);

    GoodsNu selectByPrimaryKey(Integer gid);

    int updateByExampleSelective(@Param("record") GoodsNu record, @Param("example") GoodsNuExample example);

    int updateByExample(@Param("record") GoodsNu record, @Param("example") GoodsNuExample example);

    int updateByPrimaryKeySelective(GoodsNu record);

    int updateByPrimaryKey(GoodsNu record);
}