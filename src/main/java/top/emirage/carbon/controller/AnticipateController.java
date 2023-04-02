package top.emirage.carbon.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.emirage.carbon.utils.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenBoyun
 * @date 2023-03-30 17:36
 */
@Controller
public class AnticipateController implements MyConstant {
    @Autowired
    private GetData getData;


    @RequestMapping(path = "/anticipate",method = RequestMethod.GET)
    public String anticipaaaaaaa(){
        return "show/anticipate";
    }

    @RequestMapping(path = "/anticipate/low")
    @ResponseBody
    public List<restotal> anticipatelow(){
        List<restotal> list = new ArrayList<>();


        //获得北京数据
        double[] cs_beijing = new double[11];
        double[] p_beijing = new double[11];
        double[] e_beijing = new double[11];
        double[] gdp_beijing = new double[11];
        double[] coal_beijing = new double[11];
        for(int i = 2010;i<2021;i++){
            cs_beijing[i - 2010] = getData.gettotalemmission(i +"","北京");
            p_beijing[i - 2010] = getData.getpopulation(i +"","北京");
            e_beijing[i - 2010] = getData.getenergy(i +"","北京");
            gdp_beijing[i - 2010] = getData.getgdp(i +"","北京");
            coal_beijing[i-2010] = getData.getcoal(i+"","北京");
        }
        //获得天津数据
        double[] cs_tianjin = new double[11];
        double[] p_tianjin = new double[11];
        double[] e_tianjin = new double[11];
        double[] gdp_tianjin = new double[11];
        double[] coal_tianjin = new double[11];
        for(int i = 2010;i<2021;i++){
            cs_tianjin[i - 2010] = getData.gettotalemmission(i +"","天津");
            p_tianjin[i - 2010] = getData.getpopulation(i +"","天津");
            e_tianjin[i - 2010] = getData.getenergy(i +"","天津");
            gdp_tianjin[i - 2010] = getData.getgdp(i +"","天津");
            coal_tianjin[i-2010] = getData.getcoal(i+"","天津");
        }
        //获得河北数据
        double[] cs_hebei = new double[11];
        double[] p_hebei = new double[11];
        double[] e_hebei = new double[11];
        double[] gdp_hebei = new double[11];
        double[] coal_hebei = new double[11];
        for(int i = 2010;i<2021;i++){
            cs_hebei[i - 2010] = getData.gettotalemmission(i +"","河北");
            p_hebei[i - 2010] = getData.getpopulation(i +"","河北");
            e_hebei[i - 2010] = getData.getenergy(i +"","河北");
            gdp_hebei[i - 2010] = getData.getgdp(i +"","河北");
            coal_hebei[i-2010] = getData.getcoal(i+"","河北");
        }
        //计算北京
        double[] re_beijing = Anticipate2.helper(cs_beijing,p_beijing,e_beijing,gdp_beijing,coal_beijing,
                MyConstant.LOW_GDP_BEIJING,MyConstant.LOW_P_BEIJING,MyConstant.LOW_E_BEIJING,
                MyConstant.LOW_CARBON_BEIJING,3);
        //计算天津
        double[] re_tianjin = Anticipate2.helper(cs_tianjin,p_tianjin,e_tianjin,gdp_tianjin,coal_tianjin,
                MyConstant.LOW_GDP_TIANJIN,MyConstant.LOW_P_TIANJIN,MyConstant.LOW_E_TIANJIN,
                MyConstant.LOW_CARBON_TIANJIN,3);
        //计算河北
        double[] re_hebei = Anticipate2.helper(cs_hebei,p_hebei,e_hebei,gdp_hebei,coal_hebei,
                MyConstant.LOW_GDP_HEBEI,MyConstant.LOW_P_HEBEI,MyConstant.LOW_E_HEBEI,
                MyConstant.LOW_CARBON_HEBEI,3);

        for (int i = 0;i<re_beijing.length;i++){
            restotal restotal = new restotal();
            restotal.setYear(i+2021);
            restotal.setBeijing(re_beijing[i]);
            restotal.setTianjin(re_tianjin[i]);
            restotal.setHebei(re_hebei[i]);
            restotal.setSum(re_beijing[i]+re_tianjin[i]+re_hebei[i]);
            list.add(restotal);
        }

        return list;
    }

    @RequestMapping(path = "/anticipate/high")
    @ResponseBody
    public List<restotal> anticipatehigh(){
        List<restotal> list = new ArrayList<>();


        //获得北京数据
        double[] cs_beijing = new double[11];
        double[] p_beijing = new double[11];
        double[] e_beijing = new double[11];
        double[] gdp_beijing = new double[11];
        double[] coal_beijing = new double[11];
        for(int i = 2010;i<2021;i++){
            cs_beijing[i - 2010] = getData.gettotalemmission(i +"","北京");
            p_beijing[i - 2010] = getData.getpopulation(i +"","北京");
            e_beijing[i - 2010] = getData.getenergy(i +"","北京");
            gdp_beijing[i - 2010] = getData.getgdp(i +"","北京");
            coal_beijing[i-2010] = getData.getcoal(i+"","北京");
        }
        //获得天津数据
        double[] cs_tianjin = new double[11];
        double[] p_tianjin = new double[11];
        double[] e_tianjin = new double[11];
        double[] gdp_tianjin = new double[11];
        double[] coal_tianjin = new double[11];
        for(int i = 2010;i<2021;i++){
            cs_tianjin[i - 2010] = getData.gettotalemmission(i +"","天津");
            p_tianjin[i - 2010] = getData.getpopulation(i +"","天津");
            e_tianjin[i - 2010] = getData.getenergy(i +"","天津");
            gdp_tianjin[i - 2010] = getData.getgdp(i +"","天津");
            coal_tianjin[i-2010] = getData.getcoal(i+"","天津");
        }
        //获得河北数据
        double[] cs_hebei = new double[11];
        double[] p_hebei = new double[11];
        double[] e_hebei = new double[11];
        double[] gdp_hebei = new double[11];
        double[] coal_hebei = new double[11];
        for(int i = 2010;i<2021;i++){
            cs_hebei[i - 2010] = getData.gettotalemmission(i +"","河北");
            p_hebei[i - 2010] = getData.getpopulation(i +"","河北");
            e_hebei[i - 2010] = getData.getenergy(i +"","河北");
            gdp_hebei[i - 2010] = getData.getgdp(i +"","河北");
            coal_hebei[i-2010] = getData.getcoal(i+"","河北");
        }
        //计算北京
        double[] re_beijing = Anticipate2.helper(cs_beijing,p_beijing,e_beijing,gdp_beijing,coal_beijing,
                MyConstant.HIGH_GDP_BEIJING,MyConstant.HIGH_P_BEIJING,MyConstant.HIGH_E_BEIJING,
                MyConstant.HIGH_CARBON_BEIJING,3);
        //计算天津
        double[] re_tianjin = Anticipate2.helper(cs_tianjin,p_tianjin,e_tianjin,gdp_tianjin,coal_tianjin,
                MyConstant.HIGH_GDP_TIANJIN,MyConstant.HIGH_P_TIANJIN,MyConstant.HIGH_E_TIANJIN,
                MyConstant.HIGH_CARBON_TIANJIN,3);
        //计算河北
        double[] re_hebei = Anticipate2.helper(cs_hebei,p_hebei,e_hebei,gdp_hebei,coal_hebei,
                MyConstant.HIGH_GDP_HEBEI,MyConstant.HIGH_P_HEBEI,MyConstant.HIGH_E_HEBEI,
                MyConstant.HIGH_CARBON_HEBEI,3);

        for (int i = 0;i<re_beijing.length;i++){
            restotal restotal = new restotal();
            restotal.setYear(i+2021);
            restotal.setBeijing(re_beijing[i]);
            restotal.setTianjin(re_tianjin[i]);
            restotal.setHebei(re_hebei[i]);
            restotal.setSum(re_beijing[i]+re_tianjin[i]+re_hebei[i]);
            list.add(restotal);
        }

        return list;
    }




    /**
    *
     * @return null
     * @author 陈博云
     * @date 2023/3/30 19:33
     * 基准情况，输入数据，包装成三个省市的类，预测20年
     * public double[] helper(double[] e_cs,double[] e_p,double[] e_e,double[] e_gdp,
     *                            double UP_E_GDP,double UP_P,double  UP_GDP_P,double UP_CS_E,int n)
     */
    @RequestMapping(path = "/anticipate/basic")
    @ResponseBody
    public List<restotal> anticipatebasic(){
        List<restotal> list = new ArrayList<>();


        //获得北京数据
        double[] cs_beijing = new double[11];
        double[] p_beijing = new double[11];
        double[] e_beijing = new double[11];
        double[] gdp_beijing = new double[11];
        double[] coal_beijing = new double[11];
        for(int i = 2010;i<2021;i++){
            cs_beijing[i - 2010] = getData.gettotalemmission(i +"","北京");
            p_beijing[i - 2010] = getData.getpopulation(i +"","北京");
            e_beijing[i - 2010] = getData.getenergy(i +"","北京");
            gdp_beijing[i - 2010] = getData.getgdp(i +"","北京");
            coal_beijing[i-2010] = getData.getcoal(i+"","北京");
        }
        //获得天津数据
        double[] cs_tianjin = new double[11];
        double[] p_tianjin = new double[11];
        double[] e_tianjin = new double[11];
        double[] gdp_tianjin = new double[11];
        double[] coal_tianjin = new double[11];
        for(int i = 2010;i<2021;i++){
            cs_tianjin[i - 2010] = getData.gettotalemmission(i +"","天津");
            p_tianjin[i - 2010] = getData.getpopulation(i +"","天津");
            e_tianjin[i - 2010] = getData.getenergy(i +"","天津");
            gdp_tianjin[i - 2010] = getData.getgdp(i +"","天津");
            coal_tianjin[i-2010] = getData.getcoal(i+"","天津");
        }
        //获得河北数据
        double[] cs_hebei = new double[11];
        double[] p_hebei = new double[11];
        double[] e_hebei = new double[11];
        double[] gdp_hebei = new double[11];
        double[] coal_hebei = new double[11];
        for(int i = 2010;i<2021;i++){
            cs_hebei[i - 2010] = getData.gettotalemmission(i +"","河北");
            p_hebei[i - 2010] = getData.getpopulation(i +"","河北");
            e_hebei[i - 2010] = getData.getenergy(i +"","河北");
            gdp_hebei[i - 2010] = getData.getgdp(i +"","河北");
            coal_hebei[i-2010] = getData.getcoal(i+"","河北");
        }
        //计算北京
        double[] re_beijing = Anticipate2.helper(cs_beijing,p_beijing,e_beijing,gdp_beijing,coal_beijing,
                MyConstant.BASIC_GDP_BEIJING,MyConstant.BASIC_P_BEIJING,MyConstant.BASIC_E_BEIJING,
                MyConstant.BASIC_CARBON_BEIJING,3);
        //计算天津
        double[] re_tianjin = Anticipate2.helper(cs_tianjin,p_tianjin,e_tianjin,gdp_tianjin,coal_tianjin,
                MyConstant.BASIC_GDP_TIANJIN,MyConstant.BASIC_P_TIANJIN,MyConstant.BASIC_E_TIANJIN,
                MyConstant.BASIC_CARBON_TIANJIN,3);
        //计算河北
        double[] re_hebei = Anticipate2.helper(cs_hebei,p_hebei,e_hebei,gdp_hebei,coal_hebei,
                MyConstant.BASIC_GDP_HEBEI,MyConstant.BASIC_P_HEBEI,MyConstant.BASIC_E_HEBEI,
                MyConstant.BASIC_CARBON_HEBEI,3);

        for (int i = 0;i<re_beijing.length;i++){
            restotal restotal = new restotal();
            restotal.setYear(i+2021);
            restotal.setBeijing(re_beijing[i]);
            restotal.setTianjin(re_tianjin[i]);
            restotal.setHebei(re_hebei[i]);
            restotal.setSum(re_beijing[i]+re_tianjin[i]+re_hebei[i]);
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
        private double sum;
    }
}
