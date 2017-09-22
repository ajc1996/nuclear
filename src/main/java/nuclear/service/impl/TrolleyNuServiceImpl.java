package nuclear.service.impl;

import nuclear.dao.GoodsNuMapper;
import nuclear.dao.TrolleyNuMapper;
import nuclear.model.GoodsNu;
import nuclear.model.TrolleyNu;
import nuclear.model.TrolleyNuExample;
import nuclear.model.UserNu;
import nuclear.service.TrolleyNuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrolleyNuServiceImpl implements TrolleyNuService {
    @Autowired
    private TrolleyNuMapper trolleyNuMapper;
    @Autowired
    private GoodsNuMapper goodsNuMapper;
    @Autowired
    private TrolleyNuExample trolleyNuExample;

    @Override
    public List<TrolleyNu> allGoods(int id) {
        trolleyNuExample.clear();
        trolleyNuExample.createCriteria().andTuidEqualTo(id);
        List<TrolleyNu> trolleyNuList =trolleyNuMapper.selectByExample(trolleyNuExample);
        trolleyNuList.forEach(trolleyNu -> trolleyNu.setGoodsNu(goodsNuMapper.selectByPrimaryKey(trolleyNu.getTgid())));
        return trolleyNuList;
    }

    @Override
    public float buy(TrolleyNu trolleyNu) {
        float count = (float) (trolleyNu.getTcount()*goodsNuMapper.selectByPrimaryKey(trolleyNu.getTgid()).getGprice());
        trolleyNuMapper.deleteByPrimaryKey(trolleyNu.getTid());
        return count;
    }

    @Override
    public boolean update(UserNu userNu, TrolleyNu trolleyNu) {
        trolleyNuExample.clear();
        trolleyNuExample.createCriteria().andTuidEqualTo(userNu.getUid()).andTgidEqualTo(trolleyNu.getTgid());
        trolleyNuMapper.updateByExampleSelective(trolleyNu,trolleyNuExample);
        return true;
    }

    @Override
    public boolean remove(TrolleyNu trolleyNu) {
        trolleyNuMapper.deleteByPrimaryKey(trolleyNu.getTid());
        return true;
    }

    @Override
    public boolean remove(int id) {
        trolleyNuMapper.deleteByPrimaryKey(id);
        return true;
    }

    @Override
    public boolean add(TrolleyNu trolleyNu) {
        trolleyNuMapper.insert(trolleyNu);
        return true;
    }

    @Override
    public TrolleyNu findById(int id) {
       TrolleyNu trolleyNu=trolleyNuMapper.selectByPrimaryKey(id);
       trolleyNu.setGoodsNu(goodsNuMapper.selectByPrimaryKey(trolleyNu.getTgid()));
       return trolleyNu;
    }
}
