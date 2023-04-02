package top.emirage.carbon.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import top.emirage.carbon.entity.*;
import top.emirage.carbon.service.Impl.*;

import java.util.List;

/**
 * @author ChenBoyun
 * @date 2023-03-28 02:42
 * 这个类，吊用他的所有函数之后把 五个碳来源，碳汇，GDP，人口，全都存进了REDIS
 */
@Component
public class RedisCache {
    @Autowired
    private EnergyServiceImpl energyService;
    @Autowired
    private AgricultureServiceImpl agricultureService;
    @Autowired
    private HusbandryServiceImpl husbandryService;
    @Autowired
    private IndustrialServiceImpl industrialService;
    @Autowired
    private Plant_coverServiceImpl plantCoverService;
    @Autowired
    private WasteServiceImpl wasteService;
    @Autowired
    private BasicServiceImpl basicService;
    @Autowired
    private RedisTemplate redisTemplate;

/**
*
 * @return null
 * @author 陈博云
 * @date 2023/3/28 5:04
 * 计算碳汇
 * 缓存碳汇   植被面积
 */

    public void pantcoverabsorption(){
        List<Plant_cover> list = plantCoverService.list();
        if(!list.isEmpty()){
            for(int i = 0;i<list.size();i++){
                Plant_cover plant_cover = list.get(i);
                String key = RedisKeyUtil.getCarbonPlantCoverProvinceYearKey(plant_cover.getProvince());
                String plant_cover_key = RedisKeyUtil.getPlantCoverProvinceYearKey(plant_cover.getProvince());
                double forest_num = Double.parseDouble(plant_cover.getForest());
                double farmland_num = Double.parseDouble(plant_cover.getFarmland());
                double greening_num = Double.parseDouble(plant_cover.getGreening());
                double r =farmland_num*MyConstant.FARMLAND+
                        forest_num*MyConstant.FOREST+
                        greening_num*MyConstant.GREENING;
                double area = forest_num+farmland_num+greening_num;
                redisTemplate.opsForHash().put(key,plant_cover.getYear(),r);
                redisTemplate.opsForHash().put(plant_cover_key,plant_cover.getYear(),area);
            }
        }
    }



    /**
     *
     * @return null
     * @author 陈博云
     * @date 2023/3/28 4:47
     * 废弃物处理碳排放
     * (万吨)
     */
    public void wasteemmission(){
        List<Waste> list = wasteService.list();
        if(!list.isEmpty()){
            for(int i = 0;i<list.size();i++){
                Waste waste = list.get(i);
                String key = RedisKeyUtil.getCarbonWasteProvinceYearKey(waste.getProvince());
                double incineration_num = Double.parseDouble(waste.getIncineration());
                double landfill_num = Double.parseDouble(waste.getLandfill());
                double ox_num = Double.parseDouble(waste.getOxygen());
                double r =incineration_num*MyConstant.CARBON_EMISSION_WA_INCINERATION+
                        landfill_num*MyConstant.CARBON_EMISSION_WA_LANDFILL+
                        ox_num*MyConstant.CARBON_EMISSION_WA_OX;
                redisTemplate.opsForHash().put(key,waste.getYear(),r);
            }
        }
    }


    /**
     *
     * @return null
     * @author 陈博云
     * @date 2023/3/28 4:14
     * 工业生产碳排放
     * (steel_num*in_steel   +   cement_num*in_cement   +   ammonia_num*in_ammonia)*12/44
     */

    public  void industrialemmission(){
        List<Industrial> list = industrialService.list();
        if(!list.isEmpty()){
            for(int i = 0;i<list.size();i++){
                Industrial industrial = list.get(i);
                String key = RedisKeyUtil.getCarbonIndustrialProvinceYearKey(industrial.getProvince());
                double steel_num = Double.parseDouble(industrial.getSteel());
                double cement_num = Double.parseDouble(industrial.getCement());
                double ammonia_num = Double.parseDouble(industrial.getAmmonia());
                double r =steel_num*MyConstant.CARBON_EMISSION_IN_STEEL+
                        cement_num*MyConstant.CARBON_EMISSION_IN_CEMENT+
                        ammonia_num*MyConstant.CARBON_EMISSION_IN_AMMONIA;
                redisTemplate.opsForHash().put(key,industrial.getYear(),r);
            }
        }
    }


    /**
     *
     * @return null
     * @author 陈博云
     * @date 2023/3/28 4:13
     * 人口呼吸碳排放
     * CEhum = Numpeople × 0.035
     * (万吨)
     */

    public  void peopleemmission(){
        List<Basic> list = basicService.list();
        if(!list.isEmpty()){
            for(int i = 0;i<list.size();i++){
                Basic basic = list.get(i);
                String key = RedisKeyUtil.getCarbonHumProvinceYearKey(basic.getProvince());
                String key_gdp = RedisKeyUtil.getGdpProvinceYearKey(basic.getProvince());
                String key_population = RedisKeyUtil.getPopulationProvinceYearKey(basic.getProvince());
                double population_num = Double.parseDouble(basic.getPopulation());
                double r =population_num*MyConstant.CARBON_EMISSION_HUMAN;
                redisTemplate.opsForHash().put(key,basic.getYear(),r);
                redisTemplate.opsForHash().put(key_gdp,basic.getYear(),Double.parseDouble(basic.getEconomy()));
                redisTemplate.opsForHash().put(key_population,basic.getYear(),Double.parseDouble(basic.getPopulation()));
            }
        }
    }


    /**
     *
     * @return null
     * @author 陈博云
     * @date 2023/3/28 4:13
     *  畜牧业碳排放
     *  E=E1+E2+E3+E4+E5+E6
     * =hu_pig*pig_num  +  hu_cow*cow_num  +  hu_sheep*sheep_num  +
     * hu_horse*horse_num  +  hu_donkey*donkey_num  +  hu_mule*mule_num
     * （万吨）
     */

    public  void husbandryemmission(){
        List<Husbandry> list = husbandryService.list();
        if(!list.isEmpty()){
            for(int i = 0;i<list.size();i++){
                Husbandry husbandry = list.get(i);
                String key = RedisKeyUtil.getCarbonHusbandryProvinceYearKey(husbandry.getProvince());
                double pig_num = Double.parseDouble(husbandry.getPig());
                double cow_num = Double.parseDouble(husbandry.getCow());
                double sheep_num = Double.parseDouble(husbandry.getSheep());

                double r = pig_num*MyConstant.CARBON_EMISSION_HU_PIG+
                        cow_num*MyConstant.CARBON_EMISSION_HU_COW+
                        sheep_num*MyConstant.CARBON_EMISSION_HU__SHEEP;
                redisTemplate.opsForHash().put(key,husbandry.getYear(),r);
            }
        }
    }


    /**
    *
     * @return null
     * @author 陈博云
     * @date 2023/3/28 2:45
     * 计算农业的碳排放并放到redis
     * E=E1+E2+E3
     * E1=ag_fertilizer*fertilizer_num
     * E2=area_num*ag_machinery_a   +   ag_machinery_b*machinery_num
     * E3=irrigation_num*ag_irrigation
     */
    public void agricultureemission(){
        List<Agriculture> list = agricultureService.list();
        if(!list.isEmpty()){
            for(int i = 0;i<list.size();i++){
               Agriculture agriculture = list.get(i);
                String key = RedisKeyUtil.getCarbonAgricultureProvinceKey(agriculture.getProvince());
                double fertilizer_num = Double.parseDouble(agriculture.getFertilizer());
                double area_num = Double.parseDouble(agriculture.getArea());
                double machinery_num = Double.parseDouble(agriculture.getMachinery());
                double irrigation_num = Double.parseDouble(agriculture.getIrrigation());

                double r = fertilizer_num*MyConstant.CARBON_EMISSION_AG_FERTILIZER+
                        area_num*MyConstant.CARBON_EMISSION_AG_MACHINERY_A +
                        machinery_num * MyConstant.CARBON_EMISSION_AG_MACHINERY_B+
                        irrigation_num*MyConstant.CARBON_EMISSION_AG_IRRIGATION;
                redisTemplate.opsForHash().put(key,agriculture.getYear(),r);
            }
        }
    }

    /**
     * @param
     * @return void
     * @author 陈博云
     * @date 2023/3/28 2:45
     * 将京津冀能源排放记录到redis
     * (万吨)
     */
    public void energyemission(){
        List<Energy> list = energyService.list();
        if(!list.isEmpty()){
            for(int i = 0;i<list.size();i++){
                Energy energy = list.get(i);
                String key = RedisKeyUtil.getCarbonTotalProvinceYearKey(energy.getProvince());
                double r = Double.parseDouble(energy.getTotal())*MyConstant.CARBON_EMISSION_EN_TOTAL;
                redisTemplate.opsForHash().put(key,energy.getYear(),r);
            }
        }

    }



}
