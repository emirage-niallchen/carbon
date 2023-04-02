package top.emirage.carbon.utils;

public interface MyConstant {
    // 碳排放增长率 GDP  人口  能源使用量  碳使用量
    //北京
    double BASIC_GDP_BEIJING = 0.054;
    double HIGH_GDP_BEIJING = 0.054;
    double LOW_GDP_BEIJING = 0.054;

    double BASIC_P_BEIJING = 0.03;
    double HIGH_P_BEIJING = 0.027;
    double LOW_P_BEIJING = 0.01;

    double BASIC_E_BEIJING = 0.015;
    double HIGH_E_BEIJING = 0.0425;
    double LOW_E_BEIJING = 0.014;

    double BASIC_CARBON_BEIJING = -0.01;
    double HIGH_CARBON_BEIJING = 0.01;
    double LOW_CARBON_BEIJING = -0.01;
    //天津
    double BASIC_GDP_TIANJIN = 0.052;
    double HIGH_GDP_TIANJIN = 0.065;
    double LOW_GDP_TIANJIN = 0.045;

    double BASIC_P_TIANJIN = 0.009;
    double HIGH_P_TIANJIN = 0.01;
    double LOW_P_TIANJIN = 0.0058;

    double BASIC_E_TIANJIN = 0.0477;
    double HIGH_E_TIANJIN = 0.0525;
    double LOW_E_TIANJIN = 0.0396;

    double BASIC_CARBON_TIANJIN = -0.03;
    double HIGH_CARBON_TIANJIN = -0.05;
    double LOW_CARBON_TIANJIN = -0.05;


    //河北
    double BASIC_GDP_HEBEI = 0.052;
    double HIGH_GDP_HEBEI = 0.065;
    double LOW_GDP_HEBEI = 0.045;

    double BASIC_P_HEBEI = 0.008;
    double HIGH_P_HEBEI = 0.018;
    double LOW_P_HEBEI = 0.013;

    double BASIC_E_HEBEI = 0.0477;
    double HIGH_E_HEBEI = 0.065;
    double LOW_E_HEBEI = 0.0396;

    double BASIC_CARBON_HEBEI = 0.01;
    double HIGH_CARBON_HEBEI = -0.05;
    double LOW_CARBON_HEBEI = -0.05;

    //0.4*0.4*0.95   垃圾焚烧   0.152
    //0.167*0.285    垃圾填埋
    //0.25   *12/16
    double CARBON_EMISSION_WA_INCINERATION = 0.152;
    double CARBON_EMISSION_WA_LANDFILL = 0.047595;
    double CARBON_EMISSION_WA_OX = 0.1875;


    //    # 能源系数
//en_coal     0.72
//en_oil      0.55
//en_gas     0.42
    double CARBON_EMISSION_EN_TOTAL = 0.68;

    //# 工业系数
//in_steel               1.06     tCO2/t
//in_cement          0.136   tCO2/t
//in_ammonia       3.273   tCO2/t
    //一吨这个工业产品产生多少二氧化碳
    double CARBON_EMISSION_IN_STEEL = 0.289;
    double CARBON_EMISSION_IN_CEMENT = 0.037;
    double CARBON_EMISSION_IN_AMMONIA = 0.893;
    //之后应该   * 12/44(数值已修正)
//# 农业
//## 农业
//ag_fertilizer 0.857 54(t /t)   // 化肥
//ag_irrigation   0.26648(t /hm2)  //灌溉
//ag_machinery_a  0.001647   t/hm2 农机
//ag_machinery_b  0.00018    t/kW   农机与面积
    //这个排放的是碳，不需要乘   12*44
    double CARBON_EMISSION_AG_FERTILIZER = 0.85754;
    double CARBON_EMISSION_AG_IRRIGATION = 0.26648;
    double CARBON_EMISSION_AG_MACHINERY_A = 0.001647;
    double CARBON_EMISSION_AG_MACHINERY_B = 0.00018;//吨、万千瓦   0.00018吨/万千瓦
    //## 畜牧业
//排放的CH4
//hu_pig       1      +3.2    = 4.2      t/万头/年
//hu_cow      80    +7   = 87
//hu_sheep    8.2  +0.15   =  8.35
//hu_horse   18    +1.09   = 19.09
//hu_donkey  10   +0.6    = 10.6
//hu_mule       10  +0.6   =  10.6
//应该乘   12/16
    //万头 --》31.5吨
    double CARBON_EMISSION_HU_PIG = 0.0315;
    double CARBON_EMISSION_HU_COW = 0.6525;
    double CARBON_EMISSION_HU__SHEEP = 0.062625;
    double CARBON_EMISSION_HU_HORSE = 0.0143175;
    double CARBON_EMISSION_HU_DONKEY = 79.5;
    double CARBON_EMISSION_HU_MULE = 79.5;
    //# 人口呼吸系数
//hum           0.35     t/a
    double CARBON_EMISSION_HUMAN = 0.35;
//# 植被覆盖
//pl_meadow           0.948   t/hm2                 草地
//pl_forest                    3.81   t/hm2              森林
//pl_farmland                 4.05   t/hm2              农田
//pl_greening                 2.379  t/hm2              绿化


    double CARBON_ABSORPTION_PL_MEADOW = 0.948;
    double CARBON_ABSORPTION_PL_FOREST = 3.81;
    double CARBON_ABSORPTION_PL_FARMLAND = 4.05;
    double CARBON_ABSORPTION_PL_GREENING = 2.379;
//# 折煤系数
//co_coal      煤炭：    0.7143
//co_oil         石油：1.4286
//co_gas        天然气1.33
//
//
//# 脱钩
//strong
//weak
//recession
//strong_negative
//weak_negative
//expansive_negative
//expansive_connections
//decay_connection


    //碳吸收系数
    double FOREST = 3.81;
    double FARMLAND = 4.05;
    double GREENING = 2.379;

}
