package top.emirage.carbon.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.emirage.carbon.annotation.PassToken;
import top.emirage.carbon.annotation.UserLoginToken;
import top.emirage.carbon.entity.Agriculture;
import top.emirage.carbon.utils.MyUtils;
import top.emirage.carbon.service.Impl.AgricultureServiceImpl;

import java.util.List;

/**
 * @author ChenBoyun
 * @date 2023-03-24 11:08
 */
@Controller
public class AgricultureController {







    @Autowired
    private AgricultureServiceImpl agricultureService;

    @PassToken
//    @PreAuthorize("hasAuthority('admin')")
    @RequestMapping(path = "/agriculture/update",method = RequestMethod.POST)
    @ResponseBody
    public String update(String id,String year,String province ,String irrigation,String machinery,String fertilizer,String area){
        String i = id;
        agricultureService.removeById(Integer.parseInt(i));
        Agriculture agriculture = new Agriculture();
        agriculture.setYear(Integer.parseInt(year));
        agriculture.setProvince(province);
        agriculture.setArea(area);
        agriculture.setIrrigation(irrigation);
        agriculture.setMachinery(machinery);
        agriculture.setFertilizer(fertilizer);

        agricultureService.save(agriculture);
        return  MyUtils.getJSONString(0, "修改成功!");
    }

    @PassToken
    @RequestMapping(path = "/agriculture/findById")
    @ResponseBody
    public Agriculture findbyid(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){

        Agriculture agriculture = agricultureService.getById(id);
        return agriculture;
    }

    @UserLoginToken
    @RequestMapping(path = "/agriculture/list",method = RequestMethod.GET)
    public String getAgriculturelist(Model model){
        List<Agriculture> agriculturelist = agricultureService.list();
        model.addAttribute("agriculturelist",agriculturelist);
        return "crud/agriculture_crud";
    }

    @PassToken
    @RequestMapping(path = "/agriculture/del", method = RequestMethod.POST)
    @ResponseBody
    public String setDelete(int id){
        agricultureService.removeById(id);

        return MyUtils.getJSONString(0);
    }

    @PassToken
    @RequestMapping(path = "/agriculture/add",method = RequestMethod.POST)
    @ResponseBody
    public String addAgriculture(String year,String province ,String irrigation,String machinery,String fertilizer,String area){
        Agriculture agriculture = new Agriculture();

        agriculture.setYear(Integer.parseInt(year));
        agriculture.setProvince(province);
        agriculture.setArea(area);
        agriculture.setIrrigation(irrigation);
        agriculture.setMachinery(machinery);
        agriculture.setFertilizer(fertilizer);
        agricultureService.save(agriculture);
        return  MyUtils.getJSONString(0, "发布成功!");
    }
    @PassToken
    @RequestMapping(path = "/agriculture/search",method = RequestMethod.GET)
    public String Agriculturesearch(@RequestParam(required = false) @PathVariable("province") String province, Model model){
        model.addAttribute("province",province);
        QueryWrapper<Agriculture> queryWrapper = new QueryWrapper<>();



        queryWrapper.eq("province",province);


        List<Agriculture> agriculturelist = agricultureService.list(queryWrapper);
        model.addAttribute("agriculturelist",agriculturelist);
        return "crud/agriculture_crud";
    }



}
