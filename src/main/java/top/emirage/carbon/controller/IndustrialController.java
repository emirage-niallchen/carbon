package top.emirage.carbon.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.emirage.carbon.annotation.PassToken;
import top.emirage.carbon.annotation.UserLoginToken;
import top.emirage.carbon.entity.Industrial;
import top.emirage.carbon.utils.MyUtils;
import top.emirage.carbon.service.Impl.IndustrialServiceImpl;

import java.util.List;

/**
 * @author ChenBoyun
 * @date 2023-03-24 11:09
 */
@Controller
public class IndustrialController {


    @Autowired
    private IndustrialServiceImpl industrialService;

    @PassToken
    @RequestMapping(path = "/industrial/update",method = RequestMethod.POST)
    @ResponseBody
    public String update(String id,String year,String province ,
                         String steel,String cement,String ammonia){
        industrialService.removeById(Integer.parseInt(id));
        Industrial industrial = new Industrial();
        industrial.setYear(Integer.parseInt(year));
        industrial.setProvince(province);
        industrial.setSteel(steel);
        industrial.setCement(cement);
        industrial.setAmmonia(ammonia);
        industrialService.save(industrial);
        return  MyUtils.getJSONString(0, "修改成功!");
    }

    @PassToken
    @RequestMapping(path = "/industrial/findById")
    @ResponseBody
    public Industrial findbyid(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){

        Industrial industrial = industrialService.getById(id);
        return industrial;
    }


    @UserLoginToken
    @RequestMapping(path = "/industrial/list",method = RequestMethod.GET)
    public String getindustriallist(Model model){
        List<Industrial> industriallist = industrialService.list();
        model.addAttribute("industriallist",industriallist);
        System.out.println("点击了");
        return "crud/industrial_crud";
    }

    @PassToken
    @RequestMapping(path = "/industrial/del", method = RequestMethod.POST)
    @ResponseBody
    public String setDelete(int id){
        industrialService.removeById(id);

        return MyUtils.getJSONString(0);
    }

    @PassToken
    @RequestMapping(path = "/industrial/add",method = RequestMethod.POST)
    @ResponseBody
    public String addindustrial(String year,String province ,
                                String steel,String cement,String ammonia){
        Industrial industrial = new Industrial();
        industrial.setYear(Integer.parseInt(year));
        industrial.setProvince(province);
        industrial.setSteel(steel);
        industrial.setCement(cement);
        industrial.setAmmonia(ammonia);
        industrialService.save(industrial);
        return  MyUtils.getJSONString(0, "发布成功!");
    }

    @PassToken
    @RequestMapping(path = "/industrial/search",method = RequestMethod.GET)
    public String industrialsearch(@RequestParam(required = false) @PathVariable("province") String province, Model model){
        model.addAttribute("province",province);
        QueryWrapper<Industrial> queryWrapper = new QueryWrapper<>();



        queryWrapper.eq("province",province);


        List<Industrial> industriallist = industrialService.list(queryWrapper);
        model.addAttribute("industriallist",industriallist);
        return "crud/industrial_crud";
    }

}
