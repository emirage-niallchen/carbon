package top.emirage.carbon.utils;

/**
 * @author ChenBoyun
 * @date 2023-03-21 15:28
 */
public class Decoupling {
    private int year;

    public Decoupling(int year, double ex_carbon, double ex_gdp, double elasticity, String type) {
        this.year = year;
        this.ex_carbon = ex_carbon;
        this.ex_gdp = ex_gdp;
        this.elasticity = elasticity;
        this.type = type;
    }

    private double ex_carbon;
    private double ex_gdp;
    private double elasticity;
    private String type;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Decoupling{" +
                "碳增长=" + ex_carbon +
                ", GDP增长=" + ex_gdp +
                ", 脱钩值=" + elasticity +
                ", type=" + type +
                '}';
    }

    public double getEx_carbon() {
        return ex_carbon;
    }

    public void setEx_carbon(double ex_carbon) {
        this.ex_carbon = ex_carbon;
    }

    public Decoupling(double ex_carbon, double ex_gdp, double elasticity, String type) {
        this.ex_carbon = ex_carbon;
        this.ex_gdp = ex_gdp;
        this.elasticity = elasticity;
        this.type = type;
    }

    public double getEx_gdp() {
        return ex_gdp;
    }

    public void setEx_gdp(double ex_gdp) {
        this.ex_gdp = ex_gdp;
    }

    public double getElasticity() {
        return elasticity;
    }

    public void setElasticity(double elasticity) {
        this.elasticity = elasticity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
