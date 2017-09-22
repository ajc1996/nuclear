package test;

import nuclear.dao.GoodsNuMapper;
import nuclear.model.GoodsNu;
import nuclear.model.TrolleyNu;
import nuclear.service.TrolleyNuService;
import nuclear.service.UserNuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class TrolleyNuServiceImplTest extends BaseTest {
    @Autowired
    private TrolleyNuService trolleyNuService;
    @Autowired
    private  UserNuService userNuService;
    @Autowired
    private GoodsNuMapper goodsNuMapper;
    @Test
    public void allGoods() throws Exception {
        List<TrolleyNu> trolleyNuList = trolleyNuService.allGoods(1);
        trolleyNuList.forEach(trolleyNu -> System.out.println(trolleyNu.toString()));
    }

    @Test
    public void buy() throws Exception {
        System.out.println(trolleyNuService.buy(trolleyNuService.allGoods(1).get(0)));
    }

    @Test
    public void update() throws Exception {
        TrolleyNu trolleyNu = trolleyNuService.allGoods(1).get(0);
        trolleyNu.setTcount(8);
        trolleyNuService.update(userNuService.findById(1),trolleyNu);
    }

    @Test
    public void remove() throws Exception {

    }

    @Test
    public void add() throws Exception {
        List<GoodsNu> goodsNus =goodsNuMapper.selectByExample(null);
        goodsNus.forEach(goodsNu -> {
            TrolleyNu trolleyNu = new TrolleyNu();
            trolleyNu.setTuid(1);
            trolleyNu.setTgid(goodsNu.getGid());
            trolleyNu.setTcount(new Random().nextInt(100)+1);
            trolleyNuService.add(trolleyNu);
        });
    }

}