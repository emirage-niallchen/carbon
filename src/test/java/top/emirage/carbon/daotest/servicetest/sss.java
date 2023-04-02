package top.emirage.carbon.daotest.servicetest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.emirage.carbon.CarbonApplication;
import top.emirage.carbon.controller.IndexController;
import top.emirage.carbon.utils.*;

/**
 * @author ChenBoyun
 * @date 2023-03-29 17:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarbonApplication.class)
public class sss {

    @Autowired
    private GetData getData;
    @Autowired
    IndexController indexController;

    @Test
    public void  sss(){
        //获得北京数据
        double[] cs_beijing = new double[11];
        double[] p_beijing = new double[11];
        double[] e_beijing = new double[11];
        double[] gdp_beijing = new double[11];
        double[] coal_beijing = new double[11];
        for(int i = 2010;i<2021;i++){
            cs_beijing[i - 2010] = getData.gettotalemmission(i +"","河北");
            p_beijing[i - 2010] = getData.getpopulation(i +"","河北");
            e_beijing[i - 2010] = getData.getenergy(i +"","河北");
            gdp_beijing[i - 2010] = getData.getgdp(i +"","河北");
            coal_beijing[i-2010] = getData.getcoal(i+"","河北");
        }
        System.out.println("总量"+cs_beijing[10]);
        System.out.println("人口"+p_beijing[10]);
        System.out.println("能源总量"+e_beijing[10]);
        System.out.println("GDP"+gdp_beijing[10]);

        double[] a = Anticipate2.get_coefficient(cs_beijing,p_beijing,e_beijing,gdp_beijing,coal_beijing);
        for (int i = 0;i< a.length;i++){
            System.out.println(a[i]);
        }

    }
}
