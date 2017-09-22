package nuclear.service;

import nuclear.model.GoodsNu;
import nuclear.model.TrolleyNu;

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

    /**
     * 根据名字删除
     * @param name
     */
    void deletebyname(String name);

    /**
     * 查询数据
     * @return
     */
    List<GoodsNu> selectByHome(GoodsNu goodsNu);

    /**
     * 根据名字查询
     * @return
     */
    List<GoodsNu> selectByGname(String gname);

    /**
     * 根据图片地址加载
     * @param gpic
     * @return
     */
    List<GoodsNu> selectByGpic(String gpic);

    /**
     * 添加购物信息
     * @param trolleyNu
     * @return
     */
    String addTrolley(TrolleyNu trolleyNu);


}
