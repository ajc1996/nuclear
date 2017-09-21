package nuclear.service;

import nuclear.model.GoodsNu;
import nuclear.model.TrolleyNu;
import nuclear.model.UserNu;

import java.util.List;

public interface TrolleyNuService {
    List<TrolleyNu> allGoods(int id);
    float buy(TrolleyNu trolleyNu);
    boolean update(UserNu userNu,TrolleyNu trolleyNu);
    boolean remove(TrolleyNu trolleyNu);
    boolean add(TrolleyNu trolleyNu);
}
