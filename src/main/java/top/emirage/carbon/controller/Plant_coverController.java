package top.emirage.carbon.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.emirage.carbon.annotation.PassToken;
import top.emirage.carbon.annotation.UserLoginToken;
import top.emirage.carbon.utils.MyUtils;
import top.emirage.carbon.entity.Plant_cover;
import top.emirage.carbon.service.Impl.Plant_coverServiceImpl;

import java.util.List;

/**
 * @author ChenBoyun
 * @date 2023-03-24 11:09
 */
@Controller
public class Plant_coverController {



    @Autowired
    private Plant_coverServiceImpl plant_coverService;

    @PassToken
    @RequestMapping(path = "/plant_cover/update",method = RequestMethod.POST)
    @ResponseBody
    public String update(String id,String year,String province ,
                         String forest,String farmland,String greening){
        plant_coverService.removeById(Integer.parseInt(id));
        Plant_cover plant_cover = new Plant_cover();
        plant_cover.setYear(Integer.parseInt(year));
        plant_cover.setProvince(province);

        plant_cover.setForest(forest);
        plant_cover.setFarmland(farmland);
        plant_cover.setGreening(greening);
        plant_coverService.save(plant_cover);
        return  MyUtils.getJSONString(0, "修改成功!");
    }

    @PassToken
    @RequestMapping(path = "/plant_cover/findById")
    @ResponseBody
    public Plant_cover findbyid(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){

        Plant_cover plant_cover = plant_coverService.getById(id);
        return plant_cover;
    }

    @UserLoginToken
    @RequestMapping(path = "/plant_cover/list",method = RequestMethod.GET)
    public String getplant_coverlist(Model model){
        List<Plant_cover> plant_coverlist = plant_coverService.list();
        model.addAttribute("plant_coverlist",plant_coverlist);
        System.out.println("点击了");
        return "crud/plant_cover_crud";
    }

    @PassToken
    @RequestMapping(path = "/plant_cover/del", method = RequestMethod.POST)
    @ResponseBody
    public String setDelete(int id){
        plant_coverService.removeById(id);

        return MyUtils.getJSONString(0);
    }

    @PassToken
    @RequestMapping(path = "/plant_cover/add",method = RequestMethod.POST)
    @ResponseBody
    public String addplant_cover(String year,String province ,
                                 String forest,String farmland,String greening){
        Plant_cover plant_cover = new Plant_cover();
        plant_cover.setYear(Integer.parseInt(year));
        plant_cover.setProvince(province);

        plant_cover.setForest(forest);
        plant_cover.setFarmland(farmland);
        plant_cover.setGreening(greening);
        plant_coverService.save(plant_cover);
        return  MyUtils.getJSONString(0, "发布成功!");
    }

    @PassToken
    @RequestMapping(path = "/plant_cover/search",method = RequestMethod.GET)
    public String plant_coversearch(@RequestParam(required = false) @PathVariable("province") String province, Model model){
        model.addAttribute("province",province);
        QueryWrapper<Plant_cover> queryWrapper = new QueryWrapper<>();



        queryWrapper.eq("province",province);


        List<Plant_cover> plant_coverlist = plant_coverService.list(queryWrapper);
        model.addAttribute("plant_coverlist",plant_coverlist);
        return "crud/plant_cover_crud";
    }


}
