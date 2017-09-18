package nuclear.service.impl;

import nuclear.dao.ControlNuMapper;
import nuclear.dao.LimitsNuMapper;
import nuclear.model.ControlNu;
import nuclear.model.LimitsNu;
import nuclear.model.LimitsNuExample;
import nuclear.service.ControlNuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class ControlNuServiceImpl implements ControlNuService {
    @Autowired
    private ControlNuMapper controlNuMapper;
    @Autowired
    private LimitsNuMapper limitsNuMapper;
    @Autowired
    private LimitsNuExample limitsNuExample;
    @Autowired
    private LimitsNu limitsNu;
    @Override
    public void modifyLimits(int luid, Integer[] lsid) {
        limitsNuExample.clear();
        limitsNuExample.createCriteria().andLuidEqualTo(luid);
        limitsNuMapper.deleteByExample(limitsNuExample);
        for (Integer lsids: lsid
             ) {
            limitsNu.setLid(UUID.randomUUID().toString());
            limitsNu.setLuid(luid);
            limitsNu.setLsid(lsids);
            limitsNuMapper.insert(limitsNu);
        }

    }

    @Override
    public List<Integer> getLimits(int luid) {
        limitsNuExample.clear();
        limitsNuExample.createCriteria().andLuidEqualTo(luid);
        List<LimitsNu> limitsNuList = limitsNuMapper.selectByExample(limitsNuExample);
        List<Integer> lsidList = new ArrayList<Integer>();
        for (LimitsNu limitsNutemp:limitsNuList
             ) {
            lsidList.add(limitsNutemp.getLsid());
        }

        return lsidList;
    }

    @Override
    public List<ControlNu> getLimitsByIden(int luid) {
        limitsNuExample.clear();
        limitsNuExample.createCriteria().andLuidEqualTo(luid);
        List<LimitsNu> limitsNuList = limitsNuMapper.selectByExample(limitsNuExample);
        List<ControlNu> controlNusList = new ArrayList<>();
        for (LimitsNu limitsNutemp:limitsNuList
             ) {
            controlNusList.add(controlNuMapper.selectByPrimaryKey(limitsNutemp.getLsid()));
        }
        return  controlNusList;
    }
}
