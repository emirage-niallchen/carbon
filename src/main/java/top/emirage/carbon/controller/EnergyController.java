package top.emirage.carbon.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.emirage.carbon.annotation.PassToken;
import top.emirage.carbon.annotation.UserLoginToken;
import top.emirage.carbon.entity.Energy;
import top.emirage.carbon.utils.MyUtils;
import top.emirage.carbon.service.Impl.EnergyServiceImpl;

import java.util.List;


/**
 * @author ChenBoyun
 * @date 2023-03-24 11:08
 */
@Controller
public class EnergyController {
    @Autowired
    private EnergyServiceImpl energyService;

    @PassToken
    @RequestMapping(path = "/energy/update",method = RequestMethod.POST)
    @ResponseBody
    public String update(String id,String year,String province ,String coal,String oil,String gas,String total){
        int i = Integer.parseInt(id);
        energyService.removeById(Integer.parseInt(id));
        Energy energy = new Energy();
        energy.setYear(Integer.parseInt(year));
        energy.setProvince(province);
        energy.setOil(oil);
        energy.setCoal(coal);
        energy.setGas(gas);
        energy.setTotal(total);
        energy.setId(i);
        energyService.save(energy);
        return  MyUtils.getJSONString(0, "修改成功!");
    }

    @PassToken
    @RequestMapping(path = "/energy/findById")
    @ResponseBody
    public Energy findbyid(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){

        Energy energy = energyService.getById(id);
        return energy;
    }

    @UserLoginToken
    @RequestMapping(path = "/energy/list",method = RequestMethod.GET)
    public String getEnergylist(Model model){
        List<Energy> energylist = energyService.list();
        model.addAttribute("energylist",energylist);
        System.out.println("点击了");
        return "crud/energy_crud";
    }

    @PassToken
    @RequestMapping(path = "/energy/del", method = RequestMethod.POST)
    @ResponseBody
    public String setDelete(@RequestParam(value = "id",required = false,defaultValue = "0")Integer id){
        energyService.removeById(id);

        return MyUtils.getJSONString(0);
    }

    @PassToken
    @RequestMapping(path = "/energy/add",method = RequestMethod.POST)
    @ResponseBody
    public String addEnergy(String year,String province ,String coal,String oil,String gas,String total){
        Energy energy = new Energy();
        energy.setYear(Integer.parseInt(year));
        energy.setProvince(province);
        energy.setOil(oil);
        energy.setCoal(coal);
        energy.setGas(gas);
        energy.setTotal(total);
        energyService.save(energy);
        return  MyUtils.getJSONString(0, "发布成功!");
    }
    @PassToken
    @RequestMapping(path = "/energy/search",method = RequestMethod.GET)
    public String Energysearch(@RequestParam(required = false) @PathVariable("province") String province, Model model){
        model.addAttribute("province",province);
        QueryWrapper<Energy> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("province",province);
        List<Energy> energylist = energyService.list(queryWrapper);
        model.addAttribute("energylist",energylist);
        return "crud/energy_crud";
    }


}
