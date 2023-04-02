package top.emirage.carbon.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.emirage.carbon.annotation.PassToken;
import top.emirage.carbon.annotation.UserLoginToken;
import top.emirage.carbon.utils.MyUtils;
import top.emirage.carbon.entity.Waste;

import top.emirage.carbon.service.Impl.WasteServiceImpl;

import java.util.List;

/**
 * @author ChenBoyun
 * @date 2023-03-24 11:09
 */
@Controller
public class WasteController {


    @Autowired
    private WasteServiceImpl wasteService;


    @PassToken
    @RequestMapping(path = "/waste/update",method = RequestMethod.POST)
    @ResponseBody
    public String update(String id,String year,String province ,
                         String incineration,String landfill,String oxygen){
        wasteService.removeById(Integer.parseInt(id));
        Waste waste = new Waste();
        waste.setYear(Integer.parseInt(year));
        waste.setProvince(province);
        waste.setIncineration(incineration);
        waste.setLandfill(landfill);
        waste.setOxygen(oxygen);
        wasteService.save(waste);
        return  MyUtils.getJSONString(0, "修改成功!");
    }


    @PassToken
    @RequestMapping(path = "/waste/findById",method = RequestMethod.GET)
    @ResponseBody
    public Waste findbyid(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){

        Waste waste = wasteService.getById(id);
        return waste;
    }

    @UserLoginToken
    @RequestMapping(path = "/waste/list",method = RequestMethod.GET)
    public String getwastelist(Model model){
        List<Waste> wastelist = wasteService.list();
        model.addAttribute("wastelist",wastelist);

        return "crud/waste_crud";
    }


    @PassToken
    @RequestMapping(path = "/waste/del", method = RequestMethod.POST)
    @ResponseBody
    public String setDelete(int id){
        wasteService.removeById(id);

        return MyUtils.getJSONString(0);
    }

    @PassToken
    @RequestMapping(path = "/waste/add",method = RequestMethod.POST)
    @ResponseBody
    public String addwaste(String year,String province ,
                           String incineration,String landfill,String oxygen){
        Waste waste = new Waste();
        waste.setYear(Integer.parseInt(year));
        waste.setProvince(province);
        waste.setIncineration(incineration);
        waste.setLandfill(landfill);
        waste.setOxygen(oxygen);
        wasteService.save(waste);
        return  MyUtils.getJSONString(0, "发布成功!");
    }

    @PassToken
    @RequestMapping(path = "/waste/search",method = RequestMethod.GET)
    public String wastesearch(@RequestParam(required = false) @PathVariable("province") String province, Model model){
        model.addAttribute("province",province);
        QueryWrapper<Waste> queryWrapper = new QueryWrapper<>();



        queryWrapper.eq("province",province);


        List<Waste> wastelist = wasteService.list(queryWrapper);
        model.addAttribute("wastelist",wastelist);
        return "crud/waste_crud";
    }

}
