package top.emirage.carbon.interceptor;

import cn.dev33.satoken.stp.StpUtil;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.emirage.carbon.annotation.PassToken;
import top.emirage.carbon.annotation.UserLoginToken;
import top.emirage.carbon.entity.User;
import top.emirage.carbon.service.Impl.UserServiceImpl;

//import top.emirage.carbon.utils.TokenUtils;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;


/**
 * @author ChenBoyun
 * @date 2023-03-31 18:39
 */
@Component
public class LoginInterceptor extends R implements HandlerInterceptor {
    /**
     * 目标方法执行前
     * 该方法在控制器处理请求方法前执行，其返回值表示是否中断后续操作
     * 返回 true 表示继续向下执行，返回 false 表示中断后续操作
     *
     * @return
     */
    @Resource
    private UserServiceImpl userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean login = StpUtil.isLogin();
        StpUtil.getLoginId();//
        if(login) {
            return true;
        } else {
            request.getRequestDispatcher("/login");
            return false;
        }
    }




    /**
     * 目标方法执行后
     * 该方法在控制器处理请求方法调用之后、解析视图之前执行
     * 可以通过此方法对请求域中的模型和视图做进一步修改
     */
    @Override
    public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {
        System.out.println("postHandle执行{}");

    }
    /**
     * 页面渲染后
     * 该方法在视图渲染结束后执行
     * 可以通过此方法实现资源清理、记录日志信息等工作
     */
    @Override
    public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object handler, Exception
            ex) throws Exception {
        System.out.println("afterCompletion执行异常");

    }

}
