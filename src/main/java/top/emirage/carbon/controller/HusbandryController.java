package top.emirage.carbon.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.emirage.carbon.annotation.PassToken;
import top.emirage.carbon.annotation.UserLoginToken;
import top.emirage.carbon.entity.Husbandry;
import top.emirage.carbon.utils.MyUtils;
import top.emirage.carbon.service.Impl.HusbandryServiceImpl;

import java.util.List;

/**
 * @author ChenBoyun
 * @date 2023-03-24 11:08
 */
@Controller
public class HusbandryController {

    @Autowired
    private HusbandryServiceImpl husbandryService;

    @PassToken
    @RequestMapping(path = "/husbandry/update",method = RequestMethod.POST)
    @ResponseBody
    public String update(String id,String year,String province ,
                         String pig,String cow,String sheep){
        husbandryService.removeById(Integer.parseInt(id));
        Husbandry husbandry = new Husbandry();
        husbandry.setYear(Integer.parseInt(year));
        husbandry.setProvince(province);
        husbandry.setPig(pig);
        husbandry.setCow(cow);
        husbandry.setSheep(sheep);

        husbandryService.save(husbandry);
        return  MyUtils.getJSONString(0, "修改成功!");
    }

    @PassToken
    @RequestMapping(path = "/husbandry/findById")
    @ResponseBody
    public Husbandry findbyid(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){

        Husbandry husbandry = husbandryService.getById(id);
        return husbandry;
    }


    @UserLoginToken
    @RequestMapping(path = "/husbandry/list",method = RequestMethod.GET)
    public String gethusbandrylist(Model model){
        List<Husbandry> husbandrylist = husbandryService.list();
        model.addAttribute("husbandrylist",husbandrylist);
        System.out.println("点击了");
        return "crud/husbandry_crud";
    }

    @PassToken
    @RequestMapping(path = "/husbandry/del", method = RequestMethod.POST)
    @ResponseBody
    public String setDelete(int id){
        husbandryService.removeById(id);

        return MyUtils.getJSONString(0);
    }

    @PassToken
    @RequestMapping(path = "/husbandry/add",method = RequestMethod.POST)
    @ResponseBody
    public String addHusbandry(String year,String province ,
                           String pig,String cow,String sheep){
        Husbandry husbandry = new Husbandry();
        husbandry.setYear(Integer.parseInt(year));
        husbandry.setProvince(province);
        husbandry.setPig(pig);
        husbandry.setCow(cow);
        husbandry.setSheep(sheep);

        husbandryService.save(husbandry);
        return  MyUtils.getJSONString(0, "发布成功!");
    }
    @PassToken
    @RequestMapping(path = "/husbandry/search",method = RequestMethod.GET)
    public String husbandrysearch(@RequestParam(required = false) @PathVariable("province") String province, Model model){
        model.addAttribute("province",province);
        QueryWrapper<Husbandry> queryWrapper = new QueryWrapper<>();



        queryWrapper.eq("province",province);


        List<Husbandry> husbandrylist = husbandryService.list(queryWrapper);
        model.addAttribute("husbandrylist",husbandrylist);
        return "crud/husbandry_crud";
    }
}
