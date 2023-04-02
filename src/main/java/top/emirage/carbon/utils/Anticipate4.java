package top.emirage.carbon.utils;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

/**
 * @author ChenBoyun
 */
public  class Anticipate4 {
    //输入历史数据，返回某个年份的预计值（基准乘预计增长）
    /**
     *                        X[1]    能源强度     e = E / GDP
     *                        X[2]    人口规模     p
     *                        X[3]    人均GDP     GDP/p
     *                        X[4]     能源结构    CS / E   =  c
     * @param  e_cs  碳排放量 double[]
     * @param e_p    人口数量  double[]
     * @param e_e    能源消费总量  double[]
     * @param e_gdp   GDP  double[]
     * @param UP_GDP  GDP预计增长
     * @param UP_P      人口增长
     * @param UP_E  能源增长
     * @param UP_C   煤炭使用量
     * @param n         计算未来年数  int
     * @return double[]  未来n年碳排放数量
     * @author 陈博云
     * @date 2023/3/21 17:20
     * 传入基本参数(碳排放量、人口数量、能源消费总量、GDP)，以及预计增长，输出未来 n 年的碳排放量
     * 改为人口变化，经济增长，煤炭使用量，能源消费变化；
     */
    public static double[] helper(double[] e_cs,double[] e_p,double[] e_e,double[] e_gdp,double[] e_carbon,
                                  double UP_GDP,double UP_P,double  UP_E,double UP_C,int n){
        double[] res = new double[n];
        double[] coe = get_coefficient(e_cs,e_p,e_e,e_gdp,e_carbon);//此时返回了 B0 B1 B2 B3 B4 这 5 个参数，用它构建另外一年的碳排放量
//此处应该获得新的一年的碳排放量,获得的系数是   人均GDP  人口规模  能源强度  能源结构
        int len = e_cs.length - 1;
        //新的一年的各种影响因素的值
        double n_gdp_p = e_gdp[len]/e_p[len];
        double n_p = e_p[len];
        double n_e_gdp = e_e[len]/e_gdp[len];
        double n_carbon_e = e_carbon[len]/e_e[len];
        for(int i = 0;i<n;i++){
            n_gdp_p= n_gdp_p*(1+UP_GDP)/(1+UP_P);
            n_p*=(1+UP_P);
            n_e_gdp = n_e_gdp*(1+UP_E)/(1+UP_GDP);
            n_carbon_e = n_carbon_e*(1+UP_C)/(1+UP_E);
            res[i] = new_carbon(coe,n_gdp_p,n_p,n_e_gdp,n_carbon_e);
        }
        return res;
    }
    /**
     * 输入系数列表，和四个增长率列表。返回下一年的碳排放量
     * @return null
     * @author 陈博云
     * @date 2023/3/21 18:41
     */
    public static double new_carbon(double[] coe,double gdp, double p,double e_gdp,double carbon_e){
        return coe[0] + coe[1]*gdp + coe[2]*p + coe[3]*e_gdp + coe[4]*carbon_e;
    }

    /**
     *传入基本参数，转化成需要的影响因子，并输入碳排放量
     * @param  cs
     * @param  p
     * @param  e
     * @param  gdp
     *
     * @return double[]  系数表（5个  包括 B0）
     * @author 陈博云
     * @date 2023/3/21 18:14
     * 输入：碳排放量、人口数量、能源消费总量、GDP、煤炭消费量
     * 影响因素：人口，经济，能源消费强度   能源结构
     * p
     * gdp
     * e/gdp
     * carbon/e
     */
    public static double[] get_coefficient(double[] cs,double[] p,double[] e,double[] gdp,double[] carbon){
        //人口规模  人均GDP  能源强度  能源结构
        int len = cs.length;
        double[] c_p = new double[len];//能源强度
        double[] c_gdp_p = new double[len];//人口
        double[] c_e_gdp = new double[len];//吨/万元  能源强度
        double[] c_carbon_e = new double[len];//能源结构
        double[][] X = new double[len][4];
        double[] Y = new double[len];
        for(int i = 0;i<len;i++){
            c_gdp_p[i] = gdp[i]/p[i];
            c_p[i] = p[i];
            c_e_gdp[i] = e[i]/gdp[i];
            c_carbon_e[i] = carbon[i]/e[i];
            Y[i] = cs[i];
            X[i][0] = c_gdp_p[i];
            X[i][1] = c_p[i];
            X[i][2] = c_e_gdp[i];
            X[i][3] = c_carbon_e[i];
        }
        OLSMultipleLinearRegression ols = new OLSMultipleLinearRegression();
        ols.newSampleData(Y,X);
        return ols.estimateRegressionParameters();

    }
}

