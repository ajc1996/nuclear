package test;

import nuclear.model.ControlNu;
import nuclear.service.ControlNuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ControlNuServiceImplTest extends BaseTest {
    @Autowired
    private ControlNuService controlNuService;
    @Test
    public void modifyLimits() throws Exception {
    }

    @Test
    public void getLimits() throws Exception {
    }

    @Test
    public void getLimitsByIden() throws Exception {
        int id = 1;
        List<ControlNu> controlNuList = controlNuService.getLimitsByIden(1);
        controlNuList.forEach(controlNu -> System.out.println(controlNu.toString()));
    }
//
//    @Test
//    public void insert() throws Exception {
//        controlNuService.insert();
//    }

}