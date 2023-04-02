package top.emirage.carbon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.emirage.carbon.interceptor.LoginInterceptor;

import javax.annotation.Resource;

/**
 * @author ChenBoyun
 * @date 2023-03-31 18:25
 */

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自己的拦截器,并设置拦截的请求路径
        //addPathPatterns为拦截此请求路径的请求
        //excludePathPatterns为不拦截此路径的请求
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/agriculture/*")
                .addPathPatterns("/basic/*")
                .addPathPatterns("/energy/*")
                .addPathPatterns("/husbandry/*")
                .addPathPatterns("/industrial/*")
                .addPathPatterns("/plant_cover/*")
                .addPathPatterns("/waste/*")
                .addPathPatterns("/user/*")
                .excludePathPatterns("/story/sendSMS")
                .excludePathPatterns("/story/signOrRegister");
    }
}
