package top.emirage.carbon.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ChenBoyun
 * @date 2023-03-28 06:06
 */

@Component
public class GetData {





@Resource
private  RedisTemplate redisTemplate;
    /**
    * * @param year
     * @return province
     * @author 陈博云
     * @date 2023/3/28 6:07
     * 输入省份，年份，返回他的碳排放总量
     */


    public double gettotalemmission(String year,String province){
        String key_energy_em = RedisKeyUtil.getCarbonTotalProvinceYearKey(province);
        String key_agriculture_em = RedisKeyUtil.getCarbonAgricultureProvinceKey(province);
        String key_hum_em = RedisKeyUtil.getCarbonHumProvinceYearKey(province);
        String key_industrial_em = RedisKeyUtil.getCarbonIndustrialProvinceYearKey(province);
        String key_waste_em = RedisKeyUtil.getCarbonWasteProvinceYearKey(province);
        String key_husbandry_em = RedisKeyUtil.getCarbonHusbandryProvinceYearKey(province);

        double sum = 0 ;
        sum =(double) redisTemplate.opsForHash().get(key_energy_em,year)+
                (double) redisTemplate.opsForHash().get(key_agriculture_em,year) +
                (double) redisTemplate.opsForHash().get(key_hum_em,year)+
                (double) redisTemplate.opsForHash().get(key_industrial_em,year) +
                (double) redisTemplate.opsForHash().get(key_waste_em,year) +
                (double) redisTemplate.opsForHash().get(key_husbandry_em,year) ;
        return sum;
    }

    public double getenergyemmission(String year,String province){
        String key_energy_em = RedisKeyUtil.getCarbonTotalProvinceYearKey(province);
        return (double) redisTemplate.opsForHash().get(key_energy_em,year);
    }
    public double getagricultureemmission(String year,String province){
        String key_agriculture_em = RedisKeyUtil.getCarbonAgricultureProvinceKey(province);
        return (double) redisTemplate.opsForHash().get(key_agriculture_em,year);
    }
    public double gethumemmission(String year,String province){
        String key_hum_em = RedisKeyUtil.getCarbonHumProvinceYearKey(province);
        return (double) redisTemplate.opsForHash().get(key_hum_em,year);
    }
    public double getindustrialemmission(String year,String province){
        String key_industrial_em = RedisKeyUtil.getCarbonIndustrialProvinceYearKey(province);
        return (double) redisTemplate.opsForHash().get(key_industrial_em,year);
    }
    public double getwasteemmission(String year,String province){
        String key_waste_em = RedisKeyUtil.getCarbonWasteProvinceYearKey(province);
        return (double) redisTemplate.opsForHash().get(key_waste_em,year);
    }
    public double gethusbandryemmission(String year,String province){
        String key_husbandry_em = RedisKeyUtil.getCarbonHusbandryProvinceYearKey(province);
        return (double) redisTemplate.opsForHash().get(key_husbandry_em,year);
    }
    public double getplantprovince(String year,String province){
        String key_plant = RedisKeyUtil.getCarbonPlantCoverProvinceYearKey(province);
        return (double) redisTemplate.opsForHash().get(key_plant,year);
    }
    public double getgdp(String year,String province){
        String key_gdp = RedisKeyUtil.getGdpProvinceYearKey(province);
        return (double) redisTemplate.opsForHash().get(key_gdp,year);
    }
    public double getpopulation(String year,String province){
        String key_poppulation = RedisKeyUtil.getPopulationProvinceYearKey(province);
        return (double) redisTemplate.opsForHash().get(key_poppulation,year);
    }
    public double getenergy(String year,String province){
        String key_energy = RedisKeyUtil.getEnergyYearKey(province);
        return (double) redisTemplate.opsForHash().get(key_energy,year);
    }

    public double getcoal(String year,String province){
        String key_carbon_use = RedisKeyUtil.getCarbonUseYearKey(province);
        return (double) redisTemplate.opsForHash().get(key_carbon_use,year);
    }

    /**
     * * @param year
     * @return province
     * @author 陈博云
     * @date 2023/3/28 6:07
     * 输入省份，年份，返回他的碳排放强度
     * CS/economy_num
     * 万吨/亿元
     */
        public double get_CS_GDP(String year,String province){
            double r = gettotalemmission(year,province)/getgdp(year,province);
            return r;
        }

    /**
     * * @param year
     * @return province
     * @author 陈博云
     * @date 2023/3/28 6:07
     * 输入省份，年份，返回他的人均碳排放数
     */
    public double get_CS_population(String year,String province){
        double r = gettotalemmission(year,province)/getpopulation(year,province);
        return r;
    }


    /**
     * * @param year
     * @return province
     * @author 陈博云
     * @date 2023/3/28 6:07
     * 输入省份，年份，返回他的生态承载力
     */
    public double get_CP(String year,String province){
        String key = RedisKeyUtil.getPlantCoverProvinceYearKey(province);

        double r = (double) redisTemplate.opsForHash().get(key,year);
        return r;
    }
    /**
     * * @param year
     * @return province
     * @author 陈博云
     * @date 2023/3/28 6:07
     * 输入省份，年份，返回他的碳足迹
     * (万公顷)
     */

    public double get_CF(String year,String province){

        double r = gettotalemmission(year,province)*(get_CP(year,province)/getplantprovince(year,province));
        return r;
    }

    public double get_CC(String year,String province){

        double r = get_CP(year,province)-get_CF(year,province);
        return r;
    }

}
