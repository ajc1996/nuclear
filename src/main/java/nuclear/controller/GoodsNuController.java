package nuclear.controller;

import nuclear.model.DeleteModel;
import nuclear.model.GoodsNu;
import nuclear.model.TrolleyNu;
import nuclear.service.GoodsNuService;
import nuclear.util.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsNuController {

    @Resource
    GoodsNuService goodsNuService;

    /**
     * 将裁剪的base64图片放到相应的地址
     * @param img
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateUserMess")
    @ResponseBody
    public String updatePhotoUrl(String img, HttpServletRequest request) throws Exception{
        //输出base64 数据,截取","之后的值进行转换
        //获取相对路径
        String path = "/imgs/";
        String realPath = request.getSession().getServletContext().getRealPath(path);
        //查看文件夹是否存在，不存在创建新的文件夹
        File file = new File(realPath);
        if (!file.exists()) {//文件夹不存在 创建文件夹
            file.mkdirs();
        }
        String str = img.substring(img.indexOf(",")+1);
        //System.currentTimeMillis()意思是获取当前系统的时间戳给图片命名
        //实例化Base64转换类  调用里面的GenerateImage方法（把base64数据转为图片）
        //第一个参数base64转图片的必须的base64数据，第二个是转换后生成的图片存放路径
        String imgname = System.currentTimeMillis()+".jpg";
        System.out.println(imgname);
        Base64.GenerateImage(str, realPath+imgname);
        String pathUrl = "imgs/"+imgname;
        return pathUrl;
    }

    /**
     * 添加商品信息
     * @param goodsNu
     * @return
     */
    @RequestMapping("/goodsadd")
    @ResponseBody
    public String goodsadd(GoodsNu goodsNu){
        goodsNu.setGbirthday(new Date());
        System.out.println("2");
        System.out.println(goodsNu.getGpic());
        System.out.println("1");
        goodsNuService.goodsadd(goodsNu);
        return "success";
    }

    /**
     * 判断商品名是否重复
     * @param goodsNu
     * @return
     */
    @RequestMapping("/judgegoods")
    @ResponseBody
    public Map judgegoods(GoodsNu goodsNu){
        Map<String ,Boolean> map = new HashMap<>();
        Boolean judge = goodsNuService.judgegoods(goodsNu);
        map.put("valid",judge);
        return map;
    }

    /**
     * 查询所有数据
     * @return
     */
    @RequestMapping("/goodsquery")
    @ResponseBody
    public Object goodsquery(){
        List<GoodsNu> goodsNus = goodsNuService.goodsquery();
        return goodsNus;
    }

    /**
     * server分页
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @RequestMapping("selectByFy")
    @ResponseBody
    public  Map<String,Object> selectByFy(int pageSize,int pageNumber,String gname){
        /*所需参数*/
        System.out.println("1");
        System.out.println("11111111111"+gname);
        System.out.println(gname.toString());
        System.out.println("2");
        int offset=(pageNumber-1)*pageSize;
        int limits=pageSize;
        return goodsNuService.selectByFy(offset,limits,gname);
    }

    /**
     * 根据名字删除
     * @param deleteModel
     */
    @RequestMapping("/goodsdelete")
    public void goodsdelete(@RequestBody DeleteModel deleteModel){
        //   String []data =request.getParameterValues("names");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        String[] username = deleteModel.getNames();
        for (String name:username
                ) {
            System.out.println(name);
            goodsNuService.deletebyname(name);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    /**
     * 主界面分页
     * @return
     */
    @RequestMapping("selectByHome")
    @ResponseBody
    public List<GoodsNu> selectByHome(GoodsNu goodsNu){
        System.out.println("进入");
        /*所需参数*/
        return goodsNuService.selectByHome(goodsNu);
    }

    /**
     * 根据名字查询
     * @param gname
     * @return
     */
    @RequestMapping("selectByGname")
    @ResponseBody
    public List<GoodsNu> selectByGname(String gname,HttpServletResponse response){
        System.out.println(gname);
        System.out.println("查询");
        return goodsNuService.selectByGname(gname);
    }

    /**
     * 通过图片地址查询
     * @param gpic
     * @param response
     * @return
     */
    @RequestMapping("selectByGpic")
    @ResponseBody
    public List<GoodsNu> selectByGpic(String gpic,HttpServletResponse response){
        System.out.println(gpic);
        return goodsNuService.selectByGpic(gpic);
    }

    /**
     * 将购物信息插入数据库
     * @param trolleyNu
     * @return
     */
    @RequestMapping("addTrolley")
    @ResponseBody
    public String addTrolley(TrolleyNu trolleyNu){
        trolleyNu.setTcount(1);
        return goodsNuService.addTrolley(trolleyNu);
    }

}
