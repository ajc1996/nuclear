package nuclear.service;

import nuclear.model.GoodsNu;
import nuclear.model.TrolleyNu;
import nuclear.model.UserNu;

import java.util.List;

public interface TrolleyNuService {
    List<TrolleyNu> allGoods(UserNu userNu);
    float buy(UserNu userNu,TrolleyNu trolleyNu);
    boolean update(UserNu userNu,TrolleyNu trolleyNu);
    boolean remove(TrolleyNu trolleyNu);
    boolean add(TrolleyNu trolleyNu);
}
