package nuclear.service;

import nuclear.model.ControlNu;

import java.util.List;

public interface ControlNuService {
    void modifyLimits(int luid, Integer[] lsid);

    List<Integer> getLimits(int luid);

    List<ControlNu> getLimitsByIden(int luid);
}
