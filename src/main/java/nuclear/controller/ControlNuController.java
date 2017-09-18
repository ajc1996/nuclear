package nuclear.controller;

import nuclear.service.ControlNuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 权限控制controller
 */
@Controller
@RequestMapping("/priv")
public class ControlNuController {
    @Autowired
    private ControlNuService controlNuService;

    /**
     * 修改权限
     * @param luid
     * @param lsid
     * @return
     */
    @RequestMapping("/mod")
    public String modifyPriv(int luid, Integer[] lsid) {
        controlNuService.modifyLimits(luid,lsid);

        return "priv/priv";
    }

    /**
     * 获取权限
     * @param luid
     * @return
     */
    @RequestMapping("/getPrivsByIden")
    @ResponseBody
    public List<Integer> getPrivsByIden(int luid) {
        List<Integer> pIdList = controlNuService.getLimits(luid);
        return pIdList;
    }
}
