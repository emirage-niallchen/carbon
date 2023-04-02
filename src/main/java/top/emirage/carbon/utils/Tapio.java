package top.emirage.carbon.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
*  脱钩       强脱钩                <0           >0               e<0                    0      strong
 * 脱钩       弱脱钩                >0           >0             0<e<0.8                  1      weak
 * 脱钩       衰退脱钩              <0           <0             e>1.2                    2       recession
 * 负脱钩     强负脱钩              >0           <0             e<0                      3        strong_negative
 * 负脱钩     负弱脱钩              <0           <0             0<e<0.8                  4        weak_negative
 * 负脱钩     扩张性负脱钩          >0           >0             e>1.2                     5       expansive_negative
 * 连接       扩张性连接           >0           >0             0.8<e<1.2                 6       expansive_connections
 * 连接       衰退连接             <0          <0             0.8<e<1.2                  7       decay_connection
 * @author ChenBoyun
 * @date 2023-03-21 15:20
 *
 * gdp = double[]    GDP
 * c = double[]      碳排放量
 * e = (c[i]-c[i-1])*gdp[i-1]/(gdp[i]-gdp[i-1])*c[i-1]
 *    e = CE/DP
 */
public  class Tapio {
    //传递来两个数组，返回一个decoupling数组，封装脱钩状态
    public static List<Decoupling> helper(double[] gdp,double[] c){

        double ex_gdp;
        double ex_c;
        double  e;
        String type;
        int len = gdp.length;
        List<Decoupling> res = new LinkedList<>();
        for(int i = 1;i<len;i++){

            ex_gdp = gdp[i]-gdp[i-1];
            ex_c = c[i]-c[i-1];
            e = (ex_c*gdp[i-1])/(ex_gdp*c[i-1]);
            ex_gdp /=gdp[i-1];
            ex_c /=c[i-1];
            /*
*  脱钩       强脱钩                <0           >0               e<0                    0      strong
* 脱钩       衰退脱钩              <0           <0             e>1.2                    2       recession
* 负脱钩     负弱脱钩              <0           <0             0<e<0.8                  4        weak_negative
* 连接       衰退连接             <0          <0             0.8<e<1.2                  7       decay_connection
*
* 脱钩       弱脱钩                >0           >0             0<e<0.8                  1      weak
* 负脱钩     扩张性负脱钩          >0           >0             e>1.2                     5       expansive_negative
* 连接       扩张性连接           >0           >0             0.8<e<1.2                 6       expansive_connections
* 负脱钩     强负脱钩              >0           <0             e<0                      3        strong_negative
            */
            if(ex_c<0){
                if(ex_gdp>0){
                    type="强脱钩";
                }
                else{
                    if(e>1.2){
                        type = "衰退脱钩";
                    }else if(0<e&&e<0.8){
                        type = "负弱脱钩";
                    }else{
                        type = "衰退连接";
                    }
                }
            }
            else{
                if(ex_gdp>0){
                    if(0<e&&e<0.8){
                        type = "弱脱钩";
                    }else if(e>1.2){
                        type = "扩张性负脱钩";
                    }else{
                        type = "扩张性连接";
                    }
                }
                else{
                    type="强负脱钩";
                }
            }
            Decoupling decoupling = new Decoupling(2010+i,(double) Math.round(ex_c * 10000) / 10000,
                    (double) Math.round(ex_gdp * 10000) / 10000,(double) Math.round(e * 10000) / 10000,type);
            res.add(decoupling);
        }
        return res;
    }
}
