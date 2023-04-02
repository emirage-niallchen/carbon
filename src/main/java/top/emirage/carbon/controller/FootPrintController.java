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
 * @date 2023-03-30 07:54
 */
@Controller
@CrossOrigin
public class FootPrintController {




    @Autowired
    private  GetData getData;

    @RequestMapping(path = "/foot",method = RequestMethod.GET)
    public String foot(){
        return "show/footprint";
    }



    @RequestMapping(path = "footprint/cf")
    @ResponseBody
    public List<Cp> footprintcf(){
        List<Cp> list = new ArrayList<>();
        for(int i = 2010;i<2021;i++){
            Cp cp = new Cp();
            cp.setYear(i);
            cp.setBeijing(getData.get_CF(i  + "","北京"));
            cp.setTianjin(getData.get_CF(i  + "","天津"));
            cp.setHebei(getData.get_CF(i  + "","河北"));
            list.add(cp);
        }

        return list;
    }

    @RequestMapping(path = "footprint/cc")
    @ResponseBody
    public List<Cp> footprintcc(){
        List<Cp> list = new ArrayList<>();
        for(int i = 2010;i<2021;i++){
            Cp cp = new Cp();
            cp.setYear(i);
            cp.setBeijing(getData.get_CC(i  + "","北京"));
            cp.setTianjin(getData.get_CC(i  + "","天津"));
            cp.setHebei(getData.get_CC(i  + "","河北"));
            list.add(cp);
        }

        return list;
    }

    //生态承载力
    @RequestMapping(path = "footprint/cp",method = RequestMethod.POST)
    @ResponseBody
    public List<Cp> footprintcp(String id){
        List<Cp> list = new ArrayList<>();

        for(int i = 2010;i<2021;i++){
            Cp cp = new Cp();
            cp.setYear(i);
            cp.setBeijing(getData.get_CP(i  + "","北京"));
            cp.setTianjin(getData.get_CP(i  + "","天津"));
            cp.setHebei(getData.get_CP(i  + "","河北"));
            list.add(cp);
        }

        return list;
    }


    @Data
    private class Cp{
        private int year;
        private double beijing;
        private double tianjin;
        private double hebei;
    }
}
