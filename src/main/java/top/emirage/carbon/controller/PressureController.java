package top.emirage.carbon.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.emirage.carbon.utils.Decoupling;
import top.emirage.carbon.utils.GetData;
import top.emirage.carbon.utils.Lmdi;
import top.emirage.carbon.utils.Tapio;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenBoyun
 * @date 2023-03-30 16:34
 */
@Controller
public class PressureController {

    @Autowired
    private GetData getData;

    @RequestMapping(path = "/pressure/lmdi/hebei")
    @ResponseBody
    public List<Lmdires> lmid_hebei(){
        List<Lmdires> res = new ArrayList<>();
        Lmdi lmdi = new Lmdi();
        double[] cs = new double[11];
        double[] p = new double[11];
        double[] e = new double[11];
        double[] gdp = new double[11];
        for(int i = 2010;i<2021;i++){
            cs[i - 2010] = getData.gettotalemmission(i +"","河北");
            p[i - 2010] = getData.getpopulation(i +"","河北");
            e[i - 2010] = getData.getenergy(i +"","河北");
            gdp[i - 2010] = getData.getgdp(i +"","河北");
        }
        lmdi.init(cs,p,e,gdp);
        double[] res_c = lmdi.getR_c();
        double[] res_e = lmdi.getR_e();
        double[] res_g = lmdi.getR_g();
        double[] res_p = lmdi.getR_p();
        double[] res_sum = lmdi.getSum();
        for(int i = 0;i<lmdi.getLen()-1;i++){
            Lmdires a = new Lmdires();
            a.setYear(i+2011);
            a.setC(res_c[i]);
            a.setE(res_e[i]);
            a.setG(res_g[i]);
            a.setP(res_p[i]);
            a.setSum(res_sum[i]);
            res.add(a);
        }


        return res;
    }
    @RequestMapping(path = "/pressure/lmdi/tianjin")
    @ResponseBody
    public List<Lmdires> lmid_tianjin(){
        List<Lmdires> res = new ArrayList<>();
        Lmdi lmdi = new Lmdi();
        double[] cs = new double[11];
        double[] p = new double[11];
        double[] e = new double[11];
        double[] gdp = new double[11];
        for(int i = 2010;i<2021;i++){
            cs[i - 2010] = getData.gettotalemmission(i +"","天津");
            p[i - 2010] = getData.getpopulation(i +"","天津");
            e[i - 2010] = getData.getenergy(i +"","天津");
            gdp[i - 2010] = getData.getgdp(i +"","天津");
        }
        lmdi.init(cs,p,e,gdp);
        double[] res_c = lmdi.getR_c();
        double[] res_e = lmdi.getR_e();
        double[] res_g = lmdi.getR_g();
        double[] res_p = lmdi.getR_p();
        double[] res_sum = lmdi.getSum();
        for(int i = 0;i<lmdi.getLen()-1;i++){
            Lmdires a = new Lmdires();
            a.setYear(i+2011);
            a.setC(res_c[i]);
            a.setE(res_e[i]);
            a.setG(res_g[i]);
            a.setP(res_p[i]);
            a.setSum(res_sum[i]);
            res.add(a);
        }


        return res;
    }

    /**
    *  @param
     * @return Lmdi
     * @author 陈博云
     * @date 2023/3/30 18:09
     * 输入四个数组，初始化一个对象，获得他的四个影响因素的数组,放入链表返回
     *     *  @param e_cs   碳排放总量数组
     *      * @param e_p    人口数数组
     *      * @param e_e    能源消费总量（折合成基准碳）数组
     *      * @param e_gdp  经济总量数组
     */
    @RequestMapping(path = "/pressure/lmdi/beijing")
    @ResponseBody
    public List<Lmdires> lmid_beijing(){
        List<Lmdires> res = new ArrayList<>();
        Lmdi lmdi = new Lmdi();
        double[] cs = new double[11];
        double[] p = new double[11];
        double[] e = new double[11];
        double[] gdp = new double[11];
        for(int i = 2010;i<2021;i++){
            cs[i - 2010] = getData.gettotalemmission(i +"","北京");
            p[i - 2010] = getData.getpopulation(i +"","北京");
            e[i - 2010] = getData.getenergy(i +"","北京");
            gdp[i - 2010] = getData.getgdp(i +"","北京");
        }
        lmdi.init(cs,p,e,gdp);
        double[] res_c = lmdi.getR_c();
        double[] res_e = lmdi.getR_e();
        double[] res_g = lmdi.getR_g();
        double[] res_p = lmdi.getR_p();
        double[] res_sum = lmdi.getSum();
        for(int i = 0;i<lmdi.getLen()-1;i++){
            Lmdires a = new Lmdires();
            a.setYear(i+2011);
            a.setC(res_c[i]);
            a.setE(res_e[i]);
            a.setG(res_g[i]);
            a.setP(res_p[i]);
            a.setSum(res_sum[i]);
            res.add(a);
        }


        return res;
    }

    /**
     *  c  e  g   p  是四个影响因素  能源结构   能源消费强度  经济发展  人口规模
     * @return null
     * @author 陈博云
     * @date 2023/3/30 18:07
     */
    @Data
    private class Lmdires{
        private int year;
        private double c;
        private double e;
        private double g;
        private double p;
        private double sum;
    }



    /**
    * * @param
     * @return String
     * @author 陈博云
     * @date 2023/3/30 17:08
     * 先获得GDP数组和碳排放数组，传进去，获得一个省份的脱钩对象
     * 获得三个省份的脱钩对象
     */



    @RequestMapping(path = "/carbonpressure",method = RequestMethod.GET)
    public String foot(Model model){
        double[] gdp_beijing = new double[11];
        double[] cs_beijing = new double[11];
        for(int i = 2010;i<2021;i++){
            gdp_beijing[i-2010] = getData.getgdp(i+"","北京");
            cs_beijing[i-2010] = getData.gettotalemmission(i+"","北京");
        }
        List<Decoupling> beijing;
        beijing = Tapio.helper(gdp_beijing,cs_beijing);
        model.addAttribute("beijing",beijing);

        double[] gdp_tianjin = new double[11];
        double[] cs_tianjin = new double[11];
        for(int i = 2010;i<2021;i++){
            gdp_tianjin[i-2010] = getData.getgdp(i+"","天津");
            cs_tianjin[i-2010] = getData.gettotalemmission(i+"","天津");
        }
        List<Decoupling> tianjin ;
        tianjin = Tapio.helper(gdp_tianjin,cs_tianjin);
        model.addAttribute("tianjin",tianjin);


        double[] gdp_hebei = new double[11];
        double[] cs_hebei = new double[11];
        for(int i = 2010;i<2021;i++){
            gdp_hebei[i-2010] = getData.getgdp(i+"","河北");
            cs_hebei[i-2010] = getData.gettotalemmission(i+"","河北");
        }
        List<Decoupling> hebei ;
        hebei = Tapio.helper(gdp_hebei,cs_hebei);
        model.addAttribute("hebei",hebei);
        return "show/pressure";
    }


    @RequestMapping(path = "pressure/cs/gdp",method = RequestMethod.POST)
    @ResponseBody
    public List<restotal> pressurecsgdp(){
        List<restotal> list = new ArrayList<>();

        for(int i = 2010;i<2021;i++){
            restotal restotal = new restotal();
            restotal.setYear(i);
            restotal.setBeijing(getData.get_CS_GDP(i + "","北京"));
            restotal.setTianjin(getData.get_CS_GDP(i + "","天津"));
            restotal.setHebei(getData.get_CS_GDP(i + "","河北"));
            list.add(restotal);
        }

        return list;
    }



    @RequestMapping(path = "pressure/cs/population",method = RequestMethod.POST)
    @ResponseBody
    public List<restotal> pressurecspopulation(){
        List<restotal> list = new ArrayList<>();

        for(int i = 2010;i<2021;i++){
            restotal restotal = new restotal();
            restotal.setYear(i);
            restotal.setBeijing(getData.get_CS_population(i + "","北京"));
            restotal.setTianjin(getData.get_CS_population(i + "","天津"));
            restotal.setHebei(getData.get_CS_population(i + "","河北"));
            list.add(restotal);
        }

        return list;
    }


    @Data
    private class restotal{
        private int year;
        private double beijing;
        private double tianjin;
        private double hebei;
    }

}
