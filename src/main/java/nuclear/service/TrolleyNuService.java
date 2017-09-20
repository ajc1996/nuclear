package nuclear.service;

import nuclear.model.GoodsNu;
import nuclear.model.TrolleyNu;
import nuclear.model.UserNu;

import java.util.List;

public interface TrolleyNuService {
    List<TrolleyNu> allGoods(UserNu userNu);
    float byAll(UserNu userNu);
    boolean deleteOne(UserNu userNu,GoodsNu goodsNu);
    boolean deleteAll(UserNu userNu);
    boolean addOne(UserNu userNu);
    boolean addMultiple();
}
