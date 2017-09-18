package nuclear.controller;

import nuclear.util.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class GoodsNuController {

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

}
