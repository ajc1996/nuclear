package nuclear.service.impl;

import nuclear.dao.GoodsNuMapper;
import nuclear.model.GoodsNu;
import nuclear.model.GoodsNuExample;
import nuclear.service.GoodsNuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsNuServiceImpl implements GoodsNuService {

    @Resource
    GoodsNuMapper goodsNuMapper;

    @Resource
    GoodsNuExample goodsNuExample;

    /**
     * 插入数据
     * @param goodsNu
     * @return
     */
    @Override
    public String goodsadd(GoodsNu goodsNu) {
        int regoodsadd = goodsNuMapper.insert(goodsNu);
        System.out.println(regoodsadd);
        return null;
    }

    /**
     * 判断商品名是否重复
     * @param goodsNu
     * @return
     */
    @Override
    public Boolean judgegoods(GoodsNu goodsNu) {
        goodsNuExample.clear();
        goodsNuExample.createCriteria().andGnameEqualTo(goodsNu.getGname());
        List<GoodsNu> goodsNus = goodsNuMapper.selectByExample(goodsNuExample);
        Boolean judge = false;
        if(0 == goodsNus.size()){
            judge = true;
        }else {
            judge = false;
        }
        return judge;
    }

    /**
     * 查询所有商品
     * @param
     * @return
     */
    @Override
    public List<GoodsNu> goodsquery() {
        List<GoodsNu> goodsNus = goodsNuMapper.selectByExample(null);
        return goodsNus;
    }

    /**
     * 分页查询
     * @param offset
     * @param limit
     * @return
     */
    @Override
    public Map<String, Object> selectByFy(int offset,int limit,String gname) {
        //清理Example将limit和offset放进去
        goodsNuExample.clear();
        int total = 0;
        if(gname.equals("")){
            System.out.println("gname是null");
            total = goodsNuMapper.selectByExample(null).size();
        }else{
            System.out.println("gname进入");
            gname = "%" + gname + "%";
            goodsNuExample.createCriteria().andGnameLike(gname);
            total = goodsNuMapper.selectByExample(goodsNuExample).size();
        }
        goodsNuExample.setLimit(limit);
        goodsNuExample.setOffset(offset);
        //用map存放数据；bootstrap table需要两个参数一个就是total和rows
        Map<String,Object> result = new HashMap<String,Object>();
        List<GoodsNu> rows = goodsNuMapper.selectByExample(goodsNuExample);
        result.put("total",total);
        result.put("rows",rows);
        return result;
    }
}
