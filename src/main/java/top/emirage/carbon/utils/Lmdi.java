package top.emirage.carbon.utils;

/**
 * @author ChenBoyun
 * @date 2023-03-22 13:28
 * CS      碳排放总量
 * P         population_num
 * E          能源消费总量
 * GDP   economy  经济总量
 * ------------------------------
 * CS / E   =  c
 * E / GDP  =  e
 * GDP / P  =  g
 * P      =   p
 * ------------------------------
 * (CS[ i ] - CS[i -1]) / (ln CS[ i ] - ln CS[i-1]) *  ln(c[i] / c[i-1])    = a    1 开始   能源结构效应
 * (CS[ i ] - CS[i -1]) / (ln CS[ i ] - ln CS[i-1]) *  ln(e[i] / e[i-1])    = b
 * (CS[ i ] - CS[i -1]) / (ln CS[ i ] - ln CS[i-1]) *  ln(g[i] / g[i-1])   = c
 * (CS[ i ] - CS[i -1]) / (ln CS[ i ] - ln CS[i-1]) *  ln(p[i] / p[i-1])   = d    人口规模效应
 * ------------------------------
 * a+b+c+d = △CS
 */
public class Lmdi {


    private double[] r_c;
    private double[] r_e;
    private double[] r_g;
    private double[] r_p;
    private double[] sum;
    int len;
//计算某省份一个目标年到基年这段时间c 、e 、g 、p 四个影响因子的影响
    /**
    *  @param e_cs   碳排放总量数组
     * @param e_p    人口数数组
     * @param e_e    能源消费总量（折合成基准碳）数组
     * @param e_gdp  经济总量数组
     * @author 陈博云
     * @date 2023/3/22 13:34
     * 输入影响因子的数组，规整为计算需要的数组
     *  * CS / E   =  c
     *  * E / GDP  =  e
     *  * GDP / P  =  g
     *  * P      =   p
     *  (CS[ i ] - CS[i -1]) / (ln CS[ i ] - ln CS[i-1])
     */
    public void init(double[] e_cs,double[] e_p,double[] e_e,double[] e_gdp){
        double[] c;   //能源结构
        double[] e;   //能源消费强度
        double[] g;   //经济发展
        double[] p;   //人口规模
        double[] cs_cs;   //(CS[ i ] - CS[i -1]) / (ln CS[ i ] - ln CS[i-1])
        double[] ln_c;
        double[] ln_e;
        double[] ln_g;
        double[] ln_p;
        len = e_cs.length;
        c = new double[len];
        e = new double[len];
        g = new double[len];
        p = new double[len];
        cs_cs = new double[len-1];
        ln_c = new double[len-1];
        ln_e = new double[len-1];
        ln_g = new double[len-1];
        ln_p = new double[len-1];
        r_c = new double[len-1];
        r_e = new double[len-1];
        r_g = new double[len-1];
        r_p = new double[len-1];
        sum = new double[len-1];
        for(int i = 0;i<len;i++){
            c[i] = e_cs[i]/e_e[i];
            e[i] = e_e[i]/e_gdp[i];
            g[i] = e_gdp[i]/e_p[i];
            p[i] = e_p[i];
        }
        //Math.log(x)
        for(int i = 1;i<len;i++){
            double a;
            double b;
            a = e_cs[i] - e_cs[i-1];
            b = Math.log(e_cs[i]) - Math.log(e_cs[i-1]);
            cs_cs[i-1] = a/b;
            ln_c[i-1] = Math.log(c[i]/c[i-1]);
            ln_e[i-1] = Math.log(e[i]/e[i-1]);
            ln_g[i-1] = Math.log(g[i]/g[i-1]);
            ln_p[i-1] = Math.log(p[i]/p[i-1]);
            r_c[i-1] = cs_cs[i-1]*ln_c[i-1];
            r_e[i-1] = cs_cs[i-1]*ln_e[i-1];
            r_g[i-1] = cs_cs[i-1]*ln_g[i-1];
            r_p[i-1] = cs_cs[i-1]*ln_p[i-1];
            sum[i-1] = r_c[i-1]+r_e[i-1]+r_g[i-1]+r_p[i-1];
        }
        //返回 r_e     ==  cs_cs * ln_c;
    }

    public double[] getSum() {
        return sum;
    }

    public double[] getR_c() {
        return r_c;
    }

    public double[] getR_e() {
        return r_e;
    }

    public double[] getR_g() {
        return r_g;
    }

    public double[] getR_p() {
        return r_p;
    }

    public int getLen() {
        return len;
    }

    public void helper2(){}
}
