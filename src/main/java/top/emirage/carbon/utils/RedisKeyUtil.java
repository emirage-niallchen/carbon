package top.emirage.carbon.utils;

/**
 * @author ChenBoyun
 * @date 2023-03-28 01:28
 */
public class RedisKeyUtil {
    private static final String SPLIT = ":";
    private static final String CARBON_TOTAL = "carbon:total";
    private static final String CARBON_AGRICULTURE = "carbon:agriculture";
    private static final String CARBON_HUSBANDRY = "carbon:husbandry";
    private static final String CARBON_INDUSTRIAL = "carbon:industrial";
    private static final String CARBON_PLANT_COVER = "carbon:plant:cover";
    private static final String CARBON_WASTE = "carbon:waste";
    private static final String CARBON_HUM = "carbon:hum";
    private static final String GDP = "gdp";
    private static final String POPULATION = "population";
    private static final String PLANT_COVER = "plant:cover";   //植被覆盖面积
    private static final String ENERGY= "energy";
    private static final String CARBON_USE= "carbon:use";

    public static String getCarbonUseYearKey(String province){
        return CARBON_USE + SPLIT + province;
    }

    public static String getEnergyYearKey(String province){
        return ENERGY + SPLIT + province;
    }


    public static String getPlantCoverProvinceYearKey(String province){
        return PLANT_COVER + SPLIT + province;
    }

    public static String getCarbonHumProvinceYearKey(String province){

        return CARBON_HUM + SPLIT + province;
    }

    public static String getCarbonTotalProvinceYearKey(String province) {
        return CARBON_TOTAL + SPLIT + province;
    }
    public static String getCarbonAgricultureProvinceKey(String province) {
        return CARBON_AGRICULTURE + SPLIT + province;
    }
    public static String getCarbonHusbandryProvinceYearKey(String province) {
        return CARBON_HUSBANDRY + SPLIT + province;
    }
    public static String getCarbonIndustrialProvinceYearKey(String province) {
        return CARBON_INDUSTRIAL + SPLIT + province;
    }
    public static String getCarbonPlantCoverProvinceYearKey(String province) {
        return CARBON_PLANT_COVER + SPLIT + province;
    }
    public static String getCarbonWasteProvinceYearKey(String province) {
        return CARBON_WASTE + SPLIT + province;
    }
    public static String getGdpProvinceYearKey(String province) {
        return GDP + SPLIT + province;
    }
    public static String getPopulationProvinceYearKey(String province) {
        return POPULATION + SPLIT + province;
    }

}
