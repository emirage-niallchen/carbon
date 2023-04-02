//package top.emirage.carbon.entity;
//
//import com.alibaba.fastjson.annotation.JSONField;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @author ChenBoyun
// * @date 2023-03-26 22:41
// */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class LoginUser implements UserDetails {
//
//    private User user;
//
//
//
//    //存储权限信息
//    private List<String> permissions;
//
//
//    public LoginUser(User user,List<String> permissions) {
//        this.user = user;
//        this.permissions = permissions;
//    }
//    @JSONField(serialize = false)
//    private List<GrantedAuthority> authorities;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        if(authorities!=null){
//            return authorities;
//        }
//        //把permissions中字符串类型的权限信息转换成GrantedAuthority对象存入authorities中
//        authorities = permissions.stream().
//                map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//        return authorities;
//
//    }
//
//
//    public LoginUser(User user) {
//        this.user = user;
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//
//}
