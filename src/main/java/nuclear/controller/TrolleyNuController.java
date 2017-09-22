package nuclear.controller;

import nuclear.model.TotalCount;
import nuclear.model.TrolleyModel;
import nuclear.model.TrolleyNu;
import nuclear.service.TrolleyNuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/trolley")
public class TrolleyNuController {
    @Autowired
    private TotalCount totalCount;
    @Autowired
    private TrolleyNuService trolleyNuService;
    @RequestMapping("/totrolley")
    public @ResponseBody List<TrolleyNu> toTrolleyNu(HttpSession session){
        int id = (int)session.getAttribute("id");
        List<TrolleyNu> trolleyNuList = trolleyNuService.allGoods(id);
        return trolleyNuList;
    }
    @RequestMapping("/removeTrolleyNu")
    public @ResponseBody String removeTrolleyNu(@RequestBody TrolleyNu trolleyNu){
        trolleyNuService.remove(trolleyNu);
        return "删除成功";
    }

    @RequestMapping("/buyTrolleyNu")
    public @ResponseBody String buyTrolleyNu(@RequestBody TrolleyNu trolleyNu){
        trolleyNuService.buy(trolleyNu);
        return "购买成功";
    }

    @RequestMapping("/delAll")
    public @ResponseBody String delAll(@RequestBody TrolleyModel trolleyModel){
        int[] ids =trolleyModel.getIds();
        for (Integer id:ids
             ) {
            trolleyNuService.remove(id);
        }
        return "删除成功";
    }

    @RequestMapping("/getcount")
    public @ResponseBody TotalCount getcount(@RequestBody TrolleyModel trolleyModel){
        int[] ids =trolleyModel.getIds();
        double total = 0;
        for (Integer id:ids
                ) {
            total = total+trolleyNuService.findById(id).getTcount()*trolleyNuService.findById(id).getGprice();
        }
        totalCount.setTotal(total);
        return totalCount;
    }
}
