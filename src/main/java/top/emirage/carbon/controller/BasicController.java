package top.emirage.carbon.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.emirage.carbon.annotation.PassToken;
import top.emirage.carbon.annotation.UserLoginToken;
import top.emirage.carbon.entity.Basic;
import top.emirage.carbon.utils.MyUtils;
import top.emirage.carbon.service.Impl.BasicServiceImpl;

import java.util.List;

/**
 * @author ChenBoyun
 * @date 2023-03-24 11:08
 */
@Controller
public class BasicController {

    @Autowired
    private BasicServiceImpl basicService;

    @PassToken
    @RequestMapping(path = "/basic/update",method = RequestMethod.POST)
    @ResponseBody
    public String update(String id,String year,String province ,String economy,String population){
        basicService.removeById(Integer.parseInt(id));
        Basic basic = new Basic();
        basic.setYear(Integer.parseInt(year));
        basic.setProvince(province);
        basic.setEconomy(economy);
        basic.setPopulation(population);
        basicService.save(basic);
        return  MyUtils.getJSONString(0, "修改成功!");
    }

    @PassToken
    @RequestMapping(path = "/basic/findById")
    @ResponseBody
    public Basic findbyid(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){

        Basic basic = basicService.getById(id);
        return basic;
    }


    @UserLoginToken
    @RequestMapping(path = "/basic/list",method = RequestMethod.GET)
    public String getBasiclist(Model model){
        List<Basic> basiclist = basicService.list();
        model.addAttribute("basiclist",basiclist);
        System.out.println("点击了");
        return "crud/basic_crud";
    }

    @PassToken
    @RequestMapping(path = "/basic/del", method = RequestMethod.POST)
    @ResponseBody
    public String setDelete(int id){
        basicService.removeById(id);

        return MyUtils.getJSONString(0);
    }

    @PassToken
    @RequestMapping(path = "/basic/add",method = RequestMethod.POST)
    @ResponseBody
    public String addBasic(String year,String province ,String economy,String population){
        Basic basic = new Basic();
        basic.setYear(Integer.parseInt(year));
        basic.setProvince(province);
        basic.setEconomy(economy);
        basic.setPopulation(population);
        basicService.save(basic);
        return  MyUtils.getJSONString(0, "发布成功!");
    }

    @PassToken
    @RequestMapping(path = "/basic/search",method = RequestMethod.GET)
    public String Basicsearch(@RequestParam(required = false) @PathVariable("province") String province, Model model){
        model.addAttribute("province",province);
        QueryWrapper<Basic> queryWrapper = new QueryWrapper<>();



        queryWrapper.eq("province",province);


        List<Basic> basiclist = basicService.list(queryWrapper);
        model.addAttribute("basiclist",basiclist);
        return "crud/basic_crud";
    }
}
