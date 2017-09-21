package nuclear.service;

import nuclear.model.GoodsNu;

import java.util.List;
import java.util.Map;

public interface GoodsNuService {

    /**
     * 添加商品
     * @param goodsNu
     * @return
     */
    String goodsadd(GoodsNu goodsNu);

    /**
     * 判断商品名是否重复
     * @param goodsNu
     * @return
     */
    Boolean judgegoods(GoodsNu goodsNu);

    /**
     * 查询所有商品
     * @return
     */
    List<GoodsNu> goodsquery();


    /**
     * 分页查询
     * @param offset
     * @param limit
     * @return
     */
    Map<String,Object> selectByFy(int offset,int limit,String gname);

}
