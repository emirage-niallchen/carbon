//package top.emirage.carbon.config;
//
//import javax.servlet.http.HttpServletRequestWrapper;
//import java.util.*;
//
///**
// * @author ChenBoyun
// * @date 2023-04-01 08:40
// */
//public class HttpServletRequest extends HttpServletRequestWrapper {
//    public HttpServletRequest(javax.servlet.http.HttpServletRequest request) {
//
////        addHeader("token", request.getAttribute("token").toString());
//        super(request);
//    }
//
//    // 用于存放自定义header的map
//    private Map<String, String> headerMap = new HashMap<>();
//
//    /**
//     * 在header中添加key-value
//     */
//    public void addHeader(String key, String value) {
//        headerMap.put(key, value);
//    }
//
//    @Override
//    public String getHeader(String name) {
//        String headerValue = super.getHeader(name);
//        if (headerMap.containsKey(name)) {
//            headerValue = headerMap.get(name);
//        }
//        return headerValue;
//    }
//
//    /**
//     * 需要重写的方法，即获取请求头Key时，加上自定义请求头内容的key
//     * get the Header names
//     */
//    @Override
//    public Enumeration<String> getHeaderNames() {
//        List<String> names = Collections.list(super.getHeaderNames());
//        for (String name : headerMap.keySet()) {
//            names.add(name);
//        }
//        return Collections.enumeration(names);
//    }
//
//    /**
//     * 需要重写的方法，获取所有的header参数时，添加上自定义header的map
//     * get the Header key-value
//     */
//    @Override
//    public Enumeration<String> getHeaders(String name) {
//        List<String> values = Collections.list(super.getHeaders(name));
//        if (headerMap.containsKey(name)) {
//            values = Arrays.asList(headerMap.get(name));
//        }
//        return Collections.enumeration(values);
//    }
//}
