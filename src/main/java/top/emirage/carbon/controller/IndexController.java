package top.emirage.carbon.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.emirage.carbon.utils.GetData;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ChenBoyun
 * @date 2023-03-29 14:08
 */
@Controller
@CrossOrigin
public class IndexController {
    /**
    * * @param null
     * @return null
     * @author 陈博云
     * @date 2023/3/29 14:09
     * 需要四个data 数组表示年份、京津冀各自的碳排放总量。
     * 分别命名，放到Map里面  然后返回一个list
     */

    @Autowired
    private  GetData getData;

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String index(){
        return "show/index";
    }

    @RequestMapping(path = "/money",method = RequestMethod.GET)
    public String money(){
        return "show/money";
    }


    @RequestMapping(path = "index/1",method = RequestMethod.POST)
    @ResponseBody
    public List<restotal> indextotal(String id){
        List<restotal> list = new ArrayList<>();

        for(int i = 2010;i<2021;i++){
            restotal restotal = new restotal();
            restotal.setYear(i);
            restotal.setBeijing(getData.gettotalemmission(i + "","北京"));
            restotal.setTianjin(getData.gettotalemmission(i + "","天津"));
            restotal.setHebei(getData.gettotalemmission(i + "","河北"));
            list.add(restotal);
        }

        return list;
    }

    @RequestMapping(path = "index/composition/beijing",method = RequestMethod.POST)
    @ResponseBody
    public List<Com> indexbeijingcom(String id){
        List<Com> list = new ArrayList<>();
        for(int i = 2010;i<2021;i++){
            Com com = new Com();
            com.setYear(i);
            com.setAgriculture(getData.getagricultureemmission(i  + "","北京"));
            com.setEnergy(getData.getenergyemmission(i  + "","北京"));
            com.setHum(getData.gethumemmission(i  + "","北京"));
            com.setHusbandry(getData.gethusbandryemmission(i  + "","北京"));
            com.setIndustrial(getData.getindustrialemmission(i  + "","北京"));
            com.setWaste(getData.getwasteemmission(i  + "","北京"));
            list.add(com);
        }
        return list;
    }


    @RequestMapping(path = "index/composition/tianjin",method = RequestMethod.POST)
    @ResponseBody
    public List<Com> indextianjincom(String id){
        List<Com> list = new ArrayList<>();
        for(int i = 2010;i<2021;i++){
            Com com = new Com();
            com.setYear(i);
            com.setAgriculture(getData.getagricultureemmission(i  + "","天津"));
            com.setEnergy(getData.getenergyemmission(i  + "","天津"));
            com.setHum(getData.gethumemmission(i  + "","天津"));
            com.setHusbandry(getData.gethusbandryemmission(i  + "","天津"));
            com.setIndustrial(getData.getindustrialemmission(i  + "","天津"));
            com.setWaste(getData.getwasteemmission(i  + "","天津"));
            list.add(com);
        }
        return list;
    }



    @RequestMapping(path = "index/composition/hebei",method = RequestMethod.POST)
    @ResponseBody
    public List<Com> indexhebeicom(String id){
        List<Com> list = new ArrayList<>();
        for(int i = 2010;i<2021;i++){
            Com com = new Com();
            com.setYear(i);
            com.setAgriculture(getData.getagricultureemmission(i  + "","河北"));
            com.setEnergy(getData.getenergyemmission(i  + "","河北"));
            com.setHum(getData.gethumemmission(i  + "","河北"));
            com.setHusbandry(getData.gethusbandryemmission(i  + "","河北"));
            com.setIndustrial(getData.getindustrialemmission(i  + "","河北"));
            com.setWaste(getData.getwasteemmission(i  + "","河北"));
            list.add(com);
        }
        return list;
    }

    @Data
    private class Com{
        private int year;
        private double hum;
        private double agriculture;
        private double energy;
        private double husbandry;
        private double industrial;
        private double waste;
    }


    @Data
    private class restotal{
        private int year;
        private double beijing;
        private double tianjin;
        private double hebei;
    }
}
